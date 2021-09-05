package org._3rev.curlingclock.gui.endmode;

import org._3rev.curlingclock.gui.SubPanel;
import processing.core.PApplet;

import static org._3rev.curlingclock.gui.common.Constants.NUM_ENDS;

public class ContinuousMode extends SubPanel implements TimerMode {

    private ContinuousTimer continuousTimer;
    private ProgressBar bar;

    private int progressBarSeconds;
    private int timerSeconds;
    private int duration;

    ContinuousMode(PApplet parent) {
        super(parent);
    }

    ContinuousMode(PApplet parent, float x1, float y1, float x2, float y2) {
        super(parent, x1, y1, x2, y2);
    }

    @Override
    public void setup() {
        continuousTimer = new ContinuousTimer(parent, left, top, right, centerY);
        continuousTimer.setup();

        bar = new ProgressBar(parent, left, centerY, right, bottom, NUM_ENDS);
        bar.setup();
    }

    public void draw() {
        continuousTimer.draw(timerSeconds);
        timerSeconds--;
        bar.draw(PApplet.map((duration - progressBarSeconds), 0, duration, 0, 100));
        progressBarSeconds--;
    }

    @Override
    public void setTime(int seconds) {
        duration = seconds;
        progressBarSeconds = duration;
        timerSeconds = progressBarSeconds * (NUM_ENDS - 2) / NUM_ENDS;
    }
}
