package week3.multidimensional;

import week3.accessmodifiers.students.Student;

import java.util.ArrayList;

public class Demo {

    public static void main(String[] args) {


        int[][] arr2D = new int[3][];

        arr2D[0] = new int[5];
        arr2D[1] = new int[3];
        arr2D[2] = new int[7];

        for (int r = 0; r < arr2D.length; r++) {
            for (int c = 0; c < arr2D[r].length; c++) {
                System.out.print(arr2D[r][c] + "  ");
            }
            System.out.println();
        }

        int[][] arr= new int[3][5];


        ArrayList<ArrayList<Student>> list = new ArrayList<>();

        list.add(new ArrayList<>());
        list.get(0).add(new Student());

    }
}
