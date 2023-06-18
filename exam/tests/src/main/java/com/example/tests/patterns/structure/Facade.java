package com.example.tests.patterns.structure;

class SubsystemA {
    public void operationA() {}
}
class SubsystemB {
    public void operationB() {}
}
class SubsystemC {
    public void operationC() {}
}

class Facade {
    private final SubsystemA subsystemA;
    private final SubsystemB subsystemB;
    private final SubsystemC subsystemC;
    public Facade() {
        subsystemA = new SubsystemA();
        subsystemB = new SubsystemB();
        subsystemC = new SubsystemC();
    }

    public void operation1() {
        subsystemA.operationA();
        subsystemB.operationB();
    }
    public void operation2() {
        subsystemB.operationB();
        subsystemC.operationC();
    }
}