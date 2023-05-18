package ru.job4j.oop;

public class Jukebox {

    public void music(int position) {
        switch (position) {
            case 1 -> System.out.println("Пусть бегут неуклюже");
            case 2 -> System.out.println("Спокойной ночи");
            default -> System.out.println("Песня не найдена");
        }
    }

    public static void main(String[] args) {
        Jukebox petya = new Jukebox();
        int song1 = 1;
        int song2 = 2;
        int song3 = 3;
        petya.music(song1);
        petya.music(song2);
        petya.music(song3);
    }
}
