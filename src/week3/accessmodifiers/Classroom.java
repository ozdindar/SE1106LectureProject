package week3.accessmodifiers;



import week3.accessmodifiers.students.Student;

import java.util.ArrayList;

class Classroom {

    ArrayList<Student> students;

    Classroom() {
        students = new ArrayList<>();
    }

    void addStudent(Student student)
    {
        students.add(student);
    }

    void printNames()
    {
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i).getName());
        }
    }

    double averageGPA()
    {
        if (students.isEmpty())
            return 0.0;

        double total = 0.0;
        for (int i = 0; i < students.size(); i++) {
            total += students.get(i).getGPA();
        }
        return total/students.size();
    }

    public static void main(String[] args) {
        Classroom cr = new Classroom();

        cr.addStudent(new Student(1,"Ali",2.0));
        cr.addStudent(new Student(2,"Ayşe",3.0));

        cr.printNames();
    }
}
