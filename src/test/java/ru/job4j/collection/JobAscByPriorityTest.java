package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class JobAscByPriorityTest {
    @Test
    public void whenSortAscendingPriority() {
        List<Job> items = Arrays.asList(
                new Job("Barman", 3),
                new Job("Doctor", 2),
                new Job("Architect", 1)
        );
        items.sort(new JobAscByPriority());
        List<Job> expected = Arrays.asList(
                new Job("Architect", 1),
                new Job("Doctor", 2),
                new Job("Barman", 3)
        );
        assertThat(items).isEqualTo(expected);
    }
}