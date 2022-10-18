package it.unibo.design.robot.impl;

import java.lang.reflect.Array;

import it.unibo.design.robot.components.api.ComposableRobot;
import it.unibo.design.robot.components.api.RobotPart;
import it.unibo.design.robot.components.api.RobotPartCollection;
import it.unibo.design.robot.components.impl.PartCollection;
import it.unibo.design.robot.impl.BaseRobot;

public class SimpleComposableRobot extends BaseRobot implements ComposableRobot {
    
    private final RobotPartCollection parts = new PartCollection(1);

    public SimpleComposableRobot(final String name) {
        super(name);
    }

    public final void connectPart(final RobotPart p) {
        if(p != null && !p.isConnectedTo(this)) {
            parts.connectPart(p);
            p.connect(this);
        }
    }

    public final void disconnectPart(final RobotPart p) {
        if(p != null) {
            parts.disconnect(p);
        }
    }

    public final void doCycle() {
        parts.resetIterator();
        while(parts.hasNext()) {
            final RobotPart p = parts.next();
            if(p.isOn()) {
                if (p.isConnectedTo(this)) {
                    if(p.getConsumption() < getBatteryLevel() && p.activate()) {
                        consumeBattery(p.getConsumption());
                        log("Activated and working " + p.getName());
                    } else {
                        p.turnOff();
                        log("Activated but not working " + p.getName());
                    }
                    
                } else {
                    log("Not connected " + p.getName());
                }
            } else {
                log("Didn't turn on " + p.getName());
            }
        }
    }
}
