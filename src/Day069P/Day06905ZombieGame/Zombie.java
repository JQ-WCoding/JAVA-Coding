package Day069P.Day06905ZombieGame;

public class Zombie extends Unit {
    private int power;

    public Zombie() {
    }

    public Zombie(int position, int hp, int max) {
        super(position, hp, max);
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public void attack(Unit hero) {
        power = random.nextInt(getMax()) + 1;

        hero.setHp(hero.getHp() - power);
        if (hero.getHp() <= 0) {
            hero.setHp(0);
        }

        setHp(getHp() + power / 2);

        System.out.println("[좀비]가 " + power + "의 공격력으로 공격");
        System.out.println("현재 Hero hp : " + hero.getHp() + ", 좀비 체력 회복 : " + getHp());
    }
}
