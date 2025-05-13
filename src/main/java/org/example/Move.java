package org.example;
public class Move implements Action {
    private Door door;
    private Dungeon dungeon;
    public Move(Door door, Dungeon dungeon) {
        this.door = door;
        this.dungeon = dungeon;
    }
    public void execute() {
        dungeon.move(door);
    }
    public String toString() {
        return "enter through the door";
    }
}

