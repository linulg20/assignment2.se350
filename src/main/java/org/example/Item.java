package org.example;
public abstract class Item {
    private String itemName;
    private int strengthBonus;
    private int craftBonus;
    public Item(String itemType, int bonusStrength, int bonusCraft) {
        this.itemName = itemType;
        this.strengthBonus = bonusStrength;
        this.craftBonus = bonusCraft;
    }
    public String getName() {
        return itemName;
    }
    public int getStrengthBonus() {
        return strengthBonus;
    }
    public int getCraftBonus() {
        return craftBonus;
    }
    @Override
    public String toString() {
        return itemName;
    }
}