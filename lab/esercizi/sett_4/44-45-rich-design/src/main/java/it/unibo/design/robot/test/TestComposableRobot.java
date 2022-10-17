package it.unibo.design.robot.test;

import it.unibo.design.robot.components.api.ComposableRobot;
import it.unibo.design.robot.components.api.RobotPart;
import it.unibo.design.robot.components.impl.AtomicBattery;
import it.unibo.design.robot.components.impl.BorderNav;
import it.unibo.design.robot.components.impl.PartCollection;
import it.unibo.design.robot.components.impl.RobotArm;
import it.unibo.design.robot.impl.SimpleComposableRobot;

/**
 * Utility class for testing composable robots
 */
public final class TestComposableRobot {

    private static final int CYCLES = 200;

    private TestComposableRobot() {
    }

    public static void main(final String[] args) {
        final PartCollection parts = new PartCollection(PartCollection.DEFAULT_SIZE);
        final ComposableRobot robot = new SimpleComposableRobot("r2d2");
        final RobotPart battery = new AtomicBattery();
        final RobotPart borderNav = new BorderNav();
        final RobotPart leftArm = new RobotArm("LeftArm");
        final RobotPart RightArm = new RobotArm("RightArm");
        parts.connectPart(battery);
        parts.connectPart(borderNav);
        parts.connectPart(leftArm);
        parts.connectPart(RightArm);

        for (int i = 0; i < parts.getNumberOfParts(); i++) {
            robot.connectPart(parts.getPart(i));
            if (parts.getPart(i).isConnectedTo(robot)) {
                System.out.println(parts.getPart(i) + " Connected to " + robot);
            } else {
                System.out.println(parts.getPart(i) + " didn't connect to" + robot);
            }
        }

        for (int i = 0; i < CYCLES; i++) {
            parts.getPart(i % parts.getNumberOfParts()).turnOn();
            if (parts.getPart(i).isOn()) {
                System.out.println("[" + robot + "]" + parts.getPart(i) + "turnedOn");
            } else {
                System.out.println("[ERROR], " + parts.getPart(i) + " turnOn() check is false");
            }
            if (parts.getPart(i % parts.getNumberOfParts()).activate()) {
                System.out.println("[" + robot + "]" + parts.getPart(i) + " Correctly activated");
            } else {
                System.out.println("[ERROR], " + parts.getPart(i) + ": activate() returned false");
            }
            parts.getPart(i % parts.getNumberOfParts()).turnOff();
            if (!parts.getPart(i).isOn()) {
                System.out.println("[" + robot + "] " + parts.getPart(i) + " turnedOff");
            } else {
                System.out.println("[ERROR], " + parts.getPart(i) + ": turnOff() check is false");
            }
        }
        for (int i = 0; i < parts.getNumberOfParts(); i++) {
            parts.disconnect(parts.getPart(i));
            if (!parts.getPart(i).isConnectedTo(robot)) {
            System.out.println(parts.getPart(i) + "Correctly disconnected from " + robot);
            } else {
                System.out.println("[ERROR]" + parts.getPart(i) + "didn't disconnected from " + robot);
            }
        }
    }
}
