package org._3rev.curlingclock.gui.common;

import org._3rev.curlingclock.gui.SubPanel;
import processing.core.PApplet;

public abstract class AbstractCountdown extends SubPanel {

    public AbstractCountdown(PApplet parent) {
        super(parent);
    }

    public AbstractCountdown(PApplet parent, float x1, float y1, float x2, float y2) {
        super(parent, x1, y1, x2, y2);
    }

    @Override
    public void setup() {
        fitText("00:11:22");
        setTextAlign(PApplet.CENTER, PApplet.BOTTOM);
    }

    public void draw(int totalSec) {
        int seconds = totalSec % 60;
        int totalMinutes = totalSec / 60;
        int minutes = totalMinutes % 60;
        int hours = totalMinutes / 60;

        String time = PApplet.nf(hours, 2) + ":" + PApplet.nf(minutes, 2) + ":" + PApplet.nf(seconds, 2);

        parent.fill(255, 0, 0);

        writeTime(time);
    }

    abstract void writeTime(String time);
}
