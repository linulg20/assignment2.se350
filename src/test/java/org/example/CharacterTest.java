package org.example;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
public class CharacterTest {
    /**
     * Tests if a new Wizard has craft points but no strength.
     */
    @Test
    public void wizardCraftOnly() {
        Wizard w = new Wizard("Wizard");
        assertEquals(0, w.getStrength(), "Wizard initally should have 0 strength");
        assertEquals(5, w.getCraft(), "Wizard initally should have craft = 5");
        assertEquals(10, w.getHealth(), "Wizard initally should have health = 10");
    }
    /**
     * Tests if a new Warrior has strength points but no craft.
     */
    @Test
    public void warriorStrengthOnly() {
        Warrior w = new Warrior("Warrior");
        assertEquals(5, w.getStrength(), "Warrior initally should have strength = 5");
        assertEquals(0, w.getCraft(), "Warrior initally should have 0 craft");
        assertEquals(10, w.getHealth(), "Warrior initally should have health = 10");
    }
}
