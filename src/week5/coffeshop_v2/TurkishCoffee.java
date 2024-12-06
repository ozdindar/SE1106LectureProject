package week5.coffeshop_v2;

public class TurkishCoffee extends Beverage {

    boolean hasMastic;


    public TurkishCoffee(CupSize cupSize, boolean hasSugar, boolean hasMilk, boolean hasMastic) {
        super(cupSize, hasSugar, hasMilk);

        this.hasMastic = hasMastic;
    }

    String getName()
    {
        return "Turkish Coffee";
    }

    @Override
    double getBasePrice() {
        return 10.0;
    }


    String getDescription()
    {
        String st = super.getDescription();
        if (hasMastic)
        st += " with mastic";

        return st;
    }

    double getPrice()
    {
        double basePrice = super.getPrice();


        if (hasMastic)
            basePrice += 3.0* cupSize.toPriceCoefficient();

        return basePrice;
    }

    public static void main(String[] args) {
        TurkishCoffee tc = new TurkishCoffee(CupSize.Medium,true,false,false);

        System.out.println(tc);
    }
}
