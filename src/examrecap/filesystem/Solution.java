package examrecap.filesystem;

// https://www.hackerrank.com/contests/poo2021-test-practic/challenges/poo2021-file-system/problem

import examuseful.logger.ScannerExample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

interface Indexable {
    void printType();

    void printContent();
}

class File implements Indexable {
    private String name;

    public File(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addFile() {

    }

    @Override
    public void printType() {

    }

    @Override
    public void printContent() {

    }
}

class Director implements Indexable {
    private String name;
    private final HashSet<Director> directors = new HashSet<>();
    private final HashSet<File> files = new HashSet<>();

    public Director(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void printType() {

    }

    @Override
    public void printContent() {

    }
}

class FileDatabase {
    private static FileDatabase instance;

    private FileDatabase() {
    }

    public static FileDatabase getInstance() {
        if (instance == null) {
            instance = new FileDatabase();
        }

        return instance;
    }



}

class FileAdder {

}

class Reader {
    private static final Logger LOGGER = Logger.getLogger(ScannerExample.class.getName());

    public static void read() {
        Scanner scan = new Scanner(System.in);

        try {
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                handleInput(line);

            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Exception while reading input: ", e);
        }

    }

    private static void handleInput(String inputLine) {
        try {
            String[] parts = inputLine.split(":");
            String command = parts[0];

            switch (command) {
                case "ADD":

                    break;
                case "Q1":
                    break;
                case "Q2":
                    break;
                default:
                    break;
            }


        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Exception while handling input: ", e);
        }
    }

}

public class Solution {
    public static void main(String[] args) {


    }
}
