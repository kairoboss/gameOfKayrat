package kg.geektech.les8.players;

public class Medic extends Hero {
    private int healPoints;

    public int getHealPoints() {
        return healPoints;
    }

    public void setHealPoints(int healPoints) {
        this.healPoints = healPoints;
    }

    public Medic(int health, int damage, int healPoints, String name) {
        super(health, damage, SuperAbility.HEAL, name);
        this.healPoints = healPoints;
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length ; i++) {
            if (heroes[i].getSuperAbility() != SuperAbility.HEAL){
            heroes[i].setHealth(heroes[i].getHealth() + healPoints);}

        }
    }
}
