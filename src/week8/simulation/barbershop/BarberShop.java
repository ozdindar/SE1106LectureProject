package week8.simulation.barbershop;

import com.sun.jdi.ArrayReference;
import week5.defaultconstructor.A;
import week8.simulation.Simulatable;

import java.util.ArrayList;

public class BarberShop implements Simulatable {

    public static final int REST_TIME = 5;

    private static final int DEFAULT_START_TIME = 0;
    int clock;
    ArrayList<Barber> barbers;
    ArrayList<Customer> customers;
    int capacity;



    ArrivalGenerator vicinity;

    CustomerSelectionPolicy csp;
    BarberSelectionPolicy bsp;

    int totalCustomerCount;
    int rejectedCustomerCount;
    int totalMoney;
    int totalWaitTime;


    public BarberShop(int capacity, ArrivalGenerator vicinity, CustomerSelectionPolicy csp, BarberSelectionPolicy bsp) {
        this.capacity = capacity;
        this.vicinity = vicinity;
        this.csp = csp;
        this.bsp = bsp;

        barbers = new ArrayList<>();
        customers = new ArrayList<>();
    }

    public int getClock() {
        return clock;
    }

    public ArrayList<Barber> getBarbers() {
        return barbers;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getTotalCustomerCount() {
        return totalCustomerCount;
    }

    public int getRejectedCustomerCount() {
        return rejectedCustomerCount;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public int getTotalWaitTime() {
        return totalWaitTime;
    }

    public void addBarber(Barber b)
    {
        barbers.add(b);
    }

    @Override
    public void update() {
        updateWaiters();
        updateBarbers();
        clock++;
    }

    private void updateBarbers() {
        ArrayList<Barber> idles = new ArrayList<>();

        for (Barber b: barbers) {
            b.update(clock);
            if (b.isIdle())
                idles.add(b);
        }

        while (!customers.isEmpty() && !idles.isEmpty())
        {
            Customer customer = csp.select(customers,clock);
            Barber barber = bsp.select(idles,clock,customer);

            barber.takeCustomer(customer,clock);

            customers.remove(customer);
            idles.remove(barber);

             totalMoney += customer.getJob().toMoney();

        }
    }

    private void updateWaiters() {

        totalWaitTime += customers.size();

        Customer customer = vicinity.generate(clock);

        if (customer == null) // NO Customer arrived
            return;

        if (customers.size()>=capacity)
        {
            rejectCustomer(customer);
            return;
        }

        customers.add(customer);
        totalCustomerCount++;


    }

    private void rejectCustomer(Customer customer) {
        rejectedCustomerCount++;
    }

    @Override
    public void init() {
        customers.clear();
        clock = DEFAULT_START_TIME;
        totalMoney =0;
        totalCustomerCount =0;
        totalWaitTime = 0;
        rejectedCustomerCount =0;

        for (Barber b: barbers)
            b.init(clock);

    }

    public double averageWaitingTime() {
        if (totalCustomerCount==0)
            return 0.0;

        return (double) totalWaitTime / totalCustomerCount;
    }
}
