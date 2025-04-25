package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import ru.job4j.toone.User;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class HbmTrackerTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test");
            tracker.add(item);
            Item result = tracker.findById(item.getId());
            assertThat(result.getName()).isEqualTo(item.getName());
        }
    }

    @Test
    public void whenAddItemWithUnsavedUserThenItemNotSaved() {
        try (var tracker = new HbmTracker()) {
            Item item = new Item("test");
            User user = new User();
            user.setName("User");
            item.setParticipates(List.of(user));
            tracker.add(item);
            Item result = tracker.findById(item.getId());
            assertThat(result).isNull();
            assertThat(tracker.findAll()).isEmpty();
        }
    }

    @Test
    public void whenTestFindAll() {
        try (var tracker = new HbmTracker()) {
            Item first = new Item("First");
            Item second = new Item("Second");
            tracker.add(first);
            tracker.add(second);
            Item result = tracker.findAll().get(0);
            assertThat(result).isEqualTo(first);
        }
    }

    @Test
    public void whenTestFindByNameCheckArrayLength() {
        try (var tracker = new HbmTracker()) {
            Item first = new Item("First");
            Item second = new Item("Second");
            tracker.add(first);
            tracker.add(second);
            tracker.add(new Item("First"));
            tracker.add(new Item("Second"));
            tracker.add(new Item("First"));
            List<Item> result = tracker.findByName(first.getName());
            assertThat(result.size()).isEqualTo(3);
        }
    }

    @Test
    public void whenTestFindByNameCheckSecondItemName() {
        try (var tracker = new HbmTracker()) {
            Item first = new Item("First");
            Item second = new Item("Second");
            tracker.add(first);
            tracker.add(second);
            tracker.add(new Item("First"));
            tracker.add(new Item("Second"));
            tracker.add(new Item("First"));
            List<Item> result = tracker.findByName(second.getName());
            assertThat(result.get(0).getName()).isEqualTo(second.getName());
        }
    }

    @Test
    public void whenReplaceItemIsSuccessful() {
        try (var tracker = new HbmTracker()) {
            Item item = new Item("Bug");
            tracker.add(item);
            int id = item.getId();
            Item updateItem = new Item("Bug with description");
            tracker.replace(id, updateItem);
            assertThat(tracker.findById(id).getName()).isEqualTo("Bug with description");
        }
    }

    @Test
    public void whenReplaceItemIsNotSuccessful() {
        try (var tracker = new HbmTracker()) {
            Item item = new Item("Bug");
            tracker.add(item);
            Item updateItem = new Item("Bug with description");
            boolean result = tracker.replace(1000, updateItem);
            assertThat(tracker.findById(item.getId()).getName()).isEqualTo("Bug");
            assertThat(result).isFalse();
        }
    }

    @Test
    public void whenDeleteItemIsSuccessful() {
        try (var tracker = new HbmTracker()) {
            Item item = new Item("test");
            tracker.add(item);
            int id = item.getId();
            tracker.delete(id);
            assertThat(tracker.findById(id)).isNull();
        }
    }

    @Test
    public void whenDeleteItemIsNotSuccessful() {
        try (var tracker = new HbmTracker()) {
            Item item = new Item("test");
            tracker.add(item);
            tracker.delete(1000);
            assertThat(tracker.findById(item.getId())).isEqualTo(item);
        }
    }
}