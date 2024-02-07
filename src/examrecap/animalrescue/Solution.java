package examrecap.animalrescue;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;

abstract class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " + this.name;
    }

    public abstract boolean adopt(LinkedList<Animal> animals, String type);

    public abstract Animal peek(LinkedList<Animal> animals, String type);
}

class Caine extends Animal {
    public Caine(String name) {
        super(name);
    }

    @Override
    public boolean adopt(LinkedList<Animal> animals, String type) {
        if (type.equals("Caine")) {
            animals.remove(this);
            return true;
        }

        return false;
    }

    @Override
    public Animal peek(LinkedList<Animal> animals, String type) {
        if (type.equals("Caine")) {
            return this;
        }

        return null;
    }
}

class Pisica extends Animal {
    public Pisica(final String name) {
        super(name);
    }

    @Override
    public boolean adopt(LinkedList<Animal> animals, String type) {
        if (type.equals("Pisica")) {
            animals.remove(this);
            return true;
        }

        return false;
    }

    @Override
    public Animal peek(LinkedList<Animal> animals, String type) {
        if (type.equals("Pisica")) {
            return this;
        }

        return null;
    }
}

class AnimalFactory {
    public enum AnimalType {
        Pisica, Caine
    }

    public static AnimalType toType(String type) {
        switch (type) {
            case "p":
                return AnimalType.Pisica;
            case "c":
                return AnimalType.Caine;
            default:
                throw new IllegalArgumentException("The animal type " + type + " does not exist");
        }
    }

    public static Animal createAnimal(final AnimalType animalType, final String name) {
        switch (animalType) {
            case Pisica:
                return new Pisica(name);
            case Caine:
                return new Caine(name);
            default:
                throw new IllegalArgumentException("The animal type " + animalType + " does not exist");
        }
    }
}

class AnimalShelter {
    private final LinkedList<Animal> animals = new LinkedList<>();

    public void addAnimal(final String name, final String type) {
        AnimalFactory.AnimalType animalType = AnimalFactory.toType(type);
        Animal newAnimal = AnimalFactory.createAnimal(animalType, name);

        animals.add(newAnimal);
    }

    public Animal adoptAny() {
        if (animals.isEmpty())
            throw new NoSuchElementException("no animal available");

        Animal returnAnimal = animals.peek();
        animals.removeFirst();

        return returnAnimal;
    }

    public Animal adoptSpecific(final String type) {
        for (Animal animal : animals) {
            if (animal.adopt(animals, type)) {
                return animal;
            }
        }

        throw new NoSuchElementException("No " + type + " available.");
    }

    public Animal peekAny() {
        if (animals.isEmpty())
            throw new NoSuchElementException("no animal available in shelter");

        return animals.peek();
    }

    public Animal peekSpecific(String type) {
        for (Animal animal : animals) {
            if (animal.peek(animals, type) != null) {
                return animal;
            }
        }

        throw new NoSuchElementException("No " + type + " available");
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        AnimalShelter shelter = new AnimalShelter();

        while (scan.hasNextLine()) {
            String inputLine = scan.nextLine();
            handleInput(inputLine, shelter);
        }
    }

    private static void handleInput(String input, AnimalShelter shelter) {
        try {
            String[] parts = input.split(" ");
            String command = parts[0];
            if (command.equalsIgnoreCase("a")) {
                String type = parts[1];
                String name = parts[2];
                shelter.addAnimal(name, type);
            } else {
                switch (command) {
                    case "o":
                        System.out.println(shelter.adoptAny());
                        break;
                    case "c":
                        System.out.println(shelter.adoptSpecific("Caine"));
                        break;
                    case "p":
                        System.out.println(shelter.adoptSpecific("Pisica"));
                        break;
                    case "ao":
                        System.out.println(shelter.peekAny());
                        break;
                    case "ap":
                        System.out.println(shelter.peekSpecific("Pisica"));
                        break;
                    case "ac":
                        System.out.println(shelter.peekSpecific("Caine"));
                        break;
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }


    }

}
