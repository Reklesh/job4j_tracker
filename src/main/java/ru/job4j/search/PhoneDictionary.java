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
        Predicate<Person> checkName = per -> per.getName().contains(key);
        Predicate<Person> checkSurname = per -> per.getSurname().contains(key);
        Predicate<Person> checkPhone = per -> per.getPhone().contains(key);
        Predicate<Person> checkAddress = per -> per.getAddress().contains(key);
        Predicate<Person> combine = checkName.or(checkSurname).or(checkPhone).or(checkAddress);
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
