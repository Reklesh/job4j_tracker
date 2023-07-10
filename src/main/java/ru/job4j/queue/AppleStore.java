package ru.job4j.queue;

import java.util.Objects;
import java.util.Queue;

public class AppleStore {

    private final Queue<Customer> queue;

    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        String a = null;
        for (int index = 0; index < count; index++) {
            a = Objects.requireNonNull(queue.poll()).name();
        }
        return a;
    }

    public String getFirstUpsetCustomer() {
        String b = null;
        for (int index = 0; index < count + 1; index++) {
            b = Objects.requireNonNull(queue.poll()).name();
        }
        return b;
    }
}
