package week11.exceptions;

import java.util.ArrayList;

public class DemoRuntime {

    public static void main(String[] args) {
       // int x = 4/0;
        demo2();
    }

    private static double demo2() {
        ArrayList<Integer> numbers = new ArrayList<>();
        double avg = 0.0;
        int total = 0;
        for (int i = 0; i < numbers.size(); i++) {
            total += numbers.get(i);
        }
        avg =  total/numbers.size() ;
        return avg;
    }


    private static void demo1() {
        int[] arr=null;

        if (arr.length==0)
        {
            System.out.println("Test");
        }
    }
}
