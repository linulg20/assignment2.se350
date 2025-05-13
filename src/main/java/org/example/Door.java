package org.example;
public class Door {
    private Chamber entrance;
    private Chamber exit;
    private Monster guard;
    public Door(Chamber entrance, Chamber exit, Monster guard) {
        this.entrance = entrance;
        this.exit = exit;
        this.guard = guard;
        entrance.addDoor(this);
        exit.addDoor(this);
    }
    public static void connect(Chamber entrance, Chamber exit) {
        new Door(entrance, exit, null);
    }
    public static void connect(Chamber entrance, Chamber exit, Monster guard) {
        new Door(entrance, exit, guard);
    }
    public Chamber getEntrance() {
        return entrance;
    }
    public Chamber getExit() {
        return exit;
    }
    public Monster getGuard() {
        return guard;
    }
    public void removeGuard() {
        guard = null;
    }
}