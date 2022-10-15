package it.unibo.design.robot.components.api;

import it.unibo.design.robot.api.Robot;
import it.unibo.design.robot.impl.ComposableRobot;

public interface RobotPart {

    double getConsumption();
    boolean isOn();
    boolean isConnected();
    boolean isConnectedTo(Robot r);
    boolean activate();
    String getName();

    void connect(ComposableRobot r);
    void disconnect();
    void turnOn();
    void turnOff();
}
