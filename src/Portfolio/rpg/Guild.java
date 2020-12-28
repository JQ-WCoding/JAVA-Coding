package Portfolio.rpg;

import java.util.ArrayList;

public class Guild {
    final int PARTY_SIZE = 4;
    ArrayList<Unit> guildList = new ArrayList<Unit>();
    Unit[] partyList;

    /**
     * 길드 설정
     */
    public void setGuild() {
        Unit temp = new Unit("호랑이", 1, 100, 10, 5, 0);
        guildList.add(temp);
        temp = new Unit("강아지", 1, 80, 7, 3, 0);
        guildList.add(temp);
        temp = new Unit("사슴", 1, 50, 3, 1, 0);
        guildList.add(temp);
        temp = new Unit("두더지", 1, 70, 5, 2, 0);
        guildList.add(temp);
        temp = new Unit("돼지", 1, 200, 4, 8, 0);
        guildList.add(temp);
        temp = new Unit("사자", 1, 120, 11, 7, 0);
        guildList.add(temp);
        for (int i = 0; i < 4; i++) {
            guildList.get(i).party = true;
        }
        partyList = new Unit[PARTY_SIZE];
        int n = 0;
        for (int i = 0; i < guildList.size(); i++) {
            if (guildList.get(i).party) {
                partyList[n] = guildList.get(i);
                n++;
            }
        }
    }

    /**
     * 길드 유닛 번호를 통해 가져오기
     *
     * @param num
     * @return
     */
    public Unit getGuildUnit(int num) {
        return guildList.get(num);
    }

    /**
     * 전체 유닛 능력치 출력
     */
    public void printAllUnitStatus() {
        System.out.println("=======");
        System.out.println("[골드 : " + Player.money + "]");
        for (int i = 0; i < guildList.size(); i++) {
            System.out.println("[" + (i + 1) + "번]");
            System.out.println("[이름 : " + guildList.get(i).name + "]");
            System.out.println("[레벨 : " + guildList.get(i).level + "]");
            System.out.print("[체력 : " + guildList.get(i).hp);
            System.out.println(" / " + guildList.get(i).maxHp + "]");
            System.out.println("[공격력 : " + guildList.get(i).attack + "]");
            System.out.println("[방어력 : " + guildList.get(i).defense + "]");
            System.out.println("[파티중 : " + guildList.get(i).party + "]");
            System.out.println("");
        }
        System.out.println("======");
    }

    /**
     * 유닛 능력치 출력
     *
     * @param num
     */
    public void printUnitStatus(int num) {
        guildList.get(num).printStatus();
    }

    /**
     * 유닛 아이템 출력
     *
     * @param num
     */
    public void printUnitItem(int num) {
        guildList.get(num).printEquippedItem();
    }

    /**
     * 유닛 구매
     */
    public void buyUnit() {
        if (Player.money < 5000) {
            return;
        }
        String[] n1 = {"박", "이", "김", "최", "유", "지", "오"};
        String[] n2 = {"명", "기", "종", "민", "재", "석", "광"};
        String[] n3 = {"수", "자", "민", "수", "석", "민", "철"};

        String name = n1[MainGame.random.nextInt(n1.length)];
        name += n2[MainGame.random.nextInt(n1.length)];
        name += n3[MainGame.random.nextInt(n1.length)];

        int random = MainGame.random.nextInt();
        int hp = random * 11;
        int attack = random + 1;
        int defense = random / 2 + 1;
        Unit temp = new Unit(name, 1, hp, attack, defense, 0);

        System.out.println("=======");

        System.out.println("[이름 : " + name + "]");
        System.out.println("[레벨 : " + 1 + "]");
        System.out.print("[체력 : " + hp);
        System.out.println(" / " + hp + "]");
        System.out.println("[공격력 : " + attack + "]");
        System.out.println("[방어력 : " + defense + "]");
        System.out.println("길드원을 추가합니다");
        System.out.println("=======");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        guildList.add(temp);
        Player.money -= 5000;
    }

    /**
     * 유닛 삭제
     */
    public void removeUnit() {
        printAllUnitStatus();
        System.out.println("삭제할 번호를 입력하세요");
        int select = MainGame.scanner.nextInt();
        if (guildList.get(select - 1).party) { // party = true;
            System.out.println("파티중인 멤버는 삭제할 수 없습니다");
        } else {
            System.out.println("======");
            System.out.println("[이름 : " + guildList.get(select - 1).name + "]");
            System.out.println("길드원을 삭제합니다");
            System.out.println("======");
            guildList.remove(select - 1);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 파티원 출력
     */
    public void printParty() {
        System.out.println("===[파티원]====");
        for (int i = 0; i < PARTY_SIZE; i++) {
            System.out.println("[" + (i + 1) + "번]");
            System.out.println("[이름 : " + partyList[i].name + "]");
            System.out.println("[레벨 : " + partyList[i].level + "]");
            System.out.print("[체력 : " + partyList[i].hp + "]");
            System.out.println(" / " + partyList[i].maxHp + "]");
            System.out.println("[공격력 : " + partyList[i].attack + "]");
            System.out.println("[방어력 : " + partyList[i].defense + "]");
            System.out.println("[파티중 : " + guildList.get(i).party + "]");
            System.out.println("");
        }
        System.out.println("======");
    }

    /**
     * 파티원 변경
     */
    public void partyChange() {
        printParty();
        System.out.println("교체할 번호를 입력하세요");
        int partyNum = MainGame.scanner.nextInt();
        printAllUnitStatus();
        System.out.println("참가할 번호를 입력하세요");
        int guildNum = MainGame.scanner.nextInt();

        partyList[partyNum - 1].party = false;
        guildList.get(guildNum - 1).party = true;

        System.out.println("======");
        System.out.println("[이름 : " + partyList[partyNum - 1].name + "]");
        System.out.println("에서");
        System.out.println("[이름 : " + guildList.get(guildNum - 1).name + "]");
        System.out.println("으로 교체합니다");
        System.out.println("======");

        int n = 0;
        for (int i = 0; i < guildList.size(); i++) {
            if (guildList.get(i).party) {
                partyList[n] = guildList.get(i);
                n++;
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 길드 메뉴
     */
    public void guildMenu() {
        while (true) {
            System.out.println("===[길드관리]===");
            System.out.println("[1. 길드목록][2. 길드원추가][3. 길드원삭제]\n" + "[4. 파티원교체][5. 정렬][0. 뒤로가기]");
            int select = MainGame.scanner.nextInt();
            if (select == 1) { // 길드목록
                printAllUnitStatus();
            } else if (select == 2) { // 길드원 추가
                buyUnit();
            } else if (select == 3) { // 길드원 삭제
                removeUnit();
            } else if (select == 4) { // 파티원 교체
                partyChange();
            } else if (select == 5) { // 정렬
                // 정렬하기?
            } else if (select == 0) { // 뒤로가기
                break;
            }
        }
    }
}
