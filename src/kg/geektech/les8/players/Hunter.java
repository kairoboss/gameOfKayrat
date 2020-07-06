package kg.geektech.les8.players;

import java.util.Random;

public class Hunter extends Hero {
    public Hunter(int health, int damage, String name) {
        super(health, damage, SuperAbility.SAVE_DAMAGE_AND_REVERT, name);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        Random random = new Random();
        int revertDamage = random.nextInt(12);
        setDamage(getDamage() + boss.getDamage() / revertDamage);
    }
}
