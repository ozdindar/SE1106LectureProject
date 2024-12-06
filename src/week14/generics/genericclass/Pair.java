package week14.generics.genericclass;

public class Pair<T,K> {
    final T first;
    final K second;

    public Pair(T first, K second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public K getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return first + "-" + second;
    }

    public static void main(String[] args) {
        Pair<Integer,Integer> p1 = new Pair<>(1,4);

        Pair<String,Double> p2 = new Pair<>("Ali",3.6);


    }
}
