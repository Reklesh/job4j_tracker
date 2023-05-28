package ru.job4j.pojo;

import java.util.Objects;

public class Library {

    public static void main(String[] args) {
        Book warAndPeace1 = new Book("Война и мир. Том 1", 310);
        Book warAndPeace2 = new Book("Война и мир. Том 2", 320);
        Book warAndPeace3 = new Book("Война и мир. Том 3", 350);
        Book code = new Book("Clean code", 1);
        Book[] array = new Book[4];
        array[0] = warAndPeace1;
        array[1] = warAndPeace2;
        array[2] = warAndPeace3;
        array[3] = code;
        for (int index = 0; index < array.length; index++) {
            Book ar = array[index];
            System.out.println(ar.getName() + " - " + ar.getCount());
        }
        System.out.println("Переставим первую и последнюю книгу местами:");
        Book a = array[0];
        array[0] = array[3];
        array[3] = a;
        for (int index = 0; index < array.length; index++) {
            Book ar = array[index];
            System.out.println(ar.getName() + " - " + ar.getCount());
        }
        System.out.println("Найдем книгу - Clean code:");
        for (int index = 0; index < array.length; index++) {
            Book ar = array[index];
            if (Objects.equals(ar.getName(), "Clean code")) {
                System.out.println(ar.getName() + " - " + ar.getCount());
            }
        }
    }
}
