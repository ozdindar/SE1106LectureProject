package week8.simulation.dummy;

import week8.simulation.Simulatable;

import java.security.SecureRandom;
import java.util.Random;

public class DummySystem implements Simulatable {

    private static final int MAX_X = 1000;
    private static final int MAX_DELTA = 10;


    Random rng = new SecureRandom();


    public int getX() {
        return x;
    }

    private int x;

    @Override
    public void update() {
        int delta = rng.nextInt(MAX_DELTA);

        if (rng.nextBoolean())
            x += delta;
        else x -= delta;
    }

    @Override
    public void init() {
        x = rng.nextInt(MAX_X);
    }
}
