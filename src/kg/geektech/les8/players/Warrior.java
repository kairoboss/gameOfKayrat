package kg.geektech.les8.players;

import java.util.Random;

public class Warrior extends Hero {
    public Warrior(int health, int damage, String name) {
        super(health, damage, SuperAbility.CRITICAL_DAMAGE, name);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        int min = 2;
        int max = 5;
        Random random = new Random();
        int randomCrit = random.nextInt(max - min)+min;
        setDamage(getDamage() * randomCrit);


    }
}
