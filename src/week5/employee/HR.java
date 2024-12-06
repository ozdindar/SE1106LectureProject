package week5.employee;

import java.util.ArrayList;
import java.util.List;

public class HR {

    void makePayment(ArrayList<Employee> employees)
    {
        for (int e = 0; e < employees.size(); e++) {
            System.out.println(employees.get(e).getName() + " is paid by " + employees.get(e).getPayment());
        }
    }

    public static void main(String[] args) {
        ArrayList<Employee> staff = new ArrayList<>();
        staff.add(new Servant("Ali"));
        staff.add(new Servant("Ayşe"));
        staff.add(new Servant("Sevgi"));
        staff.add(new Manager("Bülent"));

        HR hr = new HR();

        hr.makePayment(staff);
    }
}
