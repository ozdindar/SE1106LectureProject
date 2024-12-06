package week8;

import week8.simulation.barbershop.ArrivalGenerator;
import week8.simulation.barbershop.Customer;

public class JobDependentArrival implements ArrivalGenerator {

    double[]  jobProbabilities = { 0.2, 0.1, 0.1, 0.1, 0.02};




    @Override
    public Customer generate(int clock) {
        return null;
    }
}
