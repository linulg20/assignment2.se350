package org.example;
public class PrintError implements Action {
    private final Dungeon dungeon;
    private final Exception error;
    public PrintError(Dungeon dungeon, Exception cause) {
        this.dungeon = dungeon;
        this.error = cause;
    }
    @Override
    public void execute() {
    }
    @Override
    public String toString() {
        if (error == null) {
            return "Invalid instruction ";
        } else {
            return "Invalid instruction (" + error.getClass().getSimpleName() + ")";
        }
    }
}