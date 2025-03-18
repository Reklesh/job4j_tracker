package ru.job4j.lombok;

import lombok.*;

import java.util.List;

@Builder(builderMethodName = "of")
@ToString
@Getter
@Setter
@EqualsAndHashCode(of = {"id", "name"})
public class Permission {
    private int id;
    private String name;

    @Singular("rules")
    private List<String> rules;
}