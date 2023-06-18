package com.example.tests.patterns.behavior;

interface SortingStrategy {
    void sort(int[] array);
}

class BubbleSortStrategy implements SortingStrategy {
    @Override
    public void sort(int[] array) {}
}
class QuickSortStrategy implements SortingStrategy {
    @Override
    public void sort(int[] array) {}
}

class Sorter {
    private SortingStrategy sortingStrategy;

    public void setSortingStrategy(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public void sortArray(int[] array) {
        sortingStrategy.sort(array);
    }
}
