package week7.device2;


import week5.defaultconstructor.A;

import java.util.ArrayList;

public class RemoteController {

    ArrayList<Openable> devices;
    int currentDevice;

    public RemoteController() {
        devices = new ArrayList<>();
        currentDevice = -1;
    }

    void introduceDevice(Openable device)
    {
        devices.add(device);
    }

    void changeDevice(int index)
    {
        currentDevice = index;
    }


    void open()
    {
        if (currentDevice>=0 && currentDevice<devices.size())
        {
            devices.get(currentDevice).open();
        }
    }
    void close()
    {
        if (currentDevice>=0 && currentDevice<devices.size())
        {
            devices.get(currentDevice).close();
        }
    }




    public static void main(String[] args) {


        RemoteController rc = new RemoteController();

        rc.introduceDevice(new TV());
        rc.introduceDevice(new AirConditioner());
        rc.introduceDevice(new GarageDoor());

        rc.changeDevice(0);

        rc.open();

        rc.changeDevice(1);

        rc.open();





        Openable device = new TV();

        TV tv = (TV)device;


    }

}
