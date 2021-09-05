package org._3rev.curlingclock;

import org._3rev.curlingclock.gui.MainPanel;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import processing.core.PApplet;

@SpringBootApplication
public class CurlingClockApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(CurlingClockApplication.class)
                .headless(false)
                .run(args);
        PApplet.main(MainPanel.class.getName());
    }

}
