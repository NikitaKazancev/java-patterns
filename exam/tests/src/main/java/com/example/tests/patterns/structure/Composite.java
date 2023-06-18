package com.example.tests.patterns.structure;

import java.util.ArrayList;
import java.util.List;

interface Shape {
    void draw();
}

class Circle implements Shape {
    @Override
    public void draw() {}
}
class Square implements Shape {
    @Override
    public void draw() {}
}

class Group implements Shape {
    private final List<Shape> shapes = new ArrayList<>();

    public void addShape(Shape shape) {
        shapes.add(shape);
    }
    public void removeShape(Shape shape) {
        shapes.remove(shape);
    }

    @Override
    public void draw() {
        //
        shapes.forEach(Shape::draw);
    }
}