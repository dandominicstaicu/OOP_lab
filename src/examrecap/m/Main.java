// Credits Mario Sampetru 321CA 2024

package examrecap.m;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}

class Read {
    private int boardSize;
    private final LinkedList<Character> characters = new LinkedList<>();

    public void read() {
        Scanner scan = new Scanner(System.in);
        boardSize = scan.nextInt();

        MovePacMan movePacMan = new MovePacMan();
        movePacMan.setBoardSize(boardSize);
        characters.add(new PacMan("PacMan", movePacMan,
                new Coordinate(scan.nextInt(), scan.nextInt())));

        int nrRedGhost = scan.nextInt();
        for (int i = 0; i < nrRedGhost; i++) {
            characters.add(new RedGhost("RedGhost", new MoveRedGhost(),
                    new Coordinate(scan.nextInt(), scan.nextInt()), Direction.LEFT));
        }

        int nrBlueGhost = scan.nextInt();
        for (int i = 0; i < nrBlueGhost; i++) {
            characters.add(new BlueGhost("BlueGhost", new MoveBlueGhost(),
                    new Coordinate(scan.nextInt(), scan.nextInt()), Direction.DOWN));

        }

        int nrMoves = scan.nextInt();
        for (int i = 0; i < nrMoves; i++) {
            getPacMan().getMoves().add(scan.next());
        }

        scan.close();
    }

    private PacMan getPacMan() {
        return (PacMan) characters.get(0);
    }

    public int getBoardSize() {
        return boardSize;
    }

    public LinkedList<Character> getCharacters() {
        return characters;
    }
}

class Game {
    private Read read = new Read();
    private int boardSize;
    private LinkedList<Character> characters = new LinkedList<>(); // First element is PacMan
    private boolean isPacManAlive;

    private void setEnvironment() {
        boardSize = read.getBoardSize();
        characters = read.getCharacters();
    }

    public void play() {
        read.read();
        setEnvironment();
        simulateMoves();
        printResult();
    }

    private void printResult() {
        getPacMan().print();
        characters.remove(0);

        sortGhosts();

        for (Character character : characters) {
            character.print();
        }
    }

    private void simulateMoves() {
        isPacManAlive = true;

        List<String> moves = getPacMan().getMoves();
        PacMan pacMan = getPacMan();
        for (String move : moves) {
            pacMan.move(pacMan.getCoordinate(), move.charAt(0));

            for (int j = 1; j < characters.size(); j++) {
                Character character = characters.get(j);
                character.move(character.getCoordinate(), character.getDirection());

                if (compareCoordinates(pacMan.getCoordinate(), character.getCoordinate())) {
                    isPacManAlive = false;
                    return;
                }
            }

            checkReverseDirectionBlueGhosts();
            checkReverseDirectionRedGhosts();
        }
    }

    private boolean compareCoordinates(Coordinate coordinate1, Coordinate coordinate2) {
        return coordinate1.getX() == coordinate2.getX()
                && coordinate1.getY() == coordinate2.getY();
    }

    private void checkReverseDirectionBlueGhosts() {
        List<BlueGhost> blueGhosts = getBlueGhosts();

        for (BlueGhost blueGhost : blueGhosts) {
            if (blueGhost.getCoordinate().getY() <= 1) {
                blueGhost.setDirection(Direction.UP);
                blueGhost.getCoordinate().setY(1);
            } else if (blueGhost.getCoordinate().getY() == boardSize) {
                blueGhost.setDirection(Direction.DOWN);
            }
        }
    }

    private void checkReverseDirectionRedGhosts() {
        List<RedGhost> redGhosts = getRedGhosts();

        for (RedGhost redGhost : redGhosts) {
            if (redGhost.getCoordinate().getX() == 1) {
                redGhost.setDirection(Direction.RIGHT);
            } else if (redGhost.getCoordinate().getX() == boardSize) {
                redGhost.setDirection(Direction.LEFT);
            }
        }
    }

    private PacMan getPacMan() {
        return (PacMan) characters.get(0);
    }

    private List<RedGhost> getRedGhosts() {
        return characters.stream()
                .filter(character -> character.getType().equals("RedGhost"))
                .map(character -> (RedGhost) character)
                .collect(Collectors.toList());
    }

    private List<BlueGhost> getBlueGhosts() {
        return characters.stream()
                .filter(character -> character.getType().equals("BlueGhost"))
                .map(character -> (BlueGhost) character)
                .collect(Collectors.toList());
    }

