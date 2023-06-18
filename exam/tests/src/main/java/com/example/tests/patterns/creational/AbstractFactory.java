package com.example.tests.patterns.creational;

interface Shape {
    void draw();
}
interface Color {
    void fill();
}

class Circle implements Shape {
    @Override
    public void draw() {}
}
class Red implements Color {
    @Override
    public void fill() {}
}

class Square implements Shape {
    @Override
    public void draw() {}
}
class Blue implements Color {
    @Override
    public void fill() {}
}

interface AbstractFactory {
    Shape createShape();
    Color createColor();
}

class Factory1 implements AbstractFactory {
    @Override
    public Shape createShape() {
        return new Circle();
    }
    @Override
    public Color createColor() {
        return new Red();
    }
}
class Factory2 implements AbstractFactory {
    @Override
    public Shape createShape() {
        return new Square();
    }
    @Override
    public Color createColor() {
        return new Blue();
    }
}