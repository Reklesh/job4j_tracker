package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {

    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        Predicate<Person> a = per -> per.getName().contains(key);
        Predicate<Person> b = per -> per.getSurname().contains(key);
        Predicate<Person> c = per -> per.getPhone().contains(key);
        Predicate<Person> d = per -> per.getAddress().contains(key);
        Predicate<Person> combine = a.or(b).or(c).or(d);
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
