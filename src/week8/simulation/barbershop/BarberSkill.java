package week8.simulation.barbershop;

public enum BarberSkill {
    Novice, Moderate, Expert;

    double toTimeCoefficient()
    {
        switch (this)
        {
            case Novice : return 1.5;
            case Moderate: return 1.0;
            case Expert: return 0.5;
            default: return 1.0;
        }
    }

}
