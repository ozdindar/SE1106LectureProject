package week3.accessmodifiers.students;

public class Student {

    static double GraduationGPA = 2.0;

    private String fName;
    private int id;
    private double gpa;

    public Student()
    {
        System.out.println("A student is created..");
    }

    public Student(int id, String name, double gpa)
    {
        this.id = id;
        this.fName = name;
        this.gpa = gpa;

    }

    /**
     * Copy constructor that copies the attributes of s into the object
     * @param s
     */
    public Student(Student s)
    {
        id  = s.id;
        fName = s.fName;
        gpa = s.gpa;
    }

    public void setName(String name)
    {
        this.fName = name;
    }

    public String getName()
    {
        return fName;
    }


    void print() {
        System.out.println("["+id+"]  name:"+ fName + " GPA:"+ gpa+"");
    }


    public String toString()
    {
        return "["+id+"]  name:"+ fName + " GPA:"+ gpa+"";
    }

    public static void main_old(String[] args) {

        int x = 3;

        System.out.println(x);

        int y=x;

        System.out.println(y);
        y++;
        System.out.println(y);
        System.out.println(x);

        Student s1 = new Student(1,"Ayşe",3.6);

        s1.print();

        Student s2 = new Student(s1);

        s2.print();

        s2.gpa = 2.0;

        String st = "[" + s2 + "]";

        System.out.println(st);



    }

    boolean isEqual(Student s)
    {
        return id ==s.id && fName == s.fName && gpa==s.gpa;
    }

    public static void main(String[] args) {
        int x =3;
        int y= x;

        y++;

        if (x==y)
            System.out.println("Equal");
        else System.out.println("NOT Equal");

        Student s1 = new Student(1,"Ali",3.0);
        Student s2 = s1;

        s2.gpa= 2.7;

        if (s1.isEqual(s2))
            System.out.println("Equal");
        else System.out.println("NOT Equal");

    }


    public double getGPA() {
        return gpa;
    }
}
