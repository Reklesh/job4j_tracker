package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FullSearch {

    public Set<String> extractNumber(List<Task> list) {
        Set<String> set = new HashSet<>();
        for (Task task : list) {
            set.add(task.getNumber());
        }
        return set;
    }
}
