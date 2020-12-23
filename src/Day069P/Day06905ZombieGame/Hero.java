package Day069P.Day06905ZombieGame;

public class Hero extends Unit {
    private int power;
    private int count;

    public Hero() {
    }

    public Hero(int position, int hp, int max, int count) {
        super(position, hp, max);
        this.count = count;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public void attack(Unit enemy) {
        if (enemy instanceof Boss) {
            Boss boss = (Boss) enemy;

            power = random.nextInt(getMax()) + 1;
            if (boss.getShield() > 0) {
                int shield = boss.getShield() - power;
                if (shield >= 0) {
                    boss.setShield(boss.getShield() - power);
                } else {
                    boss.setShield(0);
                    boss.setHp(boss.getHp() - shield);
                }
            } else {
                boss.setHp(boss.getHp() - power);
            }

            if (boss.getHp() <= 0) {
                boss.setHp(0);
            }
            System.out.println("[히어로]가 " + power + "의 공격력으로 공격");
            System.out.println("현재 Boss hp : " + enemy.getHp());
        } else {
            power = random.nextInt(getMax()) + 1;
            enemy.setHp(enemy.getHp() - power);
            if (enemy.getHp() <= 0) {
                enemy.setHp(0);
            }

            System.out.println("[히어로]가 " + power + "의 공격력으로 공격");
            System.out.println("현재 Zombie hp : " + enemy.getHp());
        }
    }

    public void recovery() {
        if (count > 0) {
            setHp(getHp() + 100);
            System.out.println("체력 회복해서 " + getHp() + "이 되었습니다.");
            count--;
        } else if (count == 0) {
            System.out.println("모두 사용했습니다.");
        }
    }
}
