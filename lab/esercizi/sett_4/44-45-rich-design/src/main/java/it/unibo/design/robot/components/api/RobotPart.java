package it.unibo.design.robot.components.api;

public interface RobotPart {

    double getConsumption();
    boolean isOn();
    boolean isConnected();
    boolean isConnectedTo(it.unibo.design.robot.api.Robot r);
    boolean activate();
    String getName();

    void connect(ComposableRobot r);
    void disconnect();
    void turnOn();
    void turnOff();
}
