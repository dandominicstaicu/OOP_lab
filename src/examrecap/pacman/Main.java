package examrecap.pacman;

import java.util.*;

abstract class Movable {
    protected int x, y;

    public Movable(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public abstract void move(String direction, int boardSize);

    public void moveUp() {
        this.x += 1;
    }

    public void moveDown() {
        this.x -= 1;
    }

    public void moveLeft() {
        this.y -= 1;
    }

    public void moveRight() {
        this.y += 1;
    }
}

class Pacman extends Movable {

    public Pacman(int x, int y) {
        super(x, y);
    }

    @Override
    public void move(String direction, int boardSize) {
        switch (direction) {
            case "U":
                if (x < boardSize)
                    moveUp();
                break;
            case "D":
                if (x > 1)
                    moveDown();
                break;
            case "L":
                if (y > 1)
                    moveLeft();
                break;
            case "R":
                if (y < boardSize)
                    moveRight();
                break;
        }
    }
}

abstract class Phantom extends Movable {
    protected boolean movingRight = false;
    protected boolean movingDown = true;

    public Phantom(int x, int y) {
        super(x, y);
    }

    public abstract void updateDirection(int boardSize);

    public abstract char getType();
}

class RedPhantom extends Phantom {
    public RedPhantom(int x, int y) {
        super(y, x);
    }

    @Override
    public void move(String direction, int boardSize) {
        updateDirection(boardSize);
    }

    @Override
    public void updateDirection(int boardSize) {
        if (y == 1) {
            movingRight = true;
        } else if (y == boardSize) {
            movingRight = false;
        }

        if (movingRight) {
            moveRight();
        } else {
            moveLeft();
        }
    }

    @Override
    public char getType() {
        return 'R';
    }
}

class BluePhantom extends Phantom {
    private boolean isFirstMove = true;

    public BluePhantom(int x, int y) {
        super(y, x);
    }

    @Override
    public void move(String direction, int boardSize) {
        if (isFirstMove) {
            isFirstMove = false;
            if (x == 1) {
                movingDown = false;
                return;
            }
        }

        updateDirection(boardSize);
    }

    @Override
    public void updateDirection(int boardSize) {
//        if (x == 0) {
//            x = 1;
//            return;
//        }

        if (movingDown && x == 1) {
            movingDown = false;
        } else if (!movingDown && x == boardSize) {
            movingDown = true;
        }

        if (movingDown) {
            moveDown();
        } else {
            moveUp();
        }
    }

    @Override
    public char getType() {
        return 'B';
    }
}

class Game {
    private final int boardSize;
    private final Pacman pacman;
    private final List<Phantom> phantoms = new ArrayList<>();


    public Game(int boardSize, Pacman pacman, List<Phantom> redPhantoms, List<Phantom> bluePhantoms) {
        this.boardSize = boardSize;
        this.pacman = pacman;
        this.phantoms.addAll(redPhantoms);
        this.phantoms.addAll(bluePhantoms);
    }

    public void playGame(String[] moves) {
        for (String move : moves) {
            pacman.move(move, boardSize);

            for (Phantom phantom : phantoms) {
                phantom.move(move, boardSize);
            }

            if (checkCollision()) {
//                System.out.println("Pacman died");
                displayPositions();
                return;
            }
        }

        displayPositions();
    }

    private boolean checkCollision() {
        for (Phantom phantom : phantoms) {
            if (pacman.getX() == phantom.getX() && pacman.getY() == phantom.getY()) {
                return true;
            }
        }
        return false;
    }

    private void displayPositions() {
        System.out.println(pacman.getY() + " " + pacman.getX());
        phantoms.stream().sorted((p1, p2) -> {
            if (p1.getY() != p2.getY()) return p1.getY() - p2.getY();
            if (p1.getX() != p2.getX()) return p1.getX() - p2.getX();
            return Character.compare(p1.getType(), p2.getType());
        }).forEach(phantom -> {
            char type = phantom.getType();
            System.out.println(type + " " + phantom.getY() + " " + phantom.getX());
        });
    }

    /*

    ------no streams----


    private void displayPositions() {
        System.out.println(pacman.getY() + " " + pacman.getX());

        // Sort phantoms without using streams
        Collections.sort(phantoms, new Comparator<Phantom>() {
            @Override
            public int compare(Phantom p1, Phantom p2) {
                if (p1.getY() != p2.getY()) return Integer.compare(p1.getY(), p2.getY());
                if (p1.getX() != p2.getX()) return Integer.compare(p1.getX(), p2.getX());
                return Character.compare(p1.getType(), p2.getType());
            }
        });

        // Iterate through the sorted list of phantoms
        for (Phantom phantom : phantoms) {
            char type = phantom.getType();
            System.out.println(type + " " + phantom.getY() + " " + phantom.getX());
        }
    }
    */

}

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int boardSize = scan.nextInt();
        int y = scan.nextInt();
        int x = scan.nextInt();

        Pacman pacman = new Pacman(x, y);
        List<Phantom> redPhantoms = new ArrayList<>();
        List<Phantom> bluePhantoms = new ArrayList<>();

        int rCount = scan.nextInt();
        for (int i = 0; i < rCount; ++i) {
            int redX = scan.nextInt();
            int redY = scan.nextInt();

//            if (redX == 1) {
//                redX = 0;
//            }

            redPhantoms.add(new RedPhantom(redX, redY));
        }

        int bCount = scan.nextInt();
        for (int i = 0; i < bCount; ++i) {
            int blueX = scan.nextInt();
            int blueY = scan.nextInt();

//            if (blueY == 1) {
//                blueY = 0;
//            }

            bluePhantoms.add(new BluePhantom(blueX, blueY));
        }

        int movesCnt = scan.nextInt();
        String[] moves = new String[movesCnt];
        for (int i = 0; i < movesCnt; ++i) {
            moves[i] = scan.next();
        }

        Game game = new Game(boardSize, pacman, redPhantoms, bluePhantoms);
        game.playGame(moves);
    }
}
