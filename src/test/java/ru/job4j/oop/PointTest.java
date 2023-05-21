package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    @Test
    public void when1010to1010then0() {
        Point a = new Point(10, 10);
        Point b = new Point(10, 10);
        double dist = a.distance(b);
        double expected = 0;
        Assert.assertEquals(expected, dist, 0.01);
    }

    @Test
    public void when1010toMinus10Minus10then28Dot28() {
        Point a = new Point(10, 10);
        Point b = new Point(-10, -10);
        double dist = a.distance(b);
        double expected = 28.28;
        Assert.assertEquals(expected, dist, 0.01);
    }

    @Test
    public void when040toMinus200then44Dot72() {
        Point a = new Point(0, 40);
        Point b = new Point(-20, 0);
        double dist = a.distance(b);
        double expected = 44.72;
        Assert.assertEquals(expected, dist, 0.01);
    }

    @Test
    public void when04020to20400to5010then8Dot66() {
        Point a = new Point(10, 10, 10);
        Point b = new Point(5, 5, 5);
        double dist = a.distance3d(b);
        double expected = 8.66;
        Assert.assertEquals(expected, dist, 0.01);
    }
}