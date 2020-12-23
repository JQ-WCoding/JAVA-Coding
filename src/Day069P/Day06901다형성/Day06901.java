package Day069P.Day06901다형성;

import java.util.Random;

abstract class Unit {
    int MAX_HP;
    int hp;
    int power;

    public Unit(int hp, int power) {
        MAX_HP = hp;
        this.hp = hp;
        this.power = power;
    }

    abstract void skill();

    abstract void attack(Unit unit);

    @Override
    public String toString() {
        return hp + " / " + MAX_HP;
    }
}

class Wolf extends Unit {
    int leg;
    int bite;

    public Wolf(int leg, int bite) {
        super(100, 10);
        this.leg = leg;
        this.bite = bite;
    }

    @Override
    void skill() {
        power += leg + bite;
        System.out.println("다리개수와 이빨개수만큼 공격력이 향상했다!  power = " + power);
    }

    @Override
    void attack(Unit unit) {
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

    public Bat(int fly, int poison) {
        super(50, 5);
        this.fly = fly;
        this.poison = poison;
    }

    @Override
    void attack(Unit unit) {
        unit.hp -= power;

        System.out.println("Bat가 기본 데미지 " + this.poison + "을(를) 입혔습니다.");
    }

    @Override
    void skill() {

    }
}

public class Day06901 {
    public static void main(String[] args) {
        /**
         * # 다형성
         * 1. 서로 다른 클래스는 배열에 저장이 불가능하기 때문에
         * 2. 공통 부모를 상속받아
         * 3. 부모 클래스로 배열을 만들면 한 배열에 서로 다른 클래스들을 저장할 수 있다.
         */
        // Unit이라는 객체 배열 내에 wolf 와 bat을 모두 수용할 수 있다.
        Unit[] units = new Unit[5];

        Wolf wolf = new Wolf(3, 10);
        units[0] = wolf;
        units[0].skill();

        Bat bat = new Bat(10, 15);
        units[1] = bat;

        units[0].attack(units[1]);
        System.out.println(units[1]);

        units[1].attack(units[0]);
    }
}
