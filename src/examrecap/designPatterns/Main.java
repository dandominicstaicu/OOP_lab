package examrecap.designPatterns;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

interface TransactionPublisher {
    void createTransaction(Person person);
}

interface BalanceObserver {
    void update();
}

interface PaymentStrategy {
    void pay(Integer amount);
}

class Shop implements TransactionPublisher {
    private final Random priceGenerator = new Random(56);
    private final RandomPaymentFactory paymentFactory = new RandomPaymentFactory();
    private final ArrayList<Person> customers = new ArrayList<>();

    public void addCustomers(List<Person> customers) {
        this.customers.addAll(customers);
    }

    public ArrayList<Person> getCustomers() {
        return customers;
    }

    @Override
    public void createTransaction(Person person) {
        // TODO - use price generator bounded to 100!
    }
}
class Person implements BalanceObserver {
    private String IBAN;
    private String cardNumber;
    private String name;
    private String surname;
    private Integer balance;

    private Integer limit;

    // TODO - All args constructor, getters, setters


    public Person(String IBAN, String cardNumber, String name, String surname, Integer balance, Integer limit) {
        this.IBAN = IBAN;
        this.cardNumber = cardNumber;
        this.name = name;
        this.surname = surname;
        this.balance = balance;
        this.limit = limit;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    @Override
    public void update() {
        // TODO
    }

    public boolean payBy(PaymentStrategy strategy, Integer amount) {
        // TODO
        return true;
    }
}


class CardPayment implements PaymentStrategy {
    private final Person person;

    public CardPayment(Person person) {
        this.person = person;
    }

    @Override
    public void pay(Integer amount) {
        // TODO
        Integer balance = person.getBalance();
        Integer newBalance = balance - amount;

        if (newBalance < 0) {
            System.out.println(person.getName() + " " + person.getSurname() +
                    ", pleaca de aici, saracule!");
            return;
        }

        person.setBalance(newBalance);
        System.out.println(person.getName() + " " + person.getSurname() +
                " a platit cu cardul " + person.getCardNumber() + " suma de " +
                amount + " RON");
    }
}
class VoucherPayment implements PaymentStrategy {
    private final Person person;
    public VoucherPayment(Person person){
        this.person = person;
    }
    @Override
    public void pay(Integer amount){
        // TODO
    }
}

class BankAccountPayment implements PaymentStrategy {
    private final Person person;

    public BankAccountPayment(Person person) {
        this.person = person;
    }

    @Override
    public void pay(Integer amount) {
        // TODO
    }
}

class RandomPaymentFactory {
    private enum PaymentType { CARD, IBAN, VOUCHER }
    private static final Random random = new Random(1234565);

    public PaymentStrategy getPaymentMethod(Person person) {
        PaymentStrategy paymentStrategy = null;

        switch (PaymentType.values()[random.nextInt(3)]) {
            case CARD:
                paymentStrategy = amount -> {}; // TODO - replace with constructor call
            case IBAN:
                paymentStrategy = amount -> {}; // TODO - replace with constructor call
            case VOUCHER:
                paymentStrategy = amount -> {}; //TODO - replace with constructor call
        };

        return paymentStrategy;
    }
}


public class Main {

    // DO NOT MODIFY
    private static void test(Person... people) {
        Shop shop = new Shop();
        Random random = new Random(2023);
        shop.addCustomers(List.of(people));

        for (int i = 0; i < 20; i++) {
            int idx = random.nextInt(4);
            shop.createTransaction(shop.getCustomers().get(idx));
        }
    }

    public static void main(String[] args) {
//        TODO - uncomment when done for testing
//        Person p1 = new Person("RORNCB221", "523123222", "Gheorghe", "Iliescu", 1234, 287);
//        Person p2 = new Person("RORNCB222", "523123223", "Ion", "Popescu", 823, 150);
//        Person p3 = new Person("RORNCB223", "523123224", "Giani", "Orlando", 99, 480);
//        Person p4 = new Person("RORNCB224", "523123225", "Florin", "Andone", 606, 500);
//        test(p1, p2, p3, p4);
    }
}