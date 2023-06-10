package ru.job4j.cast;

public class Plane implements Vehicle {
    @Override
    public void move() {
        System.out.println("Самолет летает в воздухе");
    }

    @Override
    public void speed() {
        System.out.println("Скорость самолета 1000 км/ч");
    }
}
