package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class JobDescByNameTest {
    @Test
    public void whenSortDescendingOrder() {
        List<Job> items = Arrays.asList(
                new Job("Barman", 3),
                new Job("Doctor", 2),
                new Job("Architect", 1)
        );
        items.sort(new JobDescByName());
        List<Job> expected = Arrays.asList(
                new Job("Doctor", 2),
                new Job("Barman", 3),
                new Job("Architect", 1)
        );
        assertThat(items).isEqualTo(expected);
    }
}