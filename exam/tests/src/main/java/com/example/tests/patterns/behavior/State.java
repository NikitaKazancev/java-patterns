package com.example.tests.patterns.behavior;

interface State {
    void handle(Context context);
}

class Context {
    private State state;

    public Context() {
        state = new ConcreteStateA();
    }

    public void setState(State state) {
        this.state = state;
    }

    public void request() {
        state.handle(this);
    }
}

class ConcreteStateA implements State {
    @Override
    public void handle(Context context) {
        System.out.println("ConcreteStateA");
        context.setState(new ConcreteStateB());
    }
}
class ConcreteStateB implements State {
    @Override
    public void handle(Context context) {
        System.out.println("ConcreteStateB");
        context.setState(new ConcreteStateA());
    }
}
