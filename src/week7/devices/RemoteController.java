package week7.devices;

public class RemoteController {
    TV tv;
    AirConditioner ac;
    GarageDoor door;

    public RemoteController() {
    }

    void introduceTV(TV tv)
    {
        this.tv = tv;
    }

    void introduceAC(AirConditioner ac)
    {
        this.ac = ac;
    }

    void introduceDoor(GarageDoor door)
    {
        this.door = door;
    }

    void tvON()
    {
        tv.on();
    }

    void tvOff()
    {
        tv.standBy();
    }

    void openGarageDoor()
    {
        door.open();
    }

    void closeGarageDoor()
    {
        door.close();
    }

    void powerONAC()
    {
        ac.powerON();
    }

    void powerOFFAC()
    {
        ac.powerOFF();
    }

    public static void main(String[] args) {
        TV tv = new TV();
        AirConditioner ac = new AirConditioner();
        GarageDoor gd = new GarageDoor();

        RemoteController rc = new RemoteController();

        rc.introduceTV(tv);
        rc.introduceAC(ac);
        rc.introduceDoor(gd);


        rc.tvON();
        rc.powerONAC();
        rc.closeGarageDoor();






    }

}
