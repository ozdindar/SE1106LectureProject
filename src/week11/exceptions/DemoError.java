package week11.exceptions;

public class DemoError {

    public static void main(String[] args) {
        demo2();
    }

    static long factorial(long n)
    {
        if (n == 0)
            return 1;

        return n* factorial(n-1);
    }

    private static void demo2() {
        factorial(100000);
        System.out.println("End");
    }


    private static void demo1() {
        int[][][] arr = new int[10000][10000][10000];
        System.out.println("test");
    }
}
