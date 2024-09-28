package org._3rev.curlingclock.gui.clock;

import org._3rev.curlingclock.gui.SubPanel;
import processing.core.PApplet;

public class ClockPanel extends SubPanel {
    public ClockPanel(PApplet parent) {
        super(parent);
    }

    public ClockPanel(PApplet parent, float x1, float y1, float x2, float y2) {
        super(parent, x1, y1, x2, y2);
    }

    @Override
    public void setup() {
        fitText("99:99 PM");
        setTextAlign(PApplet.CENTER, PApplet.CENTER);
    }

    public void draw() {
        writeTime();
    }

    private void writeTime() {
        parent.fill(255, 0, 0);

        int m = PApplet.minute();
        int h = PApplet.hour();
        String ampm;

        if (h == 0) {
            h = 12;
            ampm = "am";
        } else if (h ==12){
            ampm = "pm";
        }else if (h > 12) {
            h = h - 12;
            ampm = "pm";
        } else {
            ampm = "am";
        }

        text(PApplet.nf(h, 2) + ":" + PApplet.nf(m, 2) + " " + ampm, centerX, centerY);
    }
}

