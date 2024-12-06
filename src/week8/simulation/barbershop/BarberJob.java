package week8.simulation.barbershop;

public enum BarberJob {
    LongHairCut, ShortHairCut, Shave, Dying, BrideHead;

    int toMoney()
    {
        switch (this)
        {
            case LongHairCut : return 20;
            case ShortHairCut: return 15;
            case Shave: return 30;
            case Dying: return 50;
            case BrideHead: return 300;
            default: return 300;
        }
    }

    int toTime()
    {
        switch (this)
        {
            case LongHairCut : return 30;
            case ShortHairCut: return 15;
            case Shave: return 10;
            case Dying: return 60;
            case BrideHead: return 120;
            default: return 120;
        }
    }


}
