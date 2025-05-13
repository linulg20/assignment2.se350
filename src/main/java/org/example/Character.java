package org.example;
import java.util.ArrayList;
import java.util.List;
public abstract class Character {
    protected String name;
    protected int strength;
    protected int craft;
    protected int health;
    protected List<Item> inventory;
    protected Item leftHand;
    protected Item rightHand;
    public Character(String name, int strength, int craft, int health) {
        this.name = name;
        this.strength = strength;
        this.craft = craft;
        this.health = health;
        this.inventory = new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public int getStrength() {
        return strength;
    }
    public int getCraft() {
        return craft;
    }
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public List<Action> getActions(Dungeon dungeon) {
        List<Action> actions = new ArrayList<>();
        Chamber current = dungeon.getCurrentChamber();
        for (int i = 0; i < current.getItems().size(); i++) {
            Item item = current.getItems().get(i);
            actions.add(new Pick(item, dungeon));
        }
        for (int i = 0; i < current.getDoors().size(); i++) {
            Door door = current.getDoors().get(i);
            Monster guard = door.getGuard();
            if (guard != null && guard.getHealth() > 0) {
                actions.add(new Fight(door, dungeon));
            } else {
                actions.add(new Move(door, dungeon));
            }
        }
        return actions;
    }
}
