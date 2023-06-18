package com.example.tests.patterns.structure;

interface Pizza {
    String getDescription();
    double getCost();
}

class Margherita implements Pizza {
    @Override
    public String getDescription() {
        return "Margherita";
    }
    @Override
    public double getCost() {
        return 7.00;
    }
}

abstract class PizzaDecorator implements Pizza {
    protected Pizza pizza;
    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription();
    }
    @Override
    public double getCost() {
        return pizza.getCost();
    }
}

class CheeseDecorator extends PizzaDecorator {
    public CheeseDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with extra cheese";
    }
    @Override
    public double getCost() {
        return super.getCost() + 2
    }
}
class MushroomDecorator extends PizzaDecorator {
    public MushroomDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with mushrooms";
    }
    @Override
    public double getCost() {
        return super.getCost() + 1;
    }
}

class Main {
    public static void main(String[] args) {
        Pizza margherita = new Margherita();
        Pizza ultraMargherita = new CheeseDecorator(new MushroomDecorator(margherita));

        System.out.println(ultraMargherita.getDescription());
        System.out.println(ultraMargherita.getCost());
    }
}