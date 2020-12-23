package Day069P.Day06905ZombieGame;

import java.util.Random;

abstract public class Unit {
    Random random;

    private int position;
    private int hp;
    private int max;

    public Unit() {
    }

    public Unit(int position, int hp, int max) {
        this.position = position;
        this.hp = hp;
        this.max = max;

        random = new Random();
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public void move() {
        if (position <= 10) position++;
        System.out.println("[오른쪽으로 이동] 현재 위치 = " + position);
    }

    abstract public void attack(Unit unit);
}
