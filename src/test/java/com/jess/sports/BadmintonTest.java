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

    @Before
    public void setup() {

        badminton = new Badminton(1000, 1,2,-30, 4,5,6);
    }

    @Test
    public void shuttleMovesOnce() {
        badminton.update();
        assertThat(badminton.getShuttlePosition_x(), equalTo(5.0));
        assertThat(badminton.getShuttlePosition_y(), equalTo(7.0));
        assertThat(badminton.getShuttlePosition_z(), equalTo(-24.0));
    }

    @Test
    public void shuttleMovesTwice() {
        badminton.update();
        badminton.update();
        assertThat(badminton.getShuttlePosition_x(), equalTo(9.0));
        assertThat(badminton.getShuttlePosition_y(), equalTo(12.0));
        assertThat(badminton.getShuttlePosition_z(), equalTo(-18.0));
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