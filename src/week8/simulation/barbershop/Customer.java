package week8.simulation.barbershop;

public class Customer {
    private BarberJob job;
    private int arrivalTime;

    public Customer(BarberJob job, int arrivalTime) {
        this.job = job;
        this.arrivalTime = arrivalTime;
    }

    public BarberJob getJob() {
        return job;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }
}
