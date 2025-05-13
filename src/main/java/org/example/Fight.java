package org.example;
import java.util.Random;
public class Fight implements Action {
    private Door door;
    private Dungeon dungeon;
    private Random random;
    public Fight(Door door, Dungeon dungeon) {
        this.door = door;
        this.dungeon = dungeon;
        this.random = new Random();
    }
    @Override
    public void execute() {
        Monster monster = door.getGuard();
        Character player = dungeon.getPlayer();
        int playerStrength;
        if (player.getStrength() > 0) {
            playerStrength = player.getStrength();
        } else {
            playerStrength = player.getCraft();
        }
        if (player.leftHand != null) {
            playerStrength += player.leftHand.getStrengthBonus();
            playerStrength += player.leftHand.getCraftBonus();
        }
        if (player.rightHand != null) {
            playerStrength += player.rightHand.getStrengthBonus();
            playerStrength += player.rightHand.getCraftBonus();
        }
        int attackScore = random.nextInt(6) + 1 + playerStrength;
        int monsterStrength;
        if (monster.getStrength() > 0) {
            monsterStrength = monster.getStrength();
        } else {
            monsterStrength = monster.getCraft();
        }
        int monsterAttackScore = random.nextInt(6) + 1 + monsterStrength;

        int result = attackScore - monsterAttackScore;

        if (result > 0) {
            int newHealth = monster.getHealth() - result;
            monster.setHealth(newHealth);
            if (newHealth <= 0) {
                door.removeGuard();
            }
        } else {
            int newHealth = player.getHealth() + result;
            player.setHealth(newHealth);
        }
    }
    @Override
    public String toString() {
        Monster guard = door.getGuard();
        if (guard != null) {
            return "Fight " + guard.getName();
        }
        return "Fight";
    }
}