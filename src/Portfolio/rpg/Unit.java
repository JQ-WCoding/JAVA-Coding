package Portfolio.rpg;

public class Unit {
    String name;
    int level;
    int hp;
    int maxHp;
    int attack;
    int defense;
    int exp;
    boolean party;
    Item weapon;
    Item armor;
    Item ring;

    // 파티 기본 false
    public Unit(String n, int l, int h, int a, int d, int e) {
        name = n;
        level = l;
        maxHp = h;
        attack = a;
        defense = d;
        exp = e;
        hp = maxHp;
        party = false;
        weapon = null;
        armor = null;
        ring = null;
    }

    // 파티 매게변수 추가
    public Unit(String n, int l, int h, int a, int d, int e, boolean p) {
        name = n;
        level = l;
        maxHp = h;
        attack = a;
        defense = d;
        exp = e;
        hp = maxHp;
        party = p;
        weapon = null;
        armor = null;
        ring = null;
    }

    /**
     * 아이템 세팅
     *
     * @param w
     * @param a
     * @param r
     */
    public void setItem(Item w, Item a, Item r) {
        weapon = w;
        armor = a;
        ring = r;
    }

    /**
     * 현재 캐릭터 능력치 출력
     */
    public void printStatus() {
        System.out.println("[이름 : " + name + "]");
        System.out.println("[레벨 : " + level + "]");
        // 체력
        if (ring != null) {
            System.out.println("[체력 : " + hp + " + " + ring.power);
        } else {
            System.out.println("[체력 : " + hp);
        }
        if (ring != null) {
            System.out.println(" / " + maxHp + " + " + ring.power + "]");
        } else {
            System.out.println(" / " + maxHp + "]");
        }

        // 공격력
        if (weapon != null) {
            System.out.println("[공격력 : " + attack + " + " + weapon.power + "]");
        } else {
            System.out.println("[공격력 : " + attack + "]");
        }

        // 방어력
        if (armor != null) {
            System.out.println("[방어력 : " + defense + " + " + armor.power + "]");
        } else {
            System.out.println("[방어력 : " + defense + "]");
        }
        System.out.println("[파티중 : " + party + "]");
    }

    /**
     * 현재 착용한 아이템
     */
    public void printEquippedItem() {
        // 무기 착용
        if (weapon == null) {
            System.out.println("[무기 : 없음]");
        } else {
            System.out.println("[무기 : " + weapon.name + "]");
        }

        // 방어구 착용
        if (weapon == null) {
            System.out.println("[방어구 : 없음]");
        } else {
            System.out.println("[방어구 : " + armor.name + "]");
        }

        // 반지 착용
        if (ring == null) {
            System.out.println("[반지 : 없음]");
        } else {
            System.out.println("[반지 : " + ring.name + "]");
        }
    }
}
