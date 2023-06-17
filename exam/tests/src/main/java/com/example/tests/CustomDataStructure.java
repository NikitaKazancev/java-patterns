package com.example.tests;

import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;

public class CustomDataStructure<T> {
    private List<T> data;

    public Spliterator<T> spliterator() {
        return new CustomSpliterator<>(data);
    }
}
