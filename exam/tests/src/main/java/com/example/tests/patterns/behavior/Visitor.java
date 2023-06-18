package com.example.tests.patterns.behavior;

interface Element {
    void accept(Visitor visitor);
}

class ElementA implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void operationA() {}
}
class ElementB implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void operationB() {}
}

interface Visitor {
    void visit(ElementA element);
    void visit(ElementB element);
}

class ConcreteVisitor implements Visitor {
    @Override
    public void visit(ElementA element) {
        element.operationA();
        //
    }

    @Override
    public void visit(ElementB element) {
        element.operationB();
        //
    }
}

class Main {
    public static void main(String[] args) {
        Element[] elements = {new ElementA(), new ElementB()};
        Visitor visitor = new ConcreteVisitor();

        for (Element element : elements) {
            element.accept(visitor);
        }
    }
}