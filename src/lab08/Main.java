package lab08;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int taskId = scanner.nextInt();
        scanner.close();

        /* Do not modify */
        Student s1 = new Student("Maria", "Popescu", 3, 8.5);
        Student s2 = new Student("Ion", "Grigorescu", 2, 8);
        Student s3 = new Student("Ana", "Enescu", 7, 7);
        Student s4 = new Student("Mihai", "Eminovici", 1, 4.45);
        Student s5 = new Student("Andrei", "Radu", 12, 2);

        List<Student> students = new ArrayList<>(List.of(s1, s2, s3, s4, s5));
        List<Student> copyStudents = new ArrayList<>(students);
        List<Student> anotherCopyStudents = new ArrayList<>(students);

        List<Integer> numbers = List.of(10, 20, 5, 243, 5556, 312, 566, 245, 122, 5556, 5, 10, 20, 122);
        ArrayList<String> subjects = new ArrayList<>(List.of("PP", "PA", "PCOM", "IOCLA", "AA",
                "SO", "CPL", "EP", "RL", "LFA"));
        Random random = new Random(12);
        /* End of unmodifiable zone */

        switch (taskId) {
            /* ------------------------- Task 1 ------------------------- */
            /* --------- Sort using Comparable<Student> interface ------- */
            case 1:
                Collections.sort(students);
                System.out.println(students);
                break;
            /* ------------------------- Task 2 ------------------------- */
            /* -------------- Sort using a lambda expression ------------ */
            case 2:
                Collections.sort(copyStudents, (student1, student2) -> {
                    if (student1.getAverageGrade() != student2.getAverageGrade()) {
                        return Double.compare(student1.getAverageGrade(), student2.getAverageGrade());
                    } else if (!student1.getSurname().equals(student2.getSurname())) {
                        return student1.getSurname().compareTo(student2.getSurname());
                    } else {
                        return student1.getName().compareTo(student2.getName());
                    }
                });
                System.out.println(copyStudents);
                break;
            /* ------------------------- Task 3 ------------------------- */
            /* ----------- Implement your priority queue here ----------- */
            /* --------------- Use Comparator.comparing() --------------- */
            case 3:
                PriorityQueue<Student> priorityQueue = new PriorityQueue<>(
                        Comparator.comparingLong(Student::getId)
                );

                priorityQueue.addAll(students);
                System.out.println(priorityQueue);
                break;
            /* ------------------------- Task 4 ------------------------- */
            case 4:
                Map<Student, LinkedList<String>> studentMap = new HashMap<>();
                students.forEach(s -> studentMap.putIfAbsent(s, new LinkedList<>()));
                /* Iterate through the map and add 4 random elements from subjects array in each LinkedList
                 *
                 * As index use the previously declared random object and use subjects.size() as
                 * your
                 * bound. Use addFirst() method to add elements in the LinkedList
                 */

                for (Map.Entry<Student, LinkedList<String>> entry : studentMap.entrySet()) {
                    LinkedList<String> subjectsList = entry.getValue();
                    for (int i = 0; i < 4; i++) {
                        int randomIndex = random.nextInt(subjects.size());
                        subjectsList.addFirst(subjects.get(randomIndex));
                    }
                }


                System.out.println(studentMap);
                break;
            /* ------------------------- Task 5 ------------------------- */
            /* ------------- No need to add or modify here -------------- */
            case 5:
                System.out.println(numbers);
                LinkedEvenSet linked = new LinkedEvenSet();
                linked.addAll(numbers);

                EvenSet set = new EvenSet();
                set.addAll(numbers);

                TreeEvenSet tree = new TreeEvenSet();
                tree.addAll(numbers);

                System.out.println(linked);
                System.out.println(set);
                System.out.println(tree);
            default:
                break;
        }

    }
}

class Student implements Comparable<Student> {
    /* ------------------------- Task 1 ------------------------- */
    /* Add student properties */
    /* Generate getters and setters */

    private String name;
    private String surname;
    private long id;
    private double averageGrade;

    public Student(String name, String surname, long id, double averageGrade) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.averageGrade = averageGrade;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    @Override
    public int compareTo(Student other) {

        if (this.averageGrade != other.getAverageGrade())
            return this.averageGrade - other.getAverageGrade() > 0 ? 1 : -1;
        else if (!this.name.equals(other.getName()))
            return this.name.compareTo(other.getName());
        else if (!this.surname.equals(other.getSurname()))
            return this.surname.compareTo(other.getSurname());
        return 0;
    }


    @Override
    public String toString() {
        return "Student {name=" + name + ", surname=" + surname + ", id=" + id + ", averageGrade=" + averageGrade + "}";
    }

    /* ------------------------- Task 4 ------------------------- */
    /* Override `equals` and `hashCode` methods */


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (id != student.id) return false;
        if (Double.compare(student.averageGrade, averageGrade) != 0) return false;
        if (name != null ? !name.equals(student.name) : student.name != null) return false;
        return surname != null ? surname.equals(student.surname) : student.surname == null;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getId(), getAverageGrade());
    }
}

class EvenSet extends HashSet<Integer> {
    /* Task 5 - Make it that it only accepts even Integers */
    @Override
    public boolean add(Integer number) {
        if (number % 2 == 0) {
            return super.add(number);
        }
        return false;
    }
}

class LinkedEvenSet extends LinkedHashSet<Integer> {
    /* Task 5 - Make it that it only accepts even Integers */
    @Override
    public boolean add(Integer number) {
        if (number % 2 == 0) {
            return super.add(number);
        }
        return false;
    }

}

class TreeEvenSet extends TreeSet<Integer> {
    /* Task 5 - Make it that it only accepts even Integers */
    @Override
    public boolean add(Integer number) {
        if (number % 2 == 0) {
            return super.add(number);
        }
        return false;
    }

}