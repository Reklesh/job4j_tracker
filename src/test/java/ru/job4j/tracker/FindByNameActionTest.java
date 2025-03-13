package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FindByNameActionTest {

    @Test
    public void whenItemWasFoundByNameSuccessfully() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        String name = "Item";
        FindByNameAction findByNameAction = new FindByNameAction(output);

        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn(name);
        LocalDateTime created = mock(LocalDateTime.class);
        when(created.format(any(DateTimeFormatter.class))).thenReturn("2025-03-13 12:00:00");

        tracker.add(new Item(name, created));
        findByNameAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Find items by name ===" + ln
                        + "Item{created='2025-03-13 12:00:00', id=1, name='Item'}" + ln
        );
    }

    @Test
    public void whenItemWasNotFoundByName() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        FindByNameAction findByNameAction = new FindByNameAction(output);

        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn("Item2");
        LocalDateTime created = mock(LocalDateTime.class);
        when(created.format(any(DateTimeFormatter.class))).thenReturn("2025-03-13 12:00:00");

        tracker.add(new Item("Item", created));
        findByNameAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Find items by name ===" + ln
                        + "Заявки с именем: Item2 не найдены." + ln
        );
    }
}