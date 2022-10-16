package it.unibo.design.robot.components.api;

public interface RobotPartCollection {
    void connectPart(RobotPart p);
    void resetIterator();
    boolean hasNext();
    RobotPart next();
    void disconnect(RobotPart p);
}
