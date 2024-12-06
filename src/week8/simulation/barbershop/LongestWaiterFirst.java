package week8.simulation.barbershop;

import java.util.ArrayList;

public class LongestWaiterFirst implements CustomerSelectionPolicy{
    @Override
    public Customer select(ArrayList<Customer> customers, int clock) {

        if (customers.isEmpty())
            return null;

        Customer customer = customers.get(0);

        for (int c =1 ; c<customers.size();c++)
        {
            if ( customer.getArrivalTime()> customers.get(c).getArrivalTime())
                customer = customers.get(c);
        }

        return customer;
    }
}
