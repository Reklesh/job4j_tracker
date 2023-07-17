package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class ItemAscByNameTest {
    @Test
    public void whenSortAscendingOrder() {
        List<Item> items = Arrays.asList(
                new Item(3, "Cadillac"),
                new Item(2, "Bentley"),
                new Item(1, "Acura")
        );
        items.sort(new ItemAscByName());
        List<Item> expected = Arrays.asList(
                new Item(1, "Acura"),
                new Item(2, "Bentley"),
                new Item(3, "Cadillac")
        );
        assertThat(items).isEqualTo(expected);
    }
}