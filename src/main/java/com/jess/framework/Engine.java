package com.jess.framework;

import com.jess.sports.Badminton;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Engine implements Runnable {

    public static Graphics graphics;
    public String title;
    public Sport badminton;
    private Display display;
    private int width, height;
    private boolean running = false;
    private Thread thread;

    //Sports
    private BufferStrategy bs;
    private Sport currentSport = null;

    public Engine(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
    }

    private void init() {
        display = new Display(title, width, height);

        badminton = new Badminton();
        this.setSport(badminton);
    }

    private void update() {

        if (getSport() != null) {
            getSport().update();
        }
    }

    private void render() {
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        graphics = bs.getDrawGraphics();
        //Clear Screen
        graphics.clearRect(0, 0, width, height);

        if (getSport() != null) {
            getSport().render();
        }

        bs.show();
        graphics.dispose();
    }

    public void run() {

        init();

        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = java.lang.System.nanoTime();
        long timer = 0;
        int updates = 0;

        while (running) {
            now = java.lang.System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if (delta >= 1) {
                update();
                render();
                updates++;
                delta--;
            }

            if (timer >= 1000000000) {
                updates = 0;
                timer = 0;
            }
        }

    }

    public synchronized void start() {
        if (running) {
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        if (!running) {
            return;
        }
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Sport getSport() {
        return currentSport;
    }

    public void setSport(Sport sport) {
        currentSport = sport;
    }
}
