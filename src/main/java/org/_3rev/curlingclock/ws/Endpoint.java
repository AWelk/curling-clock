package org._3rev.curlingclock.ws;

import org._3rev.curlingclock.controller.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Endpoint {

    private final Controller controller;

    public Endpoint(final Controller controller) {
        this.controller = controller;
    }

    @RequestMapping("/continuousEnd/{seconds}")
    public void continuousEnd(@PathVariable int seconds) {
        controller.continuousEnd(seconds);
    }

    @RequestMapping("/finalEnd/{seconds}")
    public void finalEnd(@PathVariable int seconds) {
        controller.finalEnd(seconds);
    }

    @RequestMapping("/timer/{seconds}")
    public void timer(@PathVariable int seconds) {
        controller.timer(seconds);
    }

    @RequestMapping("/clock")
    public void clock() {
        controller.clock();
    }
}
