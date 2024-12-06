package week8.simulation.barbershop;

import java.util.ArrayList;

public interface BarberSelectionPolicy {
    Barber select(ArrayList<Barber> idles, int clock, Customer customer);
}
