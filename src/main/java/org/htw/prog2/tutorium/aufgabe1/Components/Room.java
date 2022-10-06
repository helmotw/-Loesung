package org.htw.prog2.tutorium.aufgabe1.Components;

public class Room {
    private boolean has_player;
    private boolean has_goal;

    public Room() {
        has_player = false;
        has_goal = false;
    }

    public boolean isHas_player() {
        return has_player;
    }

    public void setHas_player(boolean has_player) {
        this.has_player = has_player;
    }

    public boolean isHas_goal() {
        return has_goal;
    }

    public void setHas_goal(boolean has_goal) {
        this.has_goal = has_goal;
    }


}
