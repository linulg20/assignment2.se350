package org.example;
public class Pick implements Action {
    private Item item;
    private Dungeon dungeon;
    public Pick(Item item, Dungeon dungeon) {
        this.item = item;
        this.dungeon = dungeon;
    }
    public void execute() {
        dungeon.pick(item);
    }
    public String toString() {
        return "Take the " + item.getName();
    }
}

