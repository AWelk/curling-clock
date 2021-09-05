package org._3rev.curlingclock.gui.common;

import processing.core.PApplet;
import processing.sound.SoundFile;

public class Beeper {

    private static SoundFile file;

    public Beeper(PApplet parent) {
        if (file == null) {
            file = new SoundFile(parent, "beep.wav");
        }
    }

    public void beep() {
        if (!file.isPlaying()) {
            file.play();
        }
    }
}
