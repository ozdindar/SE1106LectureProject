package week7.device2;

public class TV implements MultiMediaDevice {
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


    @Override
    public void open() {
        on();
    }

    @Override
    public void close() {
        standBy();
    }

    @Override
    public void volumeUp() {

    }

    @Override
    public void volumeDown() {

    }

    @Override
    public void print() {

    }
}
