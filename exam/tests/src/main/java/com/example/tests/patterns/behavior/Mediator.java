package com.example.tests.patterns.behavior;

import java.util.ArrayList;
import java.util.List;

interface Colleague {
    void sendMessage(String message);
    void receiveMessage(String message);
}

interface Mediator {
    void sendMessage(String message, Colleague colleague);
}

class ChatMediator implements Mediator {
    private final List<Colleague> colleagues;
    public ChatMediator() {
        colleagues = new ArrayList<>();
    }
    public void addColleague(Colleague colleague) {
        colleagues.add(colleague);
    }

    @Override
    public void sendMessage(String message, Colleague colleague) {
        for (Colleague c : colleagues) {
            if (c != colleague) {
                c.receiveMessage(message);
            }
        }
    }
}

class User implements Colleague {
    private final String name;
    private final Mediator mediator;

    public User(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    @Override
    public void sendMessage(String message) {
        //
        mediator.sendMessage(message, this);
    }

    @Override
    public void receiveMessage(String message) {}
}