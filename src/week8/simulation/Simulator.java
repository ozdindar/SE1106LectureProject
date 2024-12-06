package week8.simulation;

import week3.utils.ConsolUtils;

public class Simulator {
    Simulatable system;
    SystemVisualizer visualizer;

    boolean displaySimulation;

    public void setPauseInterval(int pauseInterval) {
        this.pauseInterval = pauseInterval;
    }

    int pauseInterval;


    public Simulator(Simulatable system, SystemVisualizer visualizer) {
        this.system = system;
        this.visualizer = visualizer;
    }


    public void setDisplaySimulation(boolean displaySimulation) {
        this.displaySimulation = displaySimulation;
    }

    public void simulate(int stepCount)
    {
        system.init();
        for (int s = 0; s < stepCount; s++) {
            system.update();

            if (displaySimulation)
                visualizer.display(system);

            if (pauseInterval>0)
                ConsolUtils.pause(pauseInterval);
        }

        visualizer.display(system);
    }
}
