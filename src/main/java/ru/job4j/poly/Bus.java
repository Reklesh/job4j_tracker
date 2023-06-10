package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Пассажиров везет Икарус.");
    }

    @Override
    public void passengers(int number) {
        System.out.println("Количество пассажиров " + number + " человек.");
    }

    @Override
    public double refill(double fuel) {
        return fuel * 50.55;
    }

    public static void main(String[] args) {
        Transport bas = new Bus();
        bas.drive();
        bas.passengers(40);
        System.out.println("Стоимость заправки полного бака: " + bas.refill(500) + " рублей.");
    }
}
