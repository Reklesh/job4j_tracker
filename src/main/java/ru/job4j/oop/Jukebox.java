package ru.job4j.oop;

public class Jukebox {

    public void music(int position) {
        if (position == 1) {
            System.out.println("Пусть бегут неуклюже");
        } else {
            String songTitle = position == 2 ? "Спокойной ночи" : "Песня не найдена";
            System.out.println(songTitle);
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
