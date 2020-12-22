package Day067P.다형성1;

// 표시(Interface) 인터페이스
interface Repairable {
}

// 모든 유닛의 최고 조상 클래스
class Unit {
    final int MAX_HP;
    int hp;

    Unit(int max_hp) {
        MAX_HP = max_hp;
    }

    public void damaged(int damage) {
        hp -= damage;

        if (hp < 0) {
            hp = 0;
        }
    }
}

class GroundUnit extends Unit {

    GroundUnit(int hp) {
        super(hp);
    }
}

class AirUnit extends Unit {
    AirUnit(int hp) {
        super(hp);
    }
}

class Tank extends GroundUnit implements Repairable {
    Tank() {
        super(150);
        hp = MAX_HP;
        System.out.println("Tank의 현재 hp는 " + hp + "입니다.");
    }

    @Override
    public String toString() {
        return "Tank [hp = " + hp + "]";
    }
}

class Marine extends GroundUnit {
    public Marine() {
        super(70);
        hp = MAX_HP;
        System.out.println("Marine의 현재 hp는 " + hp + "입니다.");
    }

    @Override
    public String toString() {
        return "Marine [hp = " + hp + "]";
    }
}

class SCV extends GroundUnit implements Repairable {
    public SCV() {
        super(100);
        hp = MAX_HP;
        System.out.println("SCV의 현재 hp는 " + hp + "입니다.");
    }

    public void repair(Repairable repairable) {
        Unit unit = (Unit) repairable;
        while (unit.hp != unit.MAX_HP) {
            unit.hp++;
            System.out.println(unit.hp + "/" + unit.MAX_HP);
        }
        System.out.println("수리 완료");
    }

    @Override
    public String toString() {
        return "SCV [hp = " + hp + "]";
    }
}

class DropShip extends AirUnit implements Repairable {
    public DropShip() {
        super(120);
        hp = MAX_HP;
        System.out.println("DropShip의 현재 hp는 " + hp + "입니다.");
    }

    @Override
    public String toString() {
        return "DropShip [hp = " + hp + "]";
    }
}

public class Day067다형성1 {
    public static void main(String[] args) {
        Tank tank = new Tank();
        tank.damaged(5);
        DropShip dropShip = new DropShip();
        dropShip.damaged(5);
        Marine marine = new Marine();

        SCV scv = new SCV();
        scv.repair(tank);
        scv.repair(dropShip);
//        scv.repair(marine); marine 은 Repairable 인터페이스를 상속받지 못했다
    }
}
