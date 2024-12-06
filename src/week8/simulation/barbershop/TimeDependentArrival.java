package week8.simulation.barbershop;

public class TimeDependentArrival implements ArrivalGenerator{

    long busyStartTime;
    long busyEndTime;

    long nonBusyStartTime;
    long nonBusyEndTime;

    double busyProbability;
    double normalProbability;
    double nonBusyProbability;


    /**
     * todo: generate customer according to clock!
     * @param clock
     * @return
     */
    @Override
    public Customer generate(int clock) {
        return null;
    }
}
