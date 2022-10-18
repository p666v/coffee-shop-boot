package ru.itsjava.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Coffee {

    private final String type;

    @Override
    public String toString() {
        return type;
    }
}
