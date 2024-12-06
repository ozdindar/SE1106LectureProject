package week8.simulation.barbershop;

import java.security.SecureRandom;
import java.util.Random;

public class UniformArrival implements ArrivalGenerator{

    Random rng = new SecureRandom();

    double arrivalProbability;

    public UniformArrival(double arrivalProbability) {
        this.arrivalProbability = arrivalProbability;
    }

    @Override
    public Customer generate(int clock) {

        if ( rng.nextDouble() < arrivalProbability)
        {
            BarberJob[] values = BarberJob.values();
            BarberJob job =  values[rng.nextInt(values.length) ];
            Customer customer = new Customer(job,clock);
            return customer;
        }
        else return null; // No Customer arrrived!
    }
}
