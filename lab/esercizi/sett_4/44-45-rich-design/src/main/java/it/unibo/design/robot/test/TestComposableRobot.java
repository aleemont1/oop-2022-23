package it.unibo.design.robot.test;

import it.unibo.design.robot.components.api.RobotPart;
import it.unibo.design.robot.components.api.RobotPartCollection;
import it.unibo.design.robot.components.impl.PartCollection;
import it.unibo.design.robot.components.*;
/**
 * Utility class for testing composable robots
 */
public final class TestComposableRobot {

    private static final int CYCLES = 200;

    private TestComposableRobot() { }

    public static void main(final String[] args) {
        /*
         Uncomment the method parts by moving the comment-ending token */
        final ComposableRobot r0 = new SimpleComposableRobot("Evangelion Unit 01");
        final RobotPart navi = new BorderNavigator();
        final RobotPart battery = new AtomicBattery();
        final RobotArm arm1 = new RobotArm();
        final RobotArm arm2 = new RobotArm();
        
        /*
          Component connection*/
        r0.connectPart(navi);
        r0.connectPart(battery);
        r0.connectPart(arm1);
        r0.connectPart(arm2);
         
        /*
         Turn on components*/
        navi.turnOn();
        arm1.turnOn();
        arm2.turnOn();
        
        /*
         Run some cycles*/
        for (int i = 0; i < CYCLES; i++) {
            if (r0.getBatteryLevel() < BaseRobot.BATTERY_FULL / 2) {
                battery.turnOn();
            } else {
                battery.turnOff();
            }
            arm1.sendCommand(arm1.getCommands()[i % arm1.getCommands().length]);
            arm2.sendCommand(arm2.getCommands()[i % arm2.getCommands().length]);
            r0.doCycle();
        }
         
        /*
         Detach components */
        r0.detachComponent(arm1);
        r0.detachComponent(arm2);
        /*
         * Test if it runs anyway */
        r0.doCycle();
        r0.doCycle();
    }
}
