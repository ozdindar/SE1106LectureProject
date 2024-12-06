package week5.coffeshop_v2;

public class Espresso extends Beverage {


    public Espresso(CupSize cupSize, boolean hasSugar, boolean hasMilk) {
        super(cupSize, hasSugar, hasMilk);
    }

    String getName()
    {
        return "Espresso";
    }

    @Override
    double getBasePrice() {
        return 15.0;
    }


}
