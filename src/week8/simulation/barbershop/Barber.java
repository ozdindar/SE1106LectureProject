package week8.simulation.barbershop;

public class Barber {

    String name;
    BarberSkill skill;
    BarberState state;
    Customer customer;

    int servedCustomerCount;
    int totalMoney;
    int totalIdleTime;
    int lastStateChangeTime;


    public Barber(String name, BarberSkill skill) {
        this.name = name;
        this.skill = skill;
    }

    public String getName() {
        return name;
    }

    public BarberSkill getSkill() {
        return skill;
    }

    public BarberState getState() {
        return state;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getServedCustomerCount() {
        return servedCustomerCount;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public int getTotalIdleTime() {
        return totalIdleTime;
    }

    public int getLastStateChangeTime() {
        return lastStateChangeTime;
    }

    public void init(int clock) {
        state = BarberState.Idle;
        servedCustomerCount = 0;
        totalMoney =0;
        totalIdleTime =0;
        lastStateChangeTime= clock;
        customer = null;
    }

    public void update(int clock) {

        switch (state)
        {
            case Busy:
            {
                int serviceTime = serviceTime();
                if ( clock-lastStateChangeTime >= serviceTime)
                {
                    state = BarberState.Resting;
                    lastStateChangeTime = clock;
                    customer = null;

                }
                break;
            }
            case Resting:
            {
                if (clock-lastStateChangeTime >= BarberShop.REST_TIME)
                {
                    state = BarberState.Idle;
                    lastStateChangeTime = clock;
                }
            }
        }
    }

    public int serviceTime() {
        if (customer == null)
            return 0;

        int time = (int) (customer.getJob().toTime()*skill.toTimeCoefficient());

        return time;

    }

    public boolean isIdle() {
        return state== BarberState.Idle;
    }

    public void takeCustomer(Customer customer, int clock) {

        totalIdleTime += clock-lastStateChangeTime;
        state = BarberState.Busy;
        lastStateChangeTime = clock;
        totalMoney += customer.getJob().toMoney();
        this.customer = customer;
        servedCustomerCount++;



    }
}
