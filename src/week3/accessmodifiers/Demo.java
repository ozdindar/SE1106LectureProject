package week3.accessmodifiers;

public class Demo {
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setSt(String st) {
        this.st = st;
    }

    int x;
    int y;
    String st;

    public Demo(int x, int y, String st) {
        this.x = x;
        this.y = y;
        this.st = st;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getSt() {
        return st;
    }
}
