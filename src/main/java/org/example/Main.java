package org.example;

public class Main {
    public static void main(String[] args) {
        Player player = new Player(10, 1, 1, 2, 5);
        Monster monster = new Monster(30, 6, 15, 6, 25);
      Fight fight = new Fight(player, monster);
      fight.attack();

    }
}