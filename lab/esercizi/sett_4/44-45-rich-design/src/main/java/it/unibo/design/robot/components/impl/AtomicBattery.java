package it.unibo.design.robot.components.impl;

public class AtomicBattery extends AbstractPart {

    public AtomicBattery() {
        super("Atomic Battery", 0);
    }

    public String toString() {
        return "Atomic Battery";
    }

    @Override
    public boolean activate() {
        if(isOn() && isConnected()) {
            getRobot().recharge();
            System.out.println(this + " charged the battery to" + getRobot().getBatteryLevel());
            return true;
        }
        return true;
    }
}
