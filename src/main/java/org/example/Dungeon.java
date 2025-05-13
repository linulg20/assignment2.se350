package org.example;
import java.util.List;
public class Dungeon {
    private Character player;
    private Chamber startChamber;
    private Chamber goalChamber;
    private Chamber currentChamber;
    public Dungeon(Character player, Chamber startChamber, Chamber goalChamber) {
        this.player = player;
        this.startChamber = startChamber;
        this.goalChamber = goalChamber;
        this.currentChamber = startChamber;
    }
    public Chamber getCurrentChamber() {
        return currentChamber;
    }
    public boolean isFinished() {
        return currentChamber == goalChamber || player.getHealth() <= 0;
    }
    public List<Action> getActions() {
        return player.getActions(this);
    }
    public void move(Door door) {
        Monster guard = door.getGuard();
        if (guard != null && guard.getHealth() > 0) {
            System.out.println("The door is guarded!");
            return;
        }
        if (door.getEntrance() == currentChamber) {
            currentChamber = door.getExit();
        } else {
            currentChamber = door.getEntrance();
        }
    }
    public void pick(Item item) {
        player.inventory.add(item);
        currentChamber.removeItem(item);
        if (player.leftHand == null) {
            player.leftHand = item;
        } else if (player.rightHand == null) {
            player.rightHand = item;
        }
    }
    public Character getPlayer() {
        return player;
    }
}