package lab06;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Car {
    public enum CarType {
        MERCEDES,
        FIAT,
        SKODA
    }

    private final int price;
    private final CarType type;
    private final int year;

    public Car(int price, CarType type, int year) {
        this.price = price;
        this.type = type;
        this.year = year;
    }

    public int getPrice() {
        return price;
    }

    public CarType getType() {
        return type;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Car{price=" + price + ", carType=" + type + ", year=" + year + "}";
    }
}

interface Offer {
    int getDiscount(Car car);
}

class Dealership {
    private static class BrandOffer implements Offer {
        @Override
        public int getDiscount(Car car) {
            return switch (car.getType()) {
                case MERCEDES -> (int) (car.getPrice() * 0.05);
                case FIAT -> (int) (car.getPrice() * 0.1);
                case SKODA -> (int) (car.getPrice() * 0.15);
                default -> 0;
            };
        }
    }

    private static class DealerOffer implements Offer {
        @Override
        public int getDiscount(Car car) {
            int currentYear = 2022;
            int age = currentYear - car.getYear();

            return switch (car.getType()) {
                case MERCEDES -> age * 300;
                case FIAT -> age * 100;
                case SKODA -> age * 150;
                default -> 0;
            };
        }
    }

    private static class SpecialOffer implements Offer {
        @Override
        public int getDiscount(Car car) {
            return Main.rand.nextInt(1000);
        }
    }

    public int getFinalPrice(Car car) {
        int brandDiscount = new BrandOffer().getDiscount(car);
        System.out.println("Applying Brand discount: " + brandDiscount + " euros");

        int dealerDiscount = new DealerOffer().getDiscount(car);
        System.out.println("Applying Dealer discount: " + dealerDiscount + " euros");

        int specialDiscount = new SpecialOffer().getDiscount(car);
        System.out.println("Applying Special discount: " + specialDiscount + " euros");

        int discount = brandDiscount + dealerDiscount + specialDiscount;

        return car.getPrice() - discount;
    }

    public void negotiate(Car car, Offer offer) {
        int discount = offer.getDiscount(car);
        System.out.println("Applying Client discount: " + discount + " euros");

        int finalPrice = car.getPrice() - discount;
    }
}

public class Main {
    public static Random rand = new Random(20);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int taskNum = scanner.nextInt();

        switch (taskNum) {
            case 1:
                // TODO: uncomment for Task1
                Car mercedes = new Car(20000, Car.CarType.MERCEDES, 2019);
                Car fiat = new Car(7000, Car.CarType.FIAT, 2020);
                Car skoda = new Car(12000, Car.CarType.SKODA, 2022);
                Dealership dealership = new Dealership();
                break;
            case 2:
                // TODO: uncomment for Task2
                dealership = new Dealership();

                Car mercedes1 = new Car(20000, Car.CarType.MERCEDES, 2010);
                Car mercedes2 = new Car(35000, Car.CarType.MERCEDES, 2015);
                Car fiat1 = new Car(3500, Car.CarType.FIAT, 2008);
                Car fiat2 = new Car(7000, Car.CarType.FIAT, 2010);
                Car skoda1 = new Car(12000, Car.CarType.SKODA, 2015);
                Car skoda2 = new Car(25000, Car.CarType.SKODA, 2021);

                dealership.getFinalPrice(mercedes1);
                dealership.getFinalPrice(mercedes2);
                dealership.getFinalPrice(fiat1);
                dealership.getFinalPrice(fiat2);
                dealership.getFinalPrice(skoda1);
                dealership.getFinalPrice(skoda2);

                break;
            case 3:
                // TODO: uncomment for Task3
                 dealership = new Dealership();

                 Car neg_mercedes = new Car(20000, Car.CarType.MERCEDES, 2019);

                 dealership.negotiate(neg_mercedes, new Offer() {
                     @Override
                     public int getDiscount(Car car) {
                         return (int) (car.getPrice() * 0.05);
                     }
                 });

                break;
            case 4:
                // TODO: write solution for Task4 here
                ArrayList<Car> cars_list = new ArrayList<>();
                cars_list.add(new Car(20000, Car.CarType.SKODA, 2019));
                cars_list.add(new Car(30000, Car.CarType.MERCEDES, 2019));
                cars_list.add(new Car(50000, Car.CarType.MERCEDES, 2021));
                cars_list.add(new Car(10000, Car.CarType.FIAT, 2018));

                cars_list.forEach(System.out::println);

                cars_list.removeIf(car -> car.getPrice() > 25000);

                cars_list.forEach(System.out::println);

                break;
        }
    }
}
