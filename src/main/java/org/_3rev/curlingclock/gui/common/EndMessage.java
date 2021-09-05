package org._3rev.curlingclock.gui.common;

import org._3rev.curlingclock.gui.SubPanel;
import processing.core.PApplet;
import processing.core.PConstants;

public class EndMessage extends SubPanel {

    private static final String GOOD = "Good";
    private static final String CURLING = "Curling!";

    public EndMessage(PApplet parent) {
        super(parent);
    }

    @Override
    public void setup() {
        fitText(CURLING, x1, centerY, x2, y2);
        setTextAlign(PConstants.CENTER, PConstants.BOTTOM);
    }

    public void draw() {
        parent.fill(255, 0, 0);
        text(GOOD, centerX, centerY);
        text(CURLING, centerX, bottom);
    }
}
