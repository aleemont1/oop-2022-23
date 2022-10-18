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
        if (!battery.isConnectedTo(robot)) {
            System.out.println("Battery not connected");
        } else {
            battery.turnOn();
            if (!battery.isOn()) {
                System.out.println("Battery not turned on");
            }
        }
        robot.connectPart(borderNav);
        if (!borderNav.isConnectedTo(robot)) {
            System.out.println("BorderNav not connected");
        } else {
            borderNav.turnOn();
            if (!borderNav.isOn()) {
                System.out.println("BorderNav not turned on");
            }
        }
        robot.connectPart(leftArm);
        if (!leftArm.isConnectedTo(robot)) {
            System.out.println("LeftArm not connected");
        } else {
            leftArm.turnOn();
            if (!leftArm.isOn()) {
                System.out.println("LeftArm not turned on");
            }
        }
        robot.connectPart(rightArm);
        if (!rightArm.isConnectedTo(robot)) {
            System.out.println("RightArm not connected");
        } else {
            rightArm.turnOn();
            if (!rightArm.isOn()) {
                System.out.println("RightArm not turned on");
            }
        }

        for (int i = 0; i < CYCLES; i++) {
            if (robot.getBatteryLevel() < BaseRobot.BATTERY_FULL / 2) {
                battery.turnOn();
            } else {
                battery.turnOff();
            }
            for (int j = 0; j < CYCLES; j++) {
                leftArm.sendCommand(leftArm.getCommands()[j % leftArm.getCommands().length]);
                rightArm.sendCommand(rightArm.getCommands()[j % rightArm.getCommands().length]);
            }
            robot.doCycle();
        }
    }
}
