package week8.simulation;

import week8.simulation.dummy.DummySystem;
import week8.simulation.dummy.DummySystemVisualizer;

public class Demo {
    public static void main(String[] args) {
        Simulatable system = new DummySystem();
        SystemVisualizer visualizer = new DummySystemVisualizer();

        Simulator simulator = new Simulator(system,visualizer);
        simulator.setDisplaySimulation(true);
        simulator.setPauseInterval(1000);

        simulator.simulate(10000);
    }
}
