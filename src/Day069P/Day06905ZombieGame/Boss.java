package Day069P.Day06905ZombieGame;

public class Boss extends Zombie {
    private int shield;

    public Boss() {
    }

    public Boss(int position, int hp, int max, int shield) {
        super(position, hp, max);
        this.shield = shield;
    }

    public int getShield() {
        return shield;
    }

    public void setShield(int shield) {
        this.shield = shield;
    }

    @Override
    public void attack(Unit hero) {
        int rNum = random.nextInt(4) + 1;

        if (rNum == 1) {
            System.out.println("[보스]의 필살기 발동 : 2배의 공격력");

            int power = 2 * (random.nextInt(getMax()) + 1);
            hero.setHp(hero.getHp() - power);
            if (hero.getHp() <= 0) {
                hero.setHp(0);
            }
            System.out.println("[보스]가 " + power + "의 공격력으로 공격");
            System.out.println("현재 Hero hp : " + hero.getHp());
        } else {
            System.out.println("[보스]의 일반공격");
            int power = random.nextInt(getMax()) + 1;
            hero.setHp(hero.getHp() - power);
            if (hero.getHp() <= 0) {
                hero.setHp(0);
            }
            System.out.println("[보스]가 " + power + "의 공격력으로 공격");
            System.out.println("현재 Hero hp : " + hero.getHp());
        }
    }
}
