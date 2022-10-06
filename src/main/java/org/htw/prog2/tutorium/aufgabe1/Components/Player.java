package org.htw.prog2.tutorium.aufgabe1.Components;

public class Player {
    private String icon;
    private int xposition, yposition;

    public Player(int x, int y) {
        icon = "(^_^)";
        xposition = x;
        yposition = y;
    }

    public int getXposition() {
        return xposition;
    }

    public int getYposition() {
        return yposition;
    }

    public String getIcon() {
        return icon;
    }


    public void setXposition(int xposition) {
        this.xposition = xposition;
    }

    public void setYposition(int yposition) {
        this.yposition = yposition;
    }


}
