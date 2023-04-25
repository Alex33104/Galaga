package game;

public class User {
    private float x;
    private float y = 0;
    private double w;
    private double h;
    public User(double h, double w) {
        this.w = w;
        this.h = h;
    }
    public void setX(float x) {this.x = x;}

    public void setY(float y) {this.y = y;}

    public float getX() {return this.x;}

    public float getY() {return this.y;}

    public double getW() {return this.w;}

    public double getH() {return this.h;}
}

