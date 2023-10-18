package lab01.task02;

public class JobMarket {
    public static void main(String[] args) {
        Student gigel = new Student();
        Student dorel = new Student();
        Student marcel = new Student();
        Student Ionel = new Student();

        Internship google = new Internship();
        Internship amazon = new Internship();
        Internship facebook = new Internship();
        Internship microsoft = new Internship();

        google.chooseCandidateRandomly();
        amazon.chooseCandidateRandomly();
        facebook.chooseCandidateRandomly();
        microsoft.chooseCandidateRandomly();


        Student s1 = new Student();
        Student s2 = new Student();

        s1.setName("Dan");
        s2.setName("Dan");
        s1.setGrade(10);
        s2.setGrade(10);

        if(s1.equals(s2)) {
            System.out.println("egal");
        }


    }
}
