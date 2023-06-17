package com.example.tests;

import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class CustomSpliterator<T> implements Spliterator<T> {
    private List<T> data;
    private int currentIndex;

    public CustomSpliterator(List<T> data) {
        this.data = data;
        this.currentIndex = 0;
    }

    @Override
    public boolean tryAdvance(Consumer<? super T> action) {
        if (currentIndex < data.size()) {
            action.accept(data.get(currentIndex++));
            return true;
        }
        return false;
    }

    @Override
    public Spliterator<T> trySplit() {
        int remainingSize = data.size() - currentIndex;
        if (remainingSize < 10) {
            return null; // Cannot split further
        }

        int splitSize = remainingSize / 2;
        CustomSpliterator<T> newSpliterator = new CustomSpliterator<>(data.subList(currentIndex, currentIndex + splitSize));
        currentIndex += splitSize;
        return newSpliterator;
    }

    @Override
    public long estimateSize() {
        return data.size() - currentIndex;
    }

    @Override
    public int characteristics() {
        return ORDERED | SIZED | SUBSIZED;
    }
}
