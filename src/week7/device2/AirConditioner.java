package week7.device2;

import week7.devices.ACMode;

public class AirConditioner implements Openable,Printable {
    boolean powerON;
    int temperature;
    ACMode mode;

    public AirConditioner()
    {
        this.powerON = false;
        this.temperature = 16;
        this.mode = ACMode.Summer;
    }

    public boolean isPowerON() {
        return powerON;
    }

    public int getTemperature() {
        return temperature;
    }

    public ACMode getMode() {
        return mode;
    }

    public void powerON()
    {
        powerON = true;
        System.out.println("Airconditioner is ON");
    }

    public void powerOFF()
    {
        powerON = false;
        System.out.println("Airconditioner is OFF");
    }

    public void increaseTemperature()
    {
        if (mode!= ACMode.Humidity)
        {
            temperature++;
            System.out.println("The temperature is increased to "+temperature);
        }
    }

    @Override
    public void open() {
        powerON();
    }

    @Override
    public void close() {
        powerOFF();
    }

    @Override
    public void print() {
        System.out.println(mode + " " + temperature);
    }
}
