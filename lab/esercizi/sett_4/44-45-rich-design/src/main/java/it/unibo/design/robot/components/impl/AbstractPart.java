package it.unibo.design.robot.components.impl;

import it.unibo.design.robot.components.api.ComposableRobot;
import it.unibo.design.robot.api.Robot;
import it.unibo.design.robot.components.api.RobotPart;

public abstract class AbstractPart implements RobotPart {

    private final String desc;
    private final double consumption;
    private boolean isOn;
    private ComposableRobot robot;

    protected AbstractPart(final String desc, final double consumption) {
        this.desc = desc;
        this.consumption = consumption;
    }

    public double getConsumption() {
        return consumption;
    }

    public final boolean isOn() {
        return isOn;
    }

    public final boolean isConnected() {
        return robot != null;
    }

    @Override
    public boolean isConnectedTo(final ComposableRobot r) {
        return isConnected() && robot.equals(r);
    }

    public String getName() {
        return desc;
    }

    public final void connect(final ComposableRobot r) {
        disconnect();
        robot = r;
    }

    public final void disconnect() {
        turnOff();
        robot = null;
    }

    public final void turnOn() {
        isOn = true;
    }

    public final void turnOff() {
        isOn = false;
    }

    public abstract String toString();

    protected final ComposableRobot getRobot() {
        return robot;
    }
}