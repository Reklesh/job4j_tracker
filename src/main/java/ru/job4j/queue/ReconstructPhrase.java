package ru.job4j.queue;

import java.util.Deque;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;
    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        int length = evenElements.size() / 2;
        StringBuilder builder = new StringBuilder();
        for (int index = 0; index < length; index++) {
            builder.append(evenElements.poll());
            evenElements.poll();
        }
        return String.valueOf(builder);
    }

    private String getDescendingElements() {
        int length = descendingElements.size();
        StringBuilder stringBuilder = new StringBuilder();
        for (int index = 0; index < length; index++) {
            stringBuilder.append(descendingElements.pollLast());
        }
        return String.valueOf(stringBuilder);
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
