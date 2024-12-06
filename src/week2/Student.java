package week2;

class Student {

    static double GraduationGPA = 2.0;

    String name;
    int id;
    double gpa;

    Student()
    {
        System.out.println("A student is created..");
    }

    Student(int id, String name, double gpa)
    {
        this.id = id;
        this.name = name;
        this.gpa = gpa;

    }

    /**
     * Copy constructor that copies the attributes of s into the object
     * @param s
     */
    Student(Student s)
    {
        id  = s.id;
        name = s.name;
        gpa = s.gpa;
    }



    void print() {
        System.out.println("["+id+"]  name:"+ name + " GPA:"+ gpa+"");
    }


    public String ToString()
    {
        return "["+id+"]  name:"+ name + " GPA:"+ gpa+"";
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
        return id ==s.id && name == s.name && gpa==s.gpa;
    }

    @Override
    public int hashCode() {
        return 1;
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

        System.out.println(s1);

    }



}
