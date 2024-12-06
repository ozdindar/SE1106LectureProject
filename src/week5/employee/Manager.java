package week5.employee;

public class Manager extends Employee{
    public Manager(String name) {
        super(name);
    }

    @Override
    public int getPayment()
    {
        return 250;
    }
}
