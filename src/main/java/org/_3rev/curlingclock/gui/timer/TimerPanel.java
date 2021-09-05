package org._3rev.curlingclock.gui.timer;

import org._3rev.curlingclock.gui.SubPanel;
import org._3rev.curlingclock.gui.common.AbstractCountdown;
import org._3rev.curlingclock.gui.common.EndMessage;
import org._3rev.curlingclock.gui.common.Timer;
import processing.core.PApplet;

public class TimerPanel extends SubPanel {

    private AbstractCountdown countdownClock;
    private EndMessage endMessage;

    private int duration;

    public TimerPanel(PApplet parent) {
        super(parent);
    }

    public TimerPanel(PApplet parent, float x1, float y1, float x2, float y2) {
        super(parent, x1, y1, x2, y2);
    }

    @Override
    public void setup() {
        countdownClock = new Timer(parent);
        countdownClock.setup();
        countdownClock.setTextAlign(PApplet.CENTER, PApplet.CENTER);

        endMessage = new EndMessage(parent);
        endMessage.setup();
    }

    public void draw() {
        if (duration >= 0) {
            countdownClock.draw(duration);
            duration--;
        } else {
            endMessage.draw();
        }
    }

    public void setTime(int seconds) {
        duration = seconds;
    }
}
