package week8.simulation.barbershop;

import week8.SimpleBarberShopVisualizer;
import week8.simulation.Simulator;
import week8.simulation.barbershop.vis.BarberShopVisualizer;

public class Demo {

    public static void main(String[] args) {
        BarberShop bs = new BarberShop( 10,
                                        new UniformArrival(0.1),
                                        new LongestWaiterFirst(),
                                        new LongestIdleFirst());

        bs.addBarber(new Barber("Tibet",BarberSkill.Expert));
        bs.addBarber(new Barber("Koray",BarberSkill.Novice));
        bs.addBarber(new Barber("Sevgi",BarberSkill.Moderate));
        bs.addBarber(new Barber("Fatma",BarberSkill.Expert));

        Simulator simulator = new Simulator(bs, new BarberShopVisualizer());

        simulator.setPauseInterval(1000);
        simulator.setDisplaySimulation(true);

        simulator.simulate(100000);
    }
}
