package org.example;



public class Creature {
    private final int attack;
    private final int defense;
    private int health;

    private final int[] damage;
    private int minDamage;
    private final int maxDamage;

    public Creature(int attack, int defense, int health, int minDamage, int maxDamage) {
        this.attack = validateFieldValueBetween1And30(attack);
        this.defense = validateFieldValueBetween1And30(defense);
        this.health = validateFieldHealth(health);
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.damage = createDamage();
    }

    private int validateFieldValueBetween1And30(int value) {
        int num;
        if (!(value >= 1 && value <= 30)) {
            throw new IllegalArgumentException("The parameter must be between 1 and 30");
        } else {
            num = value;
        }
        return num;
    }

    private int validateFieldHealth(int value) {
        int num;
        if (value >= 0) {
            num = value;
        } else {
            throw new IllegalArgumentException("The parameter must be greater than or equal to 0");
        }
        return num;
    }


    private int[] createDamage() {
        int[] value;
        if (minDamage > 0 && maxDamage > minDamage) {
            value = new int[maxDamage - minDamage + 1];
            for (int i = 0; minDamage <= maxDamage; i++) {
                value[i] = minDamage;
                minDamage++;
            }
        } else {
            throw new IllegalArgumentException("the min Damage parameter is less than " +
                    "the maxDamage parameter and they are positive numbers");
        }
        return value;
    }


    public int getAttack() {
        return attack;
    }


    public int getDefense() {
        return defense;
    }


    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int[] getDamage() {
        return damage;
    }

}