    private void sortGhosts() {
        characters.sort(Comparator
                .comparing((Character o) -> o.getCoordinate().getX())
                .thenComparing(o -> o.getCoordinate().getY())
                .thenComparing(Character::getType));
    }
}

class Coordinate {
    private int x;
    private int y;

    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
    public int getX() { return x; }
    public int getY() { return y; }
}

abstract class Character {
    private MoveStrategy moveStrategy;
    private String type;
    private Coordinate coordinate;
    private char direction;

    Character(final String type, final MoveStrategy moveStrategy, final Coordinate coordinate) {
        this.type = type;
        this.moveStrategy = moveStrategy;
        this.coordinate = coordinate;
    }

    Character(final String type, final MoveStrategy moveStrategy, final Coordinate coordinate,
              final char direction) {
        this.type = type;
        this.moveStrategy = moveStrategy;
        this.coordinate = coordinate;
        this.direction = direction;
    }

    public void move(Coordinate coordinate, char direction) {
        moveStrategy.move(coordinate, direction);
    }

    public abstract void print();

    public String getType() { return type; }
    public Coordinate getCoordinate() { return coordinate; }
    public void setDirection(char direction) { this.direction = direction; }
    public char getDirection() { return direction; }
}

abstract class Ghost extends Character {
    Ghost(final String type, final MoveStrategy moveStrategy, final Coordinate coordinate) {
        super(type, moveStrategy, coordinate);
    }

    Ghost(final String type, final MoveStrategy moveStrategy, final Coordinate coordinate,
          final char direction) {
        super(type, moveStrategy, coordinate, direction);
    }

    public abstract void print();
}

class BlueGhost extends Ghost {
    BlueGhost(final String type, final MoveStrategy moveStrategy, final Coordinate coordinate,
              final char direction) {
        super(type, moveStrategy, coordinate, direction);
    }

    @Override
    public void print() {
        System.out.print("B ");
        System.out.println(getCoordinate().getX() + " " + getCoordinate().getY());
    }
}

class RedGhost extends Ghost {
    RedGhost(final String type, final MoveStrategy moveStrategy, final Coordinate coordinate,
             final char direction) {
        super(type, moveStrategy, coordinate, direction);
    }

    @Override
    public void print() {
        System.out.print("R ");
        System.out.println(getCoordinate().getX() + " " + getCoordinate().getY());
    }
}

class PacMan extends Character {
    private List<String> moves = new ArrayList<>();

    PacMan(final String type, final MoveStrategy moveStrategy, final Coordinate coordinate) {
        super(type, moveStrategy, coordinate);
    }

    public List<String> getMoves() {
        return moves;
    }

    @Override
    public void print() {
        System.out.println(getCoordinate().getX() + " " + getCoordinate().getY());
    }
}

interface MoveStrategy {
    void move(Coordinate currentCoordinate, char direction);
}

class MoveRedGhost implements MoveStrategy {
    @Override
    public void move(Coordinate currentCoordinate, char direction) {
        if (direction == Direction.LEFT) {
            currentCoordinate.setX(currentCoordinate.getX() - 1);
        } else if (direction == Direction.RIGHT) {
            currentCoordinate.setX(currentCoordinate.getX() + 1);
        }
    }
}

class MoveBlueGhost implements MoveStrategy {
    @Override
    public void move(Coordinate currentCoordinate, char direction) {
        if (direction == Direction.UP) {
            currentCoordinate.setY(currentCoordinate.getY() + 1);
        } else if (direction == Direction.DOWN) {
            currentCoordinate.setY(currentCoordinate.getY() - 1);
        }
    }
}

class MovePacMan implements MoveStrategy {
    private int boardSize;

    @Override
    public void move(Coordinate currentCoordinate, char direction) {
        if (direction == Direction.DOWN) {
            if (currentCoordinate.getY() == 1) {
                return;
            }

            currentCoordinate.setY(currentCoordinate.getY() - 1);
        } else if (direction == Direction.UP) {
            if (currentCoordinate.getY() == boardSize) {
                return;
            }

            currentCoordinate.setY(currentCoordinate.getY() + 1);
        } else if (direction == Direction.LEFT) {
            if (currentCoordinate.getX() == 1) {
                return;
            }

            currentCoordinate.setX(currentCoordinate.getX() - 1);
        } else if (direction == Direction.RIGHT) {
            if (currentCoordinate.getX() == boardSize) {
                return;
            }

            currentCoordinate.setX(currentCoordinate.getX() + 1);
        }
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }
}

class Direction {
    // Constants
    public static final char UP = 'U';
    public static final char DOWN = 'D';
    public static final char LEFT = 'L';
    public static final char RIGHT = 'R';
}