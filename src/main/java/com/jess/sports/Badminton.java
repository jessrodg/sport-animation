package com.jess.sports;

import com.jess.framework.Sport;

import static com.jess.framework.Engine.graphics;

public class Badminton implements Sport {

    private final double actualShuttleSize;
    private double perceivedShuttleSize;
    private final Position position;
    private final VelocityVector shuttleVelocity;

    public Badminton(double actualShuttleSize, Position position, VelocityVector shuttleVelocity) {
        this.actualShuttleSize = actualShuttleSize;
        this.position = position;
        this.shuttleVelocity = shuttleVelocity;
    }

    public Badminton() {
        this(1000, new Position(1, 2, -30), new VelocityVector(0.1, 0.1, 0.1));
    }

    @Override
    public void update() {
        position.move(shuttleVelocity);
        perceivedShuttleSize = this.actualShuttleSize / Math.pow(position.getZ(), 2);
    }

    @Override
    public void render() {
        graphics.fillOval((int) position.getX(), (int) position.getY(), (int) this.perceivedShuttleSize, (int) this.perceivedShuttleSize);
    }

    public double getPerceivedShuttleSize() {
        return perceivedShuttleSize;
    }

    public Position getPosition() {
        return position;
    }
}
