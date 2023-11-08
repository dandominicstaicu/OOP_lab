package lab05;

import java.util.*;

interface Task {
    /**
     * Executes the action characteristic of the task.
     */
    void execute();
}

interface Container {
    /**
     * Removes a Task from the Container.
     *
     * @return the removed Task, if the Container is not empty;
     * null, otherwise
     */
    Task pop();

    /**
     * Inserts a Task in the Container.
     *
     * @param task the inserted Task
     */
    void push(Task task);

    /**
     * Returns the number of elements from the Container.
     *
     * @return The number of elements in this container.
     */
    int size();

    /**
     * Verifies if the Container is empty or not.
     *
     * @return true,  if the Container is empty
     * false, otherwise
     */
    boolean isEmpty();

    /**
     * Transfers all the elements that exist in a Container in this Container.
     *
     * @param container the Container from which we should transfer elements.
     *                  After the transfer, container.size() == 0
     */
    default void transferFrom(Container container) {
        while (!container.isEmpty()) {
            push(container.pop());
        }
    }

    /**
     * Return all the tasks stored in the Container.
     *
     * @return The list of the tasks stored in the Container.
     */
    ArrayList<Task> getTasks();
}

class OutTask implements Task {
    String message;
    public OutTask(String message) {
        this.message = message;
    }

    @Override
    public void execute() {
        System.out.println(message);
    }
}

class RandomOutTask implements Task {
    final static Random random = new Random(12345);
    final int randomNumber;

    public RandomOutTask() {
        randomNumber = random.nextInt();
    }

    @Override
    public void execute() {
        System.out.println(randomNumber);
    }
}

class CounterOutTask implements Task {
    static int counter = 0;

    public CounterOutTask() {

    }

    @Override
    public void execute() {
        CounterOutTask.counter++;
        System.out.println(counter);
    }
}

abstract class AbstractContainer implements Container {
    protected LinkedList<Task> tasks = new LinkedList<>();

    @Override
    public void push(Task task) {
        tasks.add(task);
    }

    @Override
    public int size() {
        return tasks.size();
    }

    @Override
    public boolean isEmpty() {
        return tasks.isEmpty();
    }

    @Override
    public ArrayList<Task> getTasks() {
        return new ArrayList<>(tasks);
    }
}

class Stack extends AbstractContainer {
    @Override
    public Task pop() {
        if (tasks.isEmpty()) {
            return null;
        }

        return tasks.removeLast();
    }
}

class Queue extends AbstractContainer {
    @Override
    public Task pop() {
        if (tasks.isEmpty()) {
            return null;
        }

        return tasks.removeFirst();
    }
}

interface Minus {
    void minus(float value);
}

interface Plus {
    void plus(float value);
}

interface Mult {
    void mult(float value);
}

interface Div {
    void div(float value);
}

class Operation implements Minus, Plus, Mult, Div {
    private float number;

    public Operation(float number) {
        this.number = number;
    }

    public float getNumber() {
        return number;
    }

    @Override
    public void minus(float value) {
        number -= value;
    }

    @Override
    public void plus(float value) {
        number += value;
    }

    @Override
    public void mult(float value) {
        number *= value;
    }

    @Override
    public void div(float value) {
        if (value == 0) {
            System.out.println("Division by 0 is not possible");
            return;
        }

        number /= value;
    }
}

class Song {
    private String name;
    private int id;
    private String composer;

    public Song(String name, int id, String composer) {
        this.name = name;
        this.id = id;
        this.composer = composer;
    }

    public int getId() {
        return id;
    }

    public String getComposer() {
        return composer;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Song{name=" + "'" + name + "'" + ", id=" + id + ", composer=" + "'" + composer + "'" + "}";
    }
}

abstract class Album {
    protected ArrayList<Song> songs = new ArrayList<>();

    public abstract void addSong(Song song);

    public void removeSong(Song song) {
        songs.remove(song);
    }

    @Override
    public String toString() {
        return "Album{" + "songs=" + songs + '}';
    }
}

class DangerousAlbum extends Album {
    @Override
    public void addSong(Song song) {
        if (isPrime(song.getId())) {
            songs.add(song);
        }
    }

    private boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}

class ThrillerAlbum extends Album {
    @Override
    public void addSong(Song song) {
        if ("Michael Jackson".equals(song.getComposer()) && song.getId() % 2 == 0) {
            songs.add(song);
        }
    }
}

class BadAlbum extends Album {
    @Override
    public void addSong(Song song) {
        if (song.getName().length() == 3 && isPalindrome(song.getId())) {
            songs.add(song);
        }
    }

    private boolean isPalindrome(int number) {
        String numStr = String.valueOf(number);
        int i = 0;
        int j = numStr.length() - 1;

        while (i < j) {
            if (numStr.charAt(i) != numStr.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

public class Main {
    private static List<Task> taskList = new ArrayList<>();

    private static void loadTasks() {
        if (taskList.isEmpty()) {
            taskList.add(new OutTask("First message task"));
            taskList.add(new RandomOutTask());
            taskList.add(new CounterOutTask());
            taskList.add(new OutTask("Second message task"));
            taskList.add(new CounterOutTask());
            taskList.add(new RandomOutTask());
        }
    }

    private static void test1() {
        for (Task task : taskList) {
            task.execute();
        }
    }

    private static void test2() {
        System.out.println("----> Queue");
        Queue q = new Queue();
        for (Task task : taskList) {
            q.push(task);
        }
        q.pop();
        q.pop();
        for (Task task : q.getTasks()) {
            task.execute();
        }

        System.out.println("----> Stack");
        Stack s = new Stack();
        for (Task task : taskList) {
            s.push(task);
        }
        s.pop();
        s.pop();
        for (Task task : s.getTasks()) {
            task.execute();
        }

        System.out.println("----> Testing transferFrom");
        q.transferFrom(s);

        for (Task task : q.getTasks()) {
            task.execute();
        }

        // This should print true
        System.out.println(s.isEmpty());
    }

    static private void test3() {
        Operation op = new Operation(13.5f);
        op.div(0.f);
        op.div(1.f);
        System.out.println(op.getNumber());  // 13.5
        op.mult(2.f);
        System.out.println(op.getNumber());  // 27
        op.minus(3.f);
        System.out.println(op.getNumber());  // 24
        op.plus(7.f);
        System.out.println(op.getNumber());  // 31
    }


    private static void test4() {
        Song song1 = new Song("Bad", 101, "Michael Jackson");
        Song song2 = new Song("Dangerous", 19, "Michael Jackson");
        Song song3 = new Song("Heal the world", 53, "Composer");
        Song song4 = new Song("Thriller", 82, "Michael Jackson" );
        Song song5 = new Song("Beat it", 83, "Michel Jakson");
        Song song6 = new Song("Smooth Criminal", 77, "Composer");

        DangerousAlbum dangerous = new DangerousAlbum();
        dangerous.addSong(song2);
        dangerous.addSong(song3);
        dangerous.addSong(song6);
        System.out.println(dangerous);

        ThrillerAlbum thriller = new ThrillerAlbum();
        thriller.addSong(song4);
        thriller.addSong(song6);
        thriller.addSong(song5);
        System.out.println(thriller);

        BadAlbum bad = new BadAlbum();
        bad.addSong(song1);
        bad.addSong(song6);
        System.out.println(bad);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int task = scanner.nextInt();

        loadTasks();

        if (task == 1) {
            test1();
        } else if (task == 2) {
            test2();
        } else if (task == 3) {
            test3();
        } else {
            test4();
        }
    }
}
