package kg.geektech.les8.players;

import java.util.Random;

public class Thor extends Hero {

    public Thor(int health, int damage, SuperAbility superAbility, String name) {
        super(health, damage, SuperAbility.STUN, name);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        Random random = new Random();
        int stunChance = random.nextInt(10);
        if(stunChance == 1){
            boss.setDamage(0);

        }
    }
}
