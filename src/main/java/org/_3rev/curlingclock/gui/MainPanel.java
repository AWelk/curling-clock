package org._3rev.curlingclock.gui;

import org._3rev.curlingclock.controller.Controller;
import org._3rev.curlingclock.gui.clock.ClockPanel;
import org._3rev.curlingclock.gui.endmode.EndTimerPanel;
import org._3rev.curlingclock.gui.timer.TimerPanel;
import org.springframework.stereotype.Component;
import processing.core.PApplet;

import java.time.LocalTime;
import java.util.Calendar;

import static org._3rev.curlingclock.gui.MainPanelMode.CLOCK;

@Component
public class MainPanel extends PApplet {

    public static Controller controller = new Controller();
    private EndTimerPanel endTimerPanel;
    private ClockPanel clockPanel;
    private TimerPanel timerPanel;
    private boolean forceLatch = false;

    private MainPanelMode activeMode = CLOCK;

    public void settings() {
//        size(800, 600);
        fullScreen();
        controller.setClock(this);
    }

    public void setup() {
        frameRate(1);
        noCursor();
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

        enforceTimerStarted();

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

    private void enforceTimerStarted() {
        boolean timeToForceTimer = isTimeToForceTimer();

        // if it's time to force the timer and the latch hasn't tripped, start the timer
        if (timeToForceTimer && !forceLatch) {
            forceLatch = true;
            continuousEnd(8450);
        }
        // if it's not time to enforce the timer, do nothing but make sure latch is released
        else if (!timeToForceTimer) {
            forceLatch = false;
        }
    }

    private boolean isTimeToForceTimer() {
        int day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);

        boolean timeToForceTimer = isMondayLeague(day) || isTuesdayOrThursdayLeague(day);

        return timeToForceTimer && activeMode == CLOCK;
    }

    private boolean isMondayLeague(int day) {
        return day == Calendar.MONDAY && LocalTime.now().isAfter(LocalTime.parse("19:35:00")) && LocalTime.now().isBefore(LocalTime.parse("19:35:05"));
    }

    private boolean isTuesdayOrThursdayLeague(int day) {
        return (day == Calendar.TUESDAY || day == Calendar.THURSDAY) && LocalTime.now().isAfter(LocalTime.parse("20:20:00")) && LocalTime.now().isBefore(LocalTime.parse("20:20:05"));
    }
}
