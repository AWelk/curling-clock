package org._3rev.curlingclock.controller;

import org._3rev.curlingclock.gui.MainPanel;

public class Controller {

    private MainPanel clock;

    public void setClock(MainPanel clock) {
        this.clock = clock;
    }

    public void continuousEnd(int totalSeconds) {
        clock.continuousEnd(totalSeconds);
    }

    public void finalEnd(int totalSeconds) {
        clock.finalEnd(totalSeconds);
    }

    public void clock() {
        clock.clock();
    }

    public void timer(int totalSeconds) {
        clock.timer(totalSeconds);
    }
}

