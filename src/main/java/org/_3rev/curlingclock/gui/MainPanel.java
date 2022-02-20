package org._3rev.curlingclock.gui;

import org._3rev.curlingclock.controller.Controller;
import org._3rev.curlingclock.gui.clock.ClockPanel;
import org._3rev.curlingclock.gui.endmode.EndTimerPanel;
import org._3rev.curlingclock.gui.timer.TimerPanel;
import org.springframework.stereotype.Component;
import processing.core.PApplet;

import static org._3rev.curlingclock.gui.MainPanelMode.CLOCK;

@Component
public class MainPanel extends PApplet {

    public static Controller controller = new Controller();
    private EndTimerPanel endTimerPanel;
    private ClockPanel clockPanel;
    private TimerPanel timerPanel;

    private MainPanelMode activeMode = CLOCK;

    public void settings() {
//        size(800, 600);
        fullScreen();
        noCursor();
        controller.setClock(this);
    }

    public void setup() {
        frameRate(1);
        endTimerPanel = new EndTimerPanel(this);
        endTimerPanel.setup();

        clockPanel = new ClockPanel(this);
        clockPanel.setup();

        timerPanel = new TimerPanel(this);
        timerPanel.setup();
    }

    public void draw() {
        background(0);

        boolean switchToClock = false;

        switch (activeMode) {
            case ENDTIMER:
                switchToClock = endTimerPanel.draw();
                break;
            case TIMER:
                switchToClock = timerPanel.draw();
                break;
            default:
                clockPanel.draw();
                break;
        }

        if (switchToClock && activeMode != CLOCK) {
            activeMode = CLOCK;
        }
    }

    public void continuousEnd(int totalSeconds) {
        activeMode = MainPanelMode.ENDTIMER;
        endTimerPanel.continuousMode(totalSeconds);
    }

    public void finalEnd(int totalSeconds) {
        activeMode = MainPanelMode.ENDTIMER;
        endTimerPanel.finalMode(totalSeconds);
    }

    public void clock() {
        activeMode = CLOCK;
    }

    public void timer(int totalSeconds) {
        activeMode = MainPanelMode.TIMER;
        timerPanel.setTime(totalSeconds);
    }
}
