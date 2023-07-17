package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class ItemDescByNameTest {
    @Test
    public void whenSortAscendingOrder() {
        List<Item> items = Arrays.asList(
                new Item(1, "Geely"),
                new Item(2, "Haval"),
                new Item(3, "Chery")
        );
        items.sort(new ItemDescByName());
        List<Item> expected = Arrays.asList(
                new Item(2, "Haval"),
                new Item(1, "Geely"),
                new Item(3, "Chery")
        );
        assertThat(items).isEqualTo(expected);
    }
}