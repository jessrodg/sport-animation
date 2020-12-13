package com.jess.sports;

public class Position {

    private double x, y, z;

    public Position(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void move(VelocityVector velocity) {
        this.x = this.x + velocity.getX();
        this.y = this.y + velocity.getY();
        this.z = this.z + velocity.getZ();
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }
}
