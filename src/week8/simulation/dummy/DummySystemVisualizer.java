package week8.simulation.dummy;

import week3.utils.ConsolUtils;
import week8.simulation.Simulatable;
import week8.simulation.SystemVisualizer;

public class DummySystemVisualizer implements SystemVisualizer {
    @Override
    public void display(Simulatable system) {
        DummySystem dummy = (DummySystem) system;
        ConsolUtils.clearScreen();
        System.out.println(ConsolUtils.colorize("["+ dummy.getX()+ "]",ConsolUtils.ANSI_CYAN));
    }
}
