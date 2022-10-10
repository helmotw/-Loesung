package org.htw.prog2.tutorium.aufgabe1;

import org.htw.prog2.tutorium.aufgabe1.Components.FieldHandler;

public class Game {
    public static void main(String[] args) {
        int stamina = 5;
        FieldHandler treasure_seeker = new FieldHandler(3);
        treasure_seeker.init();
        System.out.println("You find yourself in dark a dungeon!");
        treasure_seeker.draw_field();
        while ((!treasure_seeker.treasure_found()) && (stamina > 0)) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String event=treasure_seeker.move_adventurer();
            System.out.println(event);
            treasure_seeker.draw_field();

            stamina--;
        }
        if(treasure_seeker.treasure_found()){
            System.out.println("You found a treasure!");
        }else {
            System.out.println("You collapse on the ground!");
        }
    }
}
