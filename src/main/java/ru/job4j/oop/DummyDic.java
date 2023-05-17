package ru.job4j.oop;

public class DummyDic {

    public String engToRus(String eng) {
        return "Неизвестное слово. " + eng;
    }

    public static void main(String[] args) {
        DummyDic petya = new DummyDic();
        String word = "Fuck";
        String result = petya.engToRus(word);
        System.out.println(result);
    }
}
