package org.example;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
public class TextUI {
    public void play(Dungeon d) {
        while (!d.isFinished()) {
            print(d);
            Action a = ask(d);
            a.execute();
        }
    }

    /** Print the current room of the dungeon. */
    private void print(Dungeon d) {
        Chamber r = d.getCurrentChamber();
        StringBuilder s = new StringBuilder();
        s.append("You are in a chamber with " + r.getDoors().size() + " doors\n");
        s.append("There are " + r.getItems().size() + " items in the chamber\n");
        // TODO: print for each door which monster is there, how strong it is,
        for (int i = 0; i < r.getDoors().size(); i++) {
            Door door = r.getDoors().get(i);
            Monster m = door.getGuard();
            if (m != null && m.getHealth() > 0) {
                s.append("Door " + i
                        + ": monster " + m.getName()
                        + " (strength=" + m.getStrength()
                        + ", craft="   + m.getCraft()
                        + ", health="  + m.getHealth()
                        + ")\n");
            } else {
                s.append("Door " + i + ": no guard\n");
            }
        }
        System.out.print(s.toString());
    }

    /** Asks the user for an action. */
    private Action ask(Dungeon d) {
        StringBuilder s = new StringBuilder();
        s.append("Here are your options:\n");
        List<Action> actions = d.getActions();
        for (int i = 0; i < actions.size(); i++) {
            s.append("\t" + i + ": " + actions.get(i).toString() + "\n");
        }
        System.out.print(s.toString());

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int command = Integer.parseInt(reader.readLine());
            // guard against bad index
            if (command < 0 || command >= actions.size()) {
                return new PrintError(d, null);
            }
            return actions.get(command);
        } catch (IOException | NumberFormatException e) {
            return new PrintError(d, e);
        }
    }
}
