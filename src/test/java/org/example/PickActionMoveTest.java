package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PickActionMoveTest {
    /**
    // Testing if when an object is picked up, it is added
    // to the player's inventory, placed in the hand,
    // and removed from the chamber.
     */
    @Test
    public void itemIsAtHand() {
        Axe axe = new Axe();
        Chamber chamber = new Chamber(axe);
        Warrior warrior = new Warrior("TestWarrior");
        Dungeon dungeon = new Dungeon(warrior, chamber, chamber);
        Pick pickAction = new Pick(axe, dungeon);
        pickAction.execute();
        Character player = dungeon.getPlayer();
        assertTrue(player.inventory.contains(axe), "Inventory should contain the axe");
        assertEquals(axe, player.leftHand, "Left hand should hold the axe");
        assertFalse(chamber.getItems().contains(axe), "Chamber should no longer have the axe");
    }
    /**
    // Test that moving through a door changes the current chamber
    // to the connected chamber.
     */
    @Test
    public void moveActionShouldChangeCurrentChamber() {
        Chamber start = new Chamber();
        Chamber destination = new Chamber();
        Door.connect(start, destination);
        Warrior warrior = new Warrior("TestWarrior");
        Dungeon dungeon = new Dungeon(warrior, start, destination);
        Move moveAction = new Move(start.getDoors().get(0), dungeon);
        moveAction.execute();
        assertEquals(destination, dungeon.getCurrentChamber(), "Player should be in the destination chamber");
    }
}