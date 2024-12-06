package week5.coffeshop_v2;

import java.util.ArrayList;

public class Cashier {
    double totalPrice(ArrayList<Beverage> order)
    {
        double total =0.0;

        for (int b = 0; b < order.size(); b++) {
            total += order.get(b).getPrice();
        }

        return total;
    }
}
