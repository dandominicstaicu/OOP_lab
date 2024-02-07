package examrecap.filesystem;

// https://www.hackerrank.com/contests/poo2021-test-practic/challenges/poo2021-file-system/problem

import java.util.ArrayList;
import java.util.Scanner;

interface FileSystem {
    void printType();

    void printContent();
}

class File implements FileSystem{
    private String name;

    public File(String name) {
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

class Director implements FileSystem {
    private String name;
    private final ArrayList<Director> directors = new ArrayList<>();
    private final ArrayList<File> files = new ArrayList<>();

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

class Reader {
    public static void read() {
        Scanner scan = new Scanner(System.in);

        

    }
}

public class Solution {
    public static void main(String[] args) {


    }
}
