package org._3rev.curlingclock.config;

import org._3rev.curlingclock.controller.Controller;
import org._3rev.curlingclock.gui.MainPanel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public Controller getController() {
        return MainPanel.controller;
    }
}
