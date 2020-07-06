package kg.geektech.les8.game;

import kg.geektech.les8.players.*;

public class RPG_game {
    public static void start() {
        Boss boss = new Boss(10000, 50);
        Warrior warrior = new Warrior(250, 15, "Warrior");
        Magic magic = new Magic(250, 15, "Alladin");
        Medic medic = new Medic(230, 10, 20, "Doctor");
        Medic youngMedic = new Medic(260, 15, 5, "MedAssistant");
        Hunter hunter = new Hunter(270, 25, "Hunter");
        Hero[] heroes = {warrior, magic, medic, youngMedic, hunter};
        while (!isGameFinished(boss, heroes)) {
            round(boss, heroes);
        }
    }

    private static void round(Boss boss, Hero[] heroes) {
        if (boss.getHealth() > 0) {
            bossHit(boss, heroes);
            heroesHit(boss, heroes);
            heroesApplySuperAbilities(boss, heroes);

        }
        printStats(boss, heroes);
    }

    private static void bossHit(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
            }
        }
    }

    private static void heroesHit(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth()>0) {
                boss.setHealth(boss.getHealth() - heroes[i].getDamage());
            }
        }
    }

    private static void heroesApplySuperAbilities(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                heroes[i].applySuperAbility(boss, heroes);
            }
        }
    }

    private static void printStats(Boss boss, Hero[] heroes) {

        System.out.println("-------------------------");
        System.out.println("--------BOSS STATS-------");
        System.out.println("Boss : health" + boss.getHealth()+ " " + "Damage="+boss.getDamage());
        System.out.println("------HEROES STATS-------");
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i].getName() + " : " + "health=" + heroes[i].getHealth()+ " "+"Damage="+heroes[i].getDamage());
        }
        System.out.println("-------------------------");

    }

    private static boolean isGameFinished(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("VICTORY!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }

        }
        if (allHeroesDead) {
            System.out.println("GAME OVER!!!");
        }
        return allHeroesDead;

    }


        }

