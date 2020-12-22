package Day067P.다형성2;

import java.util.Random;

class Unit {
    int MAX_HP;
    int hp;
    int power;

    public Unit(int hp, int power) {
        MAX_HP = hp;
        this.hp = MAX_HP;
        this.power = power;
    }

    public void attack(Unit unit) {
    }

    @Override
    public String toString() {
        return hp + "/" + MAX_HP;
    }
}

class Wolf extends Unit {
    int leg;
    int bite;

    public Wolf() {
        super(100, 10);
    }

    @Override
    public void attack(Unit unit) {
        Random random = new Random();

        int rNum = random.nextInt(10) + 1;

        unit.hp -= power;
        unit.hp -= rNum;

        System.out.println("Wolf가 기본 데미지 " + this.power + "을(를) 입혔습니다.");
        System.out.println("Wolf가 추가 데미지 " + rNum + "을(를) 입혔습니다.");
    }
}

class Bat extends Unit {
    int fly;
    int poison;

    public Bat() {
        super(50, 5);
    }

    @Override
    public void attack(Unit unit) {
        unit.hp -= power;
        System.out.println("Bat가 기본 데미지 " + this.power + "을(를) 입혔습니다.");
    }
}

public class Day067다형성2 {
    public static void main(String[] args) {
        Unit[] units = new Unit[5];

        Wolf wolf = new Wolf();
        units[0] = wolf;

        Bat bat = new Bat();
        units[1] = bat;

        units[0].attack(units[1]);
        System.out.println(units[1]);

        units[1].attack(units[0]);
    }
}
