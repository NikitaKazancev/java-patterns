package com.example.tests.patterns.behavior;

import java.util.Iterator;

class CustomCollection implements Iterable<String> {
    private String[] elements;
    private int size;
    public CustomCollection() {
        elements = new String[10];
        size = 0;
    }

    public void add(String element) {
        if (size < elements.length) {
            elements[size] = element;
            size++;
        }
    }

    @Override
    public Iterator<String> iterator() {
        return new CustomIterator();
    }

    private class CustomIterator implements Iterator<String> {
        private int currentIndex;
        public CustomIterator() {
            currentIndex = 0;
        }

        @Override
        public boolean hasNext() {
            return currentIndex < size && elements[currentIndex] != null;
        }
        @Override
        public String next() {
            String element = elements[currentIndex];
            currentIndex++;
            return element;
        }
    }
}