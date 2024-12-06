package week5.coffeshop_v2;


import java.util.ArrayList;

public abstract class Beverage {
    CupSize cupSize;
    boolean hasSugar;
    boolean hasMilk;

    public Beverage(CupSize cupSize, boolean hasSugar, boolean hasMilk) {
        this.cupSize = cupSize;
        this.hasSugar = hasSugar;
        this.hasMilk = hasMilk;
    }

    abstract String getName();

    abstract double getBasePrice();

    double getPrice()
    {
        double basePrice = getBasePrice();

        if (hasSugar)
            basePrice += 1.0;
        if (hasMilk)
            basePrice += 1.0;

        return basePrice*cupSize.toPriceCoefficient();
    }

    String getDescription()
    {
        String st = getName();

        st += " " + cupSize.toCode();

        st += "(" + getPrice() + " TL)";

        if (hasSugar)
            st += " with sugar";

        if (hasMilk)
            st += " with milk";


        return st;
    }

    public String toString() {
        return "[" + getDescription() + "]";
    }

    public static void main(String[] args) {
        TurkishCoffee tc = new TurkishCoffee(CupSize.Medium,true,false,true);

        Espresso es = new Espresso(CupSize.Large,true,true);


        Beverage b = new TurkishCoffee(CupSize.Medium,false,false,false);

        ArrayList<Beverage>bList = new ArrayList<>();

        bList.add(new TurkishCoffee(CupSize.Medium,false,false,false));
        bList.add(new FilterCoffee(CupSize.Small,false,true));


        System.out.println(tc);
        System.out.println(es);
    }
}
