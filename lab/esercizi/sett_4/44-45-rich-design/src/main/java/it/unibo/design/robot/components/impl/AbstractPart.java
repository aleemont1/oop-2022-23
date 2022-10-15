package it.unibo.design.robot.components.impl;


import it.unibo.design.robot.api.Robot;
import it.unibo.design.robot.impl.ComposableRobot;
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

    public boolean isOn() {
        return isOn;
    }

    public boolean isConnected() {
        return robot != null;
    }

    public boolean isConnectedTo(final Robot r) {
        return isConnected() && robot.equals(r);
    }

    public String getName() {
        return desc;
    }

    protected final ComposableRobot getRobot() {
        return robot;
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
}