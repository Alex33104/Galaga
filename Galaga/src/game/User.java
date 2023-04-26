package game;

public class User {
    private float x;
    private final float y = 0;
    private double w;
    private double h;
    private double dx = 7.5;

    public User(double h, double w) {
        this.w = w;
        this.h = h;
    }
    public void setX(float x) {this.x = x;}

    public float getX() {return this.x;}

    public float getY() {return this.y;}

    public double getW() {return this.w;}

    public double getH() {return this.h;}
    // new move method for the animation
    public void move() {x += dx;}
}

