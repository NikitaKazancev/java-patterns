package com.example.tests.patterns.structure;

interface MediaPlayer {
    void play(String fileName);
}

class Mp3Player implements MediaPlayer {
    public void play(String fileName) {}
}
class Mp4Player implements MediaPlayer {
    public void play(String fileName) {}
}

class Mp3Adapter implements MediaPlayer {
    private final MediaPlayer player;
    public Mp3Adapter(String audioType) {
        if (audioType.equalsIgnoreCase("mp3")) {
            player = new Mp3Player();
        } else {
            player = new Mp4Player();
        }
    }
    @Override
    public void play(String fileName) {
        player.play(fileName);
    }
}
