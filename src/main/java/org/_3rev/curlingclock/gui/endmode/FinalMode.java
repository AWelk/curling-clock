package org._3rev.curlingclock.gui.endmode;

import org._3rev.curlingclock.gui.SubPanel;
import org._3rev.curlingclock.gui.common.AbstractCountdown;
import org._3rev.curlingclock.gui.common.BarTimer;
import org._3rev.curlingclock.gui.common.EndMessage;
import processing.core.PApplet;

import static org._3rev.curlingclock.gui.common.Constants.NUM_ENDS;

public class FinalMode extends SubPanel implements TimerMode {

    private int totalSec;
    private int duration;
    private AbstractCountdown countdownClock;
    private ProgressBar bar;
    private EndMessage endMessage;

    FinalMode(PApplet parent) {
        super(parent);
    }

    FinalMode(PApplet parent, float x1, float y1, float x2, float y2) {
        super(parent, x1, y1, x2, y2);
    }

    @Override
    public void setup() {
        countdownClock = new BarTimer(parent, left, top, right, centerY);
        countdownClock.setup();

        bar = new ProgressBar(parent, left, centerY, right, bottom, NUM_ENDS);
        bar.setup();

        endMessage = new EndMessage(parent);
        endMessage.setup();
    }

    public boolean draw() {
        if (totalSec < 0) {
            endMessage.draw();
        } else {
            countdownClock.draw(totalSec);
            bar.draw(PApplet.map((duration - totalSec), 0, duration, 0, 100));
        }
        totalSec--;

        // Switch to clock after 10 minutes
        return totalSec < -600;
    }

    @Override
    public void setTime(int seconds) {
        duration = seconds;
        totalSec = duration;
    }
}
