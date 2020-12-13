package com.jess.sports;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

@RunWith(JUnit4.class)
public class BadmintonTest {

    Badminton badminton;
    VelocityVector velocity;

    @Before
    public void setup() {

        Position initialPosition = new Position(1,2,-30);
        velocity = new VelocityVector(4,5,6);
        badminton = new Badminton(1000, initialPosition, velocity);
    }

    @Test
    public void shuttleMovesOnce() {
        badminton.update();
        assertThat(badminton.getPosition().getX(), equalTo(5.0));
        assertThat(badminton.getPosition().getY(), equalTo(7.0));
        assertThat(badminton.getPosition().getZ(), equalTo(-24.0));
    }

    @Test
    public void shuttleMovesTwice() {
        badminton.update();
        badminton.update();
        assertThat(badminton.getPosition().getX(), equalTo(9.0));
        assertThat(badminton.getPosition().getY(), equalTo(12.0));
        assertThat(badminton.getPosition().getZ(), equalTo(-18.0));
    }

    @Test
    public void shuttleSizeIncreases() {
        double initialPerceivedSize = badminton.getPerceivedShuttleSize();
        badminton.update();
        double newPerceivedSize = badminton.getPerceivedShuttleSize();
        assertThat(newPerceivedSize, greaterThan(initialPerceivedSize));
    }

    @Test
    public void shuttleSizeCalculatedCorrectly() {
        badminton.update();
        //TODO calculate the size that it should now be as its obvs not 1
        assertThat(badminton.getPerceivedShuttleSize(), equalTo(1));
    }

}