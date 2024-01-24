package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MemTracker implements Store {

    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    @Override
    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    @Override
    public List<Item> findAll() {
        return List.copyOf(items);
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        for (Item name : items) {
            if (Objects.equals(name.getName(), key)) {
                result.add(name);
            }
        }
        return result;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    @Override
    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    @Override
    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            item.setId(id);
            items.set(index, item);
        }
        return rsl;
    }

    @Override
    public void delete(int id) {
        int index = indexOf(id);
        if (index == -1) {
            throw new IllegalArgumentException(String.format(
                    "Ошибка удаления заявки. По указанному id = %s заявка не найдена", id));
        }
        items.remove(index);
    }

    @Override
    public void close() {
    }
}