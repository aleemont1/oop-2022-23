package it.unibo.design.robot.components.api;

import it.unibo.design.robot.api.Robot;

public interface ComposableRobot extends Robot {
    
    void connectPart(RobotPart p);
    void disconnectPart(RobotPart p);
    void doCycle();
    void sendCommand(String command);
    String availableCommands();
    
}
