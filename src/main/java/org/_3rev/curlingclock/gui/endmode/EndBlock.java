package org._3rev.curlingclock.gui.endmode;

import org._3rev.curlingclock.gui.SubPanel;
import processing.core.PApplet;
import processing.core.PConstants;

public class EndBlock extends SubPanel {

    private final String end;

    public EndBlock(int end, PApplet parent, float x1, float y1, float x2, float y2) {
        super(parent, x1, y1, x2, y2);
        this.end = String.valueOf(end);
    }

    @Override
    public void setup() {
        fitText(end);
        setTextAlign(PConstants.CENTER, PConstants.BOTTOM);
    }

    void draw(float percentFilled) {
        parent.rectMode(PConstants.CORNERS);

        parent.fill(255);
        parent.noStroke();
        parent.rect(x1 + width / 10, y1 + height / 10, PApplet.map(percentFilled, 0, 100, x1 + width / 10, x2 - width / 10), y2 - height / 10);

        parent.noFill();
        parent.stroke(255);
        parent.rect(x1 + width / 10, y1 + height / 10, x2 - width / 10, y2 - height / 10);

        parent.fill(255, 0, 0);
        text(end, centerX, bottom);
    }
}
