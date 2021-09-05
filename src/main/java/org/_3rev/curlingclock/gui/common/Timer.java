package org._3rev.curlingclock.gui.common;

import processing.core.PApplet;

public class Timer extends AbstractCountdown {

    public Timer(PApplet parent) {
        super(parent);
    }

    public Timer(PApplet parent, float x1, float y1, float x2, float y2) {
        super(parent, x1, y1, x2, y2);
    }

    @Override
    void writeTime(String time) {
        text(time, centerX, centerY);
    }
}
