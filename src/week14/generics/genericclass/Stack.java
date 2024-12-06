package week14.generics.genericclass;

public class Stack<A> {
    int capacity;
    int top;
    A[] items;

    Stack(int capacity)
    {
        this.capacity = capacity;
        top= -1;
        items = (A[]) new  Object[capacity];
    }

    public Stack<A> push( A val)
    {
        if ( isFull())
            throw new StackFullException();
        top++;
        items[top]= val;

        return this;
    }

    public boolean isFull() {
        return top>= capacity-1;
    }

    public A pop()
    {
        if (isEmpty())
            throw new StackEmptyException();

        A val = items[top];

        items[top]= null;
        top--;
        return val;
    }

    public boolean isEmpty() {
        return top<=-1;
    }


    public static void main(String[] args) {
        Stack<Integer> iStack = new Stack<>(5);

        iStack.push(1).push(7).push(-3).push(43).push(3);


        while (!iStack.isEmpty())
        {
            System.out.println(iStack.pop());
        }


        System.out.println(iStack.pop());


    }

}
