package com.example.tests.patterns.behavior;

abstract class Game {
    abstract void initialize();
    abstract void start();
    abstract void end();

    public final void play() {
        initialize();
        start();
        end();
    }
}

class Football extends Game {
    @Override
    void initialize() {}

    @Override
    void start() {}

    @Override
    void end() {}
}
class Cricket extends Game {
    @Override
    void initialize() {}

    @Override
    void start() {}

    @Override
    void end() {}
}