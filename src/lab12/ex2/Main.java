package lab12.ex2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class Book {
    String title;
    String author;
    String genre;
    int price;

    public Book(String title, String author, String genre, int price) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.price = price;
    }

    // Getters and setters (if necessary)
}

class NotEnoughMoneyException extends Exception {
    public NotEnoughMoneyException(String message) {
        super(message);
    }
}

class NoSuchBookException extends Exception {
    public NoSuchBookException(String message) {
        super(message);
    }
}

class OnlineLibrary {
    private List<Book> books;
    private int budget;

    public OnlineLibrary(int budget) {
        this.books = new ArrayList<>();
        this.budget = budget;
    }

    public void addBook(Book book) throws NotEnoughMoneyException {
        if (book.price > this.budget) {
            throw new NotEnoughMoneyException("Not enough money for " + book.title);
        }
        this.books.add(book);
        this.budget -= book.price;
        System.out.println("Added book " + book.title);
    }

    public Book getBook(String title) throws NoSuchBookException {
        Optional<Book> foundBook = books.stream()
                .filter(book -> book.title.equals(title))
                .findFirst();
        if (foundBook.isPresent()) {
            return foundBook.get();
        } else {
            throw new NoSuchBookException("Book " + title + " not available");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        OnlineLibrary onlineLibrary = new OnlineLibrary(150);

        Book book1 = new Book("Life of Pi", "Yann Martel", "General & Literary Fiction", 40);
        Book book2 = new Book("Man and Boy", "Tony Parson", "General & Literary Fiction", 200);
        Book book3 = new Book("A little life", "Hanya Yanagigihara", "General & Literary Fiction", 50);
        Book book4 = new Book("Pride and Prejudice", "Jane Austen", "Romance", 60);
        List<Book> books = List.of(book1, book2, book3);

        books.forEach(book -> {
            try {
                onlineLibrary.addBook(book);
            } catch (NotEnoughMoneyException e) {
                System.out.println(e.getMessage());
            }
        });

        try {
            onlineLibrary.getBook(book4.title);
        } catch (NoSuchBookException e) {
            System.out.println(e.getMessage());
            try {
                onlineLibrary.addBook(book4);
            } catch (NotEnoughMoneyException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
