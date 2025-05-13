package org.example;
import java.util.ArrayList;
import java.util.List;
public class Chamber {
    private List<Door> doors;
    private List<Item> items;
    public Chamber() {
        doors = new ArrayList<>();
        items = new ArrayList<>();
    }
    public Chamber(Item item) {
        this();
        items.add(item);
    }
    public Chamber(Item item1, Item item2) {
        this();
        items.add(item1);
        items.add(item2);
    }
    public List<Door> getDoors() {
        return doors;
    }
    public List<Item> getItems() {
        return items;
    }
    public void addDoor(Door door) {
        doors.add(door);
    }
    public void removeItem(Item item) {
        items.remove(item);
    }
}