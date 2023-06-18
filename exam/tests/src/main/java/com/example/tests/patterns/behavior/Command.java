package com.example.tests.patterns.behavior;

interface Command {
    void exec();
}

class Light {
    public void turnOn() {}
    public void turnOff() {}
}

class TurnOnLightCommand implements Command {
    private final Light light;
    public TurnOnLightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void exec() {
        light.turnOn();
    }
}
class TurnOffLightCommand implements Command {
    private final Light light;
    public TurnOffLightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void exec() {
        light.turnOff();
    }
}

class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }
    public void pressBtn() {
        command.exec();
    }
}