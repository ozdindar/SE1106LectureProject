package week5.coffeshop_v2;

public class FilterCoffee extends Beverage{


    public FilterCoffee(CupSize cupSize, boolean hasSugar, boolean hasMilk) {
        super(cupSize, hasSugar, hasMilk);
    }

    String getName()
    {
        return "Filter Coffee";
    }

    @Override
    double getBasePrice() {
        return 0;
    }


}
