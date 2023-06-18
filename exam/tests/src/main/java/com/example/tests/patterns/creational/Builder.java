package com.example.tests.patterns.creational;

class Product {
    private String partA;
    private String partB;

    public void setPartA(String partA) {
        this.partA = partA;
    }
    public void setPartB(String partB) {
        this.partB = partB;
    }

    public void show() {
        System.out.println("Product parts:");
        System.out.println("Part A: " + partA);
        System.out.println("Part B: " + partB);
    }
}

interface Builder {
    void buildPartA();
    void buildPartB();
    Product getResult();
}

class ConcreteBuilder implements Builder {
    private final Product product;
    public ConcreteBuilder() {
        this.product = new Product();
    }

    @Override
    public void buildPartA() {
        product.setPartA("Part A");
    }
    @Override
    public void buildPartB() {
        product.setPartB("Part B");
    }
    @Override
    public Product getResult() {
        return product;
    }
}

class Director {
    public void construct(Builder builder) {
        builder.buildPartA();
        builder.buildPartB();
    }
}

class Main {
    public static void main(String[] args) {
        Director director = new Director();

        Builder builder = new ConcreteBuilder();
        director.construct(builder);

        Product product = builder.getResult();
        product.show();
    }
}