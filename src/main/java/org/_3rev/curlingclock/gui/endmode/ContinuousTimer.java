package org._3rev.curlingclock.gui.endmode;

import org._3rev.curlingclock.gui.SubPanel;
import processing.core.PApplet;

public class ContinuousTimer extends SubPanel {

    ContinuousTimer(PApplet parent) {
        super(parent);
    }

    ContinuousTimer(PApplet parent, float x1, float y1, float x2, float y2) {
        super(parent, x1, y1, x2, y2);
    }

    @Override
    public void setup() {
        setTextAlign(PApplet.CENTER, PApplet.BOTTOM);
        fitText("+00:11:22");
    }

    public void draw(int totalSec) {
        Direction direction = totalSec > 0 ? Direction.NEGATIVE : Direction.POSITIVE;
        totalSec = Math.abs(totalSec);
        int seconds = totalSec % 60;
        int totalMinutes = totalSec / 60;
        int minutes = totalMinutes % 60;
        int hours = totalMinutes / 60;

        String time = direction + PApplet.nf(hours, 2) + ":" + PApplet.nf(minutes, 2) + ":" + PApplet.nf(seconds, 2);

        parent.fill(255, 0, 0);

        text(time, centerX, bottom);
    }

    private enum Direction {

        POSITIVE("+"),
        NEGATIVE(" ");

        private final String symbol;

        Direction(String symbol) {
            this.symbol = symbol;
        }

        @Override
        public String toString() {
            return this.symbol;
        }
    }
}
