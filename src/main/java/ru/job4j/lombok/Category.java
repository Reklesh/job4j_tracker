package ru.job4j.lombok;

import lombok.*;

@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
public class Category {

    @EqualsAndHashCode.Include
    private final int id;

    @Setter
    private String name;
}