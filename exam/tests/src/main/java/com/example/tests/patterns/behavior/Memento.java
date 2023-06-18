package com.example.tests.patterns.behavior;

class Memento {
    private String state;
    public Memento(String state) {
        this.state = state;
    }
    public String getState() {
        return state;
    }
}

class Originator {
    private String state;
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }

    public Memento saveStateToMemento() {
        return new Memento(state);
    }
    public void restoreStateFromMemento(Memento memento) {
        state = memento.getState();
    }
}

class Caretaker {
    private Memento memento;
    public void setMemento(Memento memento) {
        this.memento = memento;
    }
    public Memento getMemento() {
        return memento;
    }
}

class Main {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();

        originator.setState("State 1");
        //

        caretaker.setMemento(originator.saveStateToMemento());
        originator.setState("State 2");
        //

        originator.restoreStateFromMemento(caretaker.getMemento());
        //
    }
}