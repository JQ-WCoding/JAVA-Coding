package Portfolio.rpg;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class MainGame {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public MainGame() {
        Player player = new Player();
        Shop shop = new Shop();
        FileData fileData = new FileData();
        while (true) {
            System.out.println("===[메인메뉴]===");
            System.out.println("[1. 길드관리][2. 상점][3. 인벤토리]");
            System.out.println("[4. 저장][5. 로드][0. 종료]");
            int select = scanner.nextInt();
            if (select == 1) { // 길드관리
                player.guildMenu();
            } else if (select == 2) { // 상점
                shop.shopMng();
            } else if (select == 3) { // 인벤토리
                player.inventoryMenu();
            } else if (select == 4) { // 저장
                try {
                    fileData.save();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (select == 5) { // 로드
                try {
                    fileData.loadData();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("게임을 종료 합니다");
                break;
            }
        }
        MainGame.scanner.close();
    }
}
