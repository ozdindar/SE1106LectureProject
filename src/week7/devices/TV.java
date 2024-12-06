package week7.devices;

public class TV {
    boolean standBy;
    int channel;
    int volume;

    public TV() {
        standBy = true;
        channel = 1;
        volume = 8;
    }

    public boolean isStandBy() {
        return standBy;
    }

    public int getChannel() {
        return channel;
    }

    public int getVolume() {
        return volume;
    }

    public void on()
    {
        standBy = false;
        System.out.println("TV is ON");
    }

    public  void standBy()
    {
        standBy = true;
        System.out.println("TV is stand by");
    }


}
