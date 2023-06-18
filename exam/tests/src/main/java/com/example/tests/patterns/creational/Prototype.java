package com.example.tests.patterns.creational;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
abstract class Prototype {
    public int id;
    public Prototype(int id) {
        this.id = id;
    }

    public abstract Prototype clone();
}

class ConcretePrototype1 extends Prototype {
    public ConcretePrototype1(int id) {
        super(id);
    }

    @Override
    public Prototype clone() {
        return new ConcretePrototype1(id);
    }
}
class ConcretePrototype2 extends Prototype {
    public ConcretePrototype2(int id) {
        super(id);
    }

    @Override
    public Prototype clone() {
        return new ConcretePrototype2(id);
    }
}