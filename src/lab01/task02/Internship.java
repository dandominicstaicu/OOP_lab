package lab01.task02;
import java.util.Random;

public class Internship {
    private String minGrade;
    private String name;
    private Student[] students = new Student[3];

    public Student chooseCandidateRandomly() {
        Random randomStudent = new Random();
        int randomReturn = randomStudent.nextInt(3);
        return students[randomReturn];
    }

    public void chooseCandidatesForInterview(Student student) {
        double grade = Double.parseDouble(minGrade);
        if (student.getGrade() > grade) {
            System.out.println("Candidate " + student.getName() + " got a phone interview at " + name);
        }

    }

    public String getMinGrade() {
        return minGrade;
    }

    public void setMinGrade(String minGrade) {
        this.minGrade = minGrade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }
}
