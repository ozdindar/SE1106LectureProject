package week8.simulation.barbershop;

import java.util.ArrayList;

public class LongestIdleFirst implements BarberSelectionPolicy{
    @Override
    public Barber select(ArrayList<Barber> idles, int clock, Customer customer) {
        if (idles.isEmpty())
            return null;

        Barber barber = idles.get(0);

        for (int c =1 ; c<idles.size();c++)
        {
            if ( barber.getLastStateChangeTime()> idles.get(c).getLastStateChangeTime())
                barber = idles.get(c);
        }

        return barber;
    }
}
