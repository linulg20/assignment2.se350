package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ChamberTest {
    /**
     * Testing if the chamber has the items.
     */
    @Test
    public void testChamberHasItems() {
        Axe axe = new Axe();
        Shield shield = new Shield();
        Chamber chamber = new Chamber(axe, shield);
        assertTrue(chamber.getItems().contains(axe), "Chamber should have the axe");
        assertTrue(chamber.getItems().contains(shield), "Chamber should have the shield");
    }

    /**
     * Test if the item removal method takes out the wanted item from the chamber.
     */
    @Test
    public void testRemoveItem() {
        Axe axe = new Axe();
        Chamber chamber = new Chamber(axe);
        chamber.removeItem(axe); // takes out the axe
        assertFalse(chamber.getItems().contains(axe), "Chamber should not have the axe now");
    }

    /**
     * Tests if that connecting two chambers adds one door to each room
     * that they reference the same door.
     */
    @Test
    public void testAddsDoorsToTwoPaths() {
        Chamber chamber1 = new Chamber();
        Chamber chamber2 = new Chamber();
        Door.connect(chamber1, chamber2); // connects room1 and room2

        assertEquals(1, chamber1.getDoors().size(), "First chamber should have 1 door");
        assertEquals(1, chamber2.getDoors().size(), "Second chamber should have 1 door");

        Door door1 = chamber1.getDoors().get(0);
        Door door2 = chamber2.getDoors().get(0);
        assertSame(door1, door2, "Both rooms has the same door");
    }

    /**
     * Tests if the monster guard can be removed from a door.
     */
    @Test
    public void testMonsterRemoved() {
        Chamber chamber1 = new Chamber();
        Chamber chamber2 = new Chamber();
        Monster monster = new Monster("mob", 1, 0, 2);
        Door.connect(chamber1, chamber2, monster); // there is a mob

        Door door = chamber1.getDoors().get(0);
        assertSame(monster, door.getGuard(), "Guard is there when first encountered");
        door.removeGuard(); // guard is being removed
        assertNull(door.getGuard(), "No guard should be there after being removed");
    }
}