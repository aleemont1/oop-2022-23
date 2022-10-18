package it.unibo.design.robot.test;

import it.unibo.design.robot.components.api.ComposableRobot;
import it.unibo.design.robot.components.api.RobotPart;
import it.unibo.design.robot.components.impl.AtomicBattery;
import it.unibo.design.robot.components.impl.BorderNav;
import it.unibo.design.robot.components.impl.PartCollection;
import it.unibo.design.robot.components.impl.RobotArm;
import it.unibo.design.robot.impl.BaseRobot;
import it.unibo.design.robot.impl.SimpleComposableRobot;

/**
 * Utility class for testing composable robots
 */
public final class TestComposableRobot {

    private static final int CYCLES = 200;

    private TestComposableRobot() {
    }

    public static void main(final String[] args) {
        final ComposableRobot robot = new SimpleComposableRobot("r2d2");
        final RobotPart battery = new AtomicBattery();
        final RobotPart borderNav = new BorderNav();
        final RobotArm leftArm = new RobotArm("LeftArm");
        final RobotArm rightArm = new RobotArm("RightArm");

        robot.connectPart(battery);
            if(!battery.isConnectedTo(robot)) {
                System.out.println("Battery not connected");
            }
        robot.connectPart(borderNav);
            if(!borderNav.isConnectedTo(robot)) {
                System.out.println("BorderNav not connected");
            }
        robot.connectPart(leftArm);
            if(!leftArm.isConnectedTo(robot)) {
                System.out.println("LeftArm not connected");
            }
        robot.connectPart(rightArm);
            if(!rightArm.isConnectedTo(robot)) {
                System.out.println("RightArm not connected");
            }

        for (int i = 0; i < CYCLES; i++) {
            if (robot.getBatteryLevel() < BaseRobot.BATTERY_FULL / 2) {
                battery.turnOn();
            } else {
            battery.turnOff();
            }
            leftArm.sendCommand(leftArm.getCommands()[i % leftArm.getCommands().length]);
            rightArm.sendCommand(rightArm.getCommands()[i % rightArm.getCommands().length]);
            robot.doCycle();
        }
    }
}
