package org.example;


import java.util.Random;

public class Fight {
    private final Creature creature;
    private final Creature creature1;
    private int count = 4;
    private int maxHealth;


    public Fight(Creature creature, Creature creature1) {
        this.creature = creature;
        this.creature1 = creature1;
        if (creature instanceof Player) maxHealth = creature.getHealth();
        else if (creature1 instanceof Player) maxHealth = creature1.getHealth();
    }

    public void attack() {
        while (true) {
            hit(creature, creature1);
            if(creature1.getHealth() <= 0) break;
            hit(creature1, creature);
            if(creature.getHealth() <= 0) break;
        }
    }


    private void hit(Creature stryker, Creature target) {
        int modifier = stryker.getAttack() - target.getDefense() + 1;
        int success = 0;
        Random random = new Random();
        for (int i = 0; i < modifier; i++) {
            int roll = random.nextInt(6) + 1;
            success += roll == 5 || roll == 6 ? 1 : 0;
            if (success == 1) {
                int randomDamage = stryker.getDamage()[random.nextInt(stryker.getDamage().length)];
                int result;
                if (target instanceof Player && count > 0) {
                    result = treatment(target.getHealth() - randomDamage);
                    count--;
                } else {
                    result = target.getHealth() - randomDamage;
                }
                target.setHealth(result);
                break;
            }
        }
    }

    private int treatment(int value) {
        int result;
        if (value < maxHealth - maxHealth / 3) {
            result = value + maxHealth / 3;
        } else {
            result = value;
        }
        return result;
    }
}
