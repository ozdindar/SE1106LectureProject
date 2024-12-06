package week8;


import week8.simulation.Simulatable;
import week8.simulation.SystemVisualizer;
import week8.simulation.barbershop.Barber;
import week8.simulation.barbershop.BarberShop;
import week8.utils.ConsolUtils;

import java.util.ArrayList;

public class SimpleBarberShopVisualizer  implements SystemVisualizer {
    @Override
    public void display(Simulatable system) {

        ConsolUtils.clearScreen();

        BarberShop bs = (BarberShop) system;

        System.out.println(ConsolUtils.colorize("CLOCK:"+ bs.getClock(),ConsolUtils.YELLOW_BOLD_BRIGHT));

        System.out.print(ConsolUtils.colorize("      Total Money:",ConsolUtils.YELLOW_BOLD_BRIGHT));
        System.out.println(bs.getTotalMoney());

        System.out.print(ConsolUtils.colorize("  Total Customers:",ConsolUtils.YELLOW_BOLD_BRIGHT));
        System.out.println(bs.getTotalCustomerCount());

        System.out.print(ConsolUtils.colorize("    Total Waiters:",ConsolUtils.YELLOW_BOLD_BRIGHT));
        System.out.println(bs.getCustomers().size());

        System.out.print(ConsolUtils.colorize("Rejected Customer:",ConsolUtils.YELLOW_BOLD_BRIGHT));
        System.out.println( ConsolUtils.colorize(bs.getRejectedCustomerCount()+"",ConsolUtils.ANSI_RED));


        System.out.print(ConsolUtils.colorize("  Avg. Wait Time:",ConsolUtils.YELLOW_BOLD_BRIGHT));
        System.out.println( bs.averageWaitingTime());

        System.out.println();
        System.out.println(ConsolUtils.colorize("--------------------------------------------------",ConsolUtils.BLUE_BOLD_BRIGHT));
        System.out.println();
        drawBarbers(bs.getBarbers());

    }

    private void drawBarbers(ArrayList<Barber> barbers) {
        for (Barber b: barbers)
            drawBarber(b);
    }

    private void drawBarber(Barber b) {
        System.out.print(ConsolUtils.colorize(b.getName(),ConsolUtils.YELLOW_BOLD_BRIGHT));
        System.out.print("  "+ b.getSkill());
        System.out.print("  " + b.getState());

        if (b.getCustomer() !=null)
            System.out.print("  " + b.getCustomer().getJob());

        System.out.println();


    }

}
