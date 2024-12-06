package week14.generics.genericmethods;

public class Student {
    int id;
    String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return id + " " + name;
    }

    @Override
    public boolean equals(Object obj) {
       if (! ( obj instanceof Student))
           return false;

       Student s = (Student) obj;

       return name.equals(s.name) && id == s.id;

    }
}
