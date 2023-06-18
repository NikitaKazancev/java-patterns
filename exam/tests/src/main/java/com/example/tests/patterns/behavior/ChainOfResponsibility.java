package com.example.tests.patterns.behavior;

class Request {
    private final String type;
    public Request(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }
}

interface Handler {
    void setNextHandler(Handler nextHandler);
    void handleRequest(Request request);
}

class ConcreteHandler1 implements Handler {
    private Handler nextHandler;

    @Override
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }
    @Override
    public void handleRequest(Request request) {
        if (request.getType().equals("type1")) {
            System.out.println("ConcreteHandler1");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        } else {
            System.out.println("End of chain");
        }
    }
}
class ConcreteHandler2 implements Handler {
    private Handler nextHandler;

    @Override
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }
    @Override
    public void handleRequest(Request request) {
        if (request.getType().equals("type2")) {
            System.out.println("ConcreteHandler2");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        } else {
            System.out.println("End of chain");
        }
    }
}