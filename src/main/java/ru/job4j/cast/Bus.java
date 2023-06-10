package ru.job4j.cast;

public class Bus implements  Vehicle {
    @Override
    public void move() {
        System.out.println("Автобус двигается по трассе");
    }

    @Override
    public void speed() {
        System.out.println("Скорость автобуса 90 км/ч");
    }
}
