package com.example.tests.patterns.structure;

interface Image {
    void display();
}

class RealImage implements Image {
    private final String filename;
    public RealImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {}
}

class ImageProxy implements Image {
    private final String filename;
    private Image image;
    public ImageProxy(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (image == null) {
            image = new RealImage(filename);
        }
        image.display();
    }
}