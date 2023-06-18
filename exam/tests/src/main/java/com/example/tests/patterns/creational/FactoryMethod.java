package com.example.tests.patterns.creational;

interface Vehicle {
    void drive();
}

class Car implements Vehicle {
    @Override
    public void drive() {}
}
class Motorcycle  implements Vehicle {
    @Override
    public void drive() {}
}

interface VehicleFactory {
    Vehicle createVehicle();
}

class CarFactory implements VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        return new Car();
    }
}
class MotorcycleFactory implements VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        return new Motorcycle();
    }
}