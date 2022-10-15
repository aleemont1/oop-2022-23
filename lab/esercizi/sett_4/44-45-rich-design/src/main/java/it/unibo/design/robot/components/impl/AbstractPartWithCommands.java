package it.unibo.design.robot.components.impl;

import java.util.Arrays;

public abstract class AbstractPartWithCommands extends AbstractPart {

    protected static final String NULL_CMD = "Command is null";

    private final String[] commands;
    private String selectedCommand = NULL_CMD;

    public AbstractPartWithCommands(final String desc, final double consumption, final String[] commands) {
        super(desc, consumption);
        this.commands = Arrays.copyOf(commands, commands.length);
    }

    public String[] getCommands() {
        return Arrays.copyOf(commands, commands.length);
    }

    public boolean doOperation() {
        if (super.isConnected() && super.isOn()) {
            return activate(selectedCommand);
        }
        return false;
    }

    protected abstract boolean activate(final String command);

    public void sendCommand(final String command) {
        for(final String selected : commands) {
            if (selected.equals(command)) {
                selectedCommand = selected;
                return;
            }
        }
    }
}
