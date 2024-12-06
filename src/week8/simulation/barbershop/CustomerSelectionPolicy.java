package week8.simulation.barbershop;

import java.util.ArrayList;

public interface CustomerSelectionPolicy {
    Customer select(ArrayList<Customer> customers, int clock);
}
