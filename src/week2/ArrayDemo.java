package week2;

import java.util.ArrayList;
import java.util.Arrays;

class ArrayDemo {

    public static void main_basic(String[] args) {

        int[] arr = new int[] { 1,2,3,4,5,6};


        // Iterating over an array
        System.out.print("(");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+ " ");
        }
        System.out.println(") ");

        String st = Arrays.toString(arr);

        System.out.println(st);
    }

    public static void main_primitive(String[] args) {
        int[] arr = new int[] { 1,2,3,4,5,6};

        // Performed some operation

        int[] tmp = new int[10];
        for (int i = 0; i < arr.length; i++) {
            tmp[i]= arr[i];
        }

        arr = tmp;

        arr[7] = 5;

        System.out.println(Arrays.toString(arr));
    }


    public static void main_object(String[] args) {
        Student[] sArr= new Student[100];
        for (int i = 0; i < 100; i++) {
            sArr[i] = new Student();

        }


        sArr[0].name = "Ali";
        sArr[1].name = "Ayşe";
        sArr[2].name = "Sevgi";

        System.out.println(Arrays.toString(sArr));
    }


    public static void main(String[] args) {

        ArrayList<Student> classRoom = new ArrayList<>();

        Student s1 = new Student();

        classRoom.add(new Student(1,"Ali",3.0));
        classRoom.add(new Student(1,"Ali",3.0));
        classRoom.add(new Student(1,"Ali",3.0));
        classRoom.add(s1);

        for (int i = 0; i < classRoom.size(); i++) {
            Student s = classRoom.get(i);
            System.out.println(s);
        }

        classRoom.remove(1);

        classRoom.remove(s1);
    }

}
