package com.rpg;

import java.util.ArrayList;

public class Inventory {
    ArrayList<Item> itemList = new ArrayList<>();

    public void inventoryMenu() {
        while (true) {
            System.out.println("===[인벤 메뉴]===");
            System.out.println("[1. 착용][2. 판매][0. 뒤로가기]");
            int select = MainGame.scanner.nextInt();

            if (select == 0) break;
            if (select == 1) {
                equipMenu();
            }
            if (select == 2) {
                sellMenu();
            }
        }
    }

    /**
     * 아이템 착용 메뉴
     */
    public void equipMenu() {
        Player.guild.printAllUnitStatus();
        System.out.println("아이템을 착용할 길드원을 선택하세요");
        int selectUnit = MainGame.scanner.nextInt();
        while (true) {
            Player.guild.printUnitStatus(selectUnit - 1);
            Player.guild.printUnitItem(selectUnit - 1);

        }
    }

    /**
     * 아이템 리스트 출력
     */
    public void printItemList() {
        System.out.println("===[아이템리스트]===");
        for (int i = 0; i < itemList.size(); i++) {
            System.out.println("[" + (i + 1) + "번]");
            System.out.println("[이름 : " + itemList.get(i).name + "]");
            System.out.println("[능력 : " + itemList.get(i).power + "]");
            System.out.println("[가격 : " + itemList.get(i).price + "]");
            System.out.println("");
        }
    }

    /**
     * 아이템 판매 메뉴
     */
    public void sellMenu() {
        while (true) {
            printItemList();
            System.out.println("[골드 : " + Player.money + "]");
            System.out.println("판매할 아이템 번호를 입력하세요. (50% 세금) [0. 뒤로가기]");
            int selectSell = MainGame.scanner.nextInt();
            System.out.println(itemList.get(selectSell - 1).name + "을 판매합니다");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Player.money += (itemList.get(selectSell - 1).price / 2);
            itemList.remove(selectSell - 1);
        }
    }

    /**
     * 아이템 추가하기
     * @param item
     */
    public void addItem(Item item){
        itemList.add(item);
    }
}
