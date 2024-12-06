package week5.coffeeshop_v1;

public class FilterCoffee {
    CupSize cupSize;
    boolean hasSugar;
    boolean hasMilk;

    public FilterCoffee(CupSize cupSize, boolean hasSugar, boolean hasMilk) {
        this.cupSize = cupSize;
        this.hasSugar = hasSugar;
        this.hasMilk = hasMilk;
    }

    String getName()
    {
        return "Filter Coffee";
    }

    double getPrice()
    {
        double basePrice = 7.0;

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

        if (hasSugar)
            st += " with sugar";

        if (hasMilk)
            st += " with milk";

        st += "(" + getPrice() + " TL)";
        return st;
    }

    public String toString() {
        return "[" + getDescription() + "]";
    }

    public static void main(String[] args) {
        FilterCoffee tc = new FilterCoffee(CupSize.Medium,true,false);

        System.out.println(tc);
    }
}
