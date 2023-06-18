package ru.job4j.ex;

import java.util.Objects;

public class FindEl {

    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int index = 0; index < value.length; index++) {
            if (Objects.equals(value[index], key)) {
                rsl = index;
                break;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("Элемент отсутствует");
        }
        return rsl;
    }

    public static void main(String[] args) {
        try {
            indexOf(new String[]{"Первый", "Второй", "Третий"}, "Четвертый");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
