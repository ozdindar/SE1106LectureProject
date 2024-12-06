package week5.coffeeshop_v1;

public class TurkishCoffee {
    CupSize cupSize;
    boolean hasSugar;
    boolean hasMilk;

    public TurkishCoffee(CupSize cupSize, boolean hasSugar, boolean hasMilk) {
        this.cupSize = cupSize;
        this.hasSugar = hasSugar;
        this.hasMilk = hasMilk;
    }

    String getName()
    {
        return "Turkish Coffee";
    }

    double getPrice()
    {
        double basePrice = 10.0;

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
        TurkishCoffee tc = new TurkishCoffee(CupSize.Medium,true,false);

        System.out.println(tc);
    }
}
