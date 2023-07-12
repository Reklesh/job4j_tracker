package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("ivanov@mail.ru", "Ivanov Ivan Inanovich");
        map.put("ivanov@mail.ru", "Ivanov Petr Petrovich");
        map.put("ivanov@mail.ru", "Ivanov Habib Abdulmanapovich");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
    }
}
