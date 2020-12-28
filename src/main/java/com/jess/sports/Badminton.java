package com.jess.sports;

import com.jess.framework.Sport;

import static com.jess.framework.Engine.graphics;

public class Badminton implements Sport {

    private double actualShuttleSize;
    private double perceivedShuttleSize;

    private double shuttleVelocity_x, shuttleVelocity_y, shuttleVelocity_z;
    private double shuttlePosition_x, shuttlePosition_y, shuttlePosition_z;

    public Badminton(double actualShuttleSize, double shuttlePosition_x, double shuttlePosition_y, double shuttlePosition_z, double shuttleVelocity_x, double shuttleVelocity_y, double shuttleVelocity_z) {
        this.actualShuttleSize = actualShuttleSize;
        this.shuttlePosition_x = shuttlePosition_x;
        this.shuttlePosition_y = shuttlePosition_y;
        this.shuttlePosition_z = shuttlePosition_z;
        this.shuttleVelocity_x = shuttleVelocity_x;
        this.shuttleVelocity_y = shuttleVelocity_y;
        this.shuttleVelocity_z = shuttleVelocity_z;
    }

    public Badminton() {
        this(1000, 1, 2, -30, 0.1, 0.1, 0.1);
    }

    @Override
    public void update() {
        move(shuttleVelocity_x, shuttleVelocity_y, shuttleVelocity_z);
        perceivedShuttleSize = this.actualShuttleSize / Math.pow(this.shuttlePosition_z, 2);
    }

    public void move(double shuttleVelocity_x, double shuttleVelocity_y, double shuttleVelocity_z) {
        this.shuttlePosition_x = this.shuttlePosition_x + shuttleVelocity_x;
        this.shuttlePosition_y = this.shuttlePosition_y + shuttleVelocity_y;
        this.shuttlePosition_z = this.shuttlePosition_z + shuttleVelocity_z;
    }

    @Override
    public void render() {
        graphics.fillOval((int) shuttlePosition_x, (int) shuttlePosition_y, (int) this.perceivedShuttleSize, (int) this.perceivedShuttleSize);
    }

    public double getPerceivedShuttleSize() {
        return perceivedShuttleSize;
    }

    public double getShuttlePosition_x() {
        return shuttlePosition_x;
    }

    public double getShuttlePosition_y() {
        return shuttlePosition_y;
    }

    public double getShuttlePosition_z() {
        return shuttlePosition_z;
    }
}
