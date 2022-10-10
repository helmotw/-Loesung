package org.htw.prog2.tutorium.aufgabe1.Components;


import java.util.Random;

public class FieldHandler {
    private static Random rand = new Random();
    private final char[] directions = {'n', 's', 'w', 'e'};
    private Room[][] room_matrix;
    private int dimensions;
    private Player adventurer;
    private Goal treasure;

    public FieldHandler(int dimensions) {
        this.dimensions = dimensions;
        room_matrix = new Room[dimensions][dimensions];
        adventurer = new Player(rand.nextInt(dimensions), rand.nextInt(dimensions));
        treasure = new Goal(rand.nextInt(dimensions), rand.nextInt(dimensions));
    }

    public void init() {
        Room[][] init_rooms = getRoom_matrix();

        for (int i = 0; i < dimensions; i++) {
            for (int j = 0; j < dimensions; j++) {
                init_rooms[i][j] = new Room();
            }
        }

        init_rooms[adventurer.getXposition()][adventurer.getYposition()].setHas_player(true);
        init_rooms[treasure.getXposition()][treasure.getYposition()].setHas_goal(true);

    }

    public Room[][] getRoom_matrix() {
        return room_matrix;
    }


    public void draw_field() {
        draw_horizontal_wall();
        for (int y = 0; y < dimensions; y++) {
            System.out.print("|");
            for (int x = 0; x < dimensions; x++) {
                if (getRoom_matrix()[x][y].isHas_player()) {
                    System.out.print(adventurer.getIcon());
                } else {
                    System.out.print("     ");
                }
                System.out.print(" ");
                if (getRoom_matrix()[x][y].isHas_goal()) {
                    System.out.print(treasure.getIcon());
                } else {
                    System.out.print("  ");
                }
                System.out.print("|");
            }
            System.out.println();
            draw_horizontal_wall();
        }
    }


    public void draw_horizontal_wall() {
        System.out.print("_");
        for (int i = 0; i < dimensions; i++) {
            for (int j = 0; j < adventurer.getIcon().length() + treasure.getIcon().length() + 1; j++) {

                System.out.print("_");
            }
            System.out.print("_");
        }
        System.out.println();
    }

    public String move_adventurer() {
        char direction = directions[rand.nextInt(4)];
        room_matrix[adventurer.getXposition()][adventurer.getYposition()].setHas_player(false);
        String event = "You head";
        String thrownbackwards=" and hit your forehead against a wall.\nThe force sends you flying backwards!";
        switch (direction) {
            case 's':
                event+=" south";
                if (adventurer.getYposition() == dimensions - 1) {
                    adventurer.setYposition(adventurer.getYposition() - 1);
                    event+=thrownbackwards;
                } else {
                    adventurer.setYposition(adventurer.getYposition() + 1);
                }
                break;
            case 'n':
                event+=" north";
                if (adventurer.getYposition() == 0) {
                    adventurer.setYposition(adventurer.getYposition() + 1);
                    event+=thrownbackwards;
                } else {
                    adventurer.setYposition(adventurer.getYposition() - 1);
                }
                break;
            case 'e':
                event+=" east";
                if (adventurer.getXposition() == dimensions - 1) {
                    adventurer.setXposition(adventurer.getXposition() - 1);
                    event+=thrownbackwards;
                } else {
                    adventurer.setXposition(adventurer.getXposition() + 1);
                }
                break;
            case 'w':
                event+=" west";
                if (adventurer.getXposition() == 0) {
                    adventurer.setXposition(adventurer.getXposition() + 1);
                    event+=thrownbackwards;
                } else {
                    adventurer.setXposition(adventurer.getXposition() - 1);
                }
                break;
        }
        room_matrix[adventurer.getXposition()][adventurer.getYposition()].setHas_player(true);
        return event;
    }


    public boolean treasure_found() {
        Room treasure_room = room_matrix[treasure.getXposition()][treasure.getYposition()];
        return treasure_room.isHas_player() && treasure_room.isHas_goal();
    }
}
