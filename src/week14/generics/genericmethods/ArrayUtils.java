package week14.generics.genericmethods;

public class ArrayUtils {

    static int findIntElement(    int[] arr,int val )
    {
        for (int i = 0; i < arr.length; i++) {
            if (val == arr[i])
                return i;
        }

        return -1;
    }

    static int findDoubleElement(    double[] arr,double val )
    {
        for (int i = 0; i < arr.length; i++) {
            if (val == arr[i])
                return i;
        }

        return -1;
    }

    static <T> int findElement(    T[] arr, T val )
    {
        for (int i = 0; i < arr.length; i++) {
            if (val.equals(arr[i]))
                return i;
        }

        return -1;
    }


    public static void main(String[] args) {
        Integer[] arr= {1,0,2,3,4,5,67,2,1,3,5};
        Double[] dArr = {0.1, 0.4, 6.5};

        int val=3;

        Integer i = 4;
        Double d = 0.1;
        Boolean b = true;



        int index = findElement(arr,val);

        index = findElement(dArr, 1.6);


        Student[] stArr= { new Student(1,"Ali"), new Student(2,"Ayşe"), new Student(3,"Can")};


        index = findElement(stArr, new Student(1,"Ali"));



    }

}
