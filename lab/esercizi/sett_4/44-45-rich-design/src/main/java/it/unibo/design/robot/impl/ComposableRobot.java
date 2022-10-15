package it.unibo.design.robot.impl;

public class ComposableRobot extends RobotWithTwoArms {
    
    private final BasicArm leftArm;
    private final BasicArm rightArm;

    public ComposableRobot(final String name) {
        super(name);
        leftArm = new BasicArm("Left Arm");
        rightArm = new BasicArm("Right Arm");
    }
}
