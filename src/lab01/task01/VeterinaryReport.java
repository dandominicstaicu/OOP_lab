package lab01.task01;

public class VeterinaryReport {
    int dogs;
    int cats;

    public int getAnimalsCount() {
        return dogs + cats;
    }

    public void displayStatistics() {
        System.out.println("Total number of animals is " + getAnimalsCount());
    }
}

