package examrecap.gptproblem2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

enum Category {
    FICTION, NON_FICTION
}

class Book {
    private int id;
    private String title;
    private String author;
    private Category category;

    public Book(int id, String title, String author, Category category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
    }


}

class Patron {
    private final ArrayList<Book> borrowedBooks = new ArrayList<>();
    private final ArrayList<Book> reservedBooks = new ArrayList<>();


}

class Library {
    private static Library instance;
    private final ArrayList<Book> books = new ArrayList<>();
    private final HashMap<Book, Integer> borrowed = new HashMap<>();
    private final HashMap<Book, Integer> reserved = new HashMap<>();

    private Library() {
    }

    public static Library getInstance() {
        if (instance == null) {
            instance = new Library();
        }

        return instance;
    }

    public void borrowBook (int patronId, int bookId) {

    }

    public void returnBook (int bookId) {

    }

    public void reserve(int patronId, int bookId) {

    }

    public Book search (Category category) {
        return  null;
    }

    public Book viewLatest() {
        return null;
    }

    public List<Book> viewBorrowed() {
        return null;
    }



}

public class Main {


    public static void main(String[] args) {

    }
}
