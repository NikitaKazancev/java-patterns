package com.example.tests.patterns.structure;

interface Color {
    void applyColor();
}

class Red implements Color {
    @Override
    public void applyColor() {}
}
class Blue implements Color {
    @Override
    public void applyColor() {}
}

abstract class Shape {
    protected Color color;
    public Shape(Color color) {
        this.color = color;
    }
    public void setColor(Color color) {
        this.color = color;
    }

    public abstract void draw();
}

class Square extends Shape {
    public Square(Color color) {
        super(color);
    }

    @Override
    public void draw() {
        //
        color.applyColor();
    }
}
class Circle extends Shape {
    public Circle(Color color) {
        super(color);
    }

    @Override
    public void draw() {
        //
        color.applyColor();
    }
}