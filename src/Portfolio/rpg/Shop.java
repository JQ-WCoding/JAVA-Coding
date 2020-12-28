package Portfolio.rpg;

import java.util.ArrayList;

public class Shop {
    ArrayList<Item> itemList = new ArrayList<>();

    public Shop() {
        Item temp = new Item();
        // 무기
        temp.kind = Item.WEAPON;
        temp.name = "나무검";
        temp.power = 3;
        temp.price = 1000;
        itemList.add(temp);

        temp = new Item();
        temp.kind = Item.WEAPON;
        temp.name = "철검";
        temp.power = 5;
        temp.price = 2000;
        itemList.add(temp);

        temp = new Item();
        temp.kind = Item.WEAPON;
        temp.name = "레이피어";
        temp.power = 7;
        temp.price = 2500;
        itemList.add(temp);
        // 방어구
        temp = new Item();
        temp.kind = Item.ARMOR;
        temp.name = "티셔츠";
        temp.power = 1;
        temp.price = 300;
        itemList.add(temp);

        temp = new Item();
        temp.kind = Item.ARMOR;
        temp.name = "가죽갑옷";
        temp.power = 4;
        temp.price = 800;
        itemList.add(temp);

        temp = new Item();
        temp.kind = Item.ARMOR;
        temp.name = "강철갑옷";
        temp.power = 7;
        temp.price = 1500;
        itemList.add(temp);
        // 반지
        temp = new Item();
        temp.kind = Item.RING;
        temp.name = "은반지";
        temp.power = 7;
        temp.price = 3000;
        itemList.add(temp);

        temp = new Item();
        temp.kind = Item.RING;
        temp.name = "금반지";
        temp.power = 17;
        temp.price = 6000;
        itemList.add(temp);

        temp = new Item();
        temp.kind = Item.RING;
        temp.name = "다이아반지";
        temp.power = 35;
        temp.price = 20000;
        itemList.add(temp);
    }

    public void shopMng() {
        while (true) {
            System.out.println("===[상점]===");
            System.out.println("[1. 무기][2. 갑옷][3. 반지][0. 뒤로가기]");
            int selectKind = MainGame.scanner.nextInt();
            if (selectKind == 0) return; // (break)
            while (true) {
                if (selectKind == Item.WEAPON) {
                    System.out.println("===[무기]===");
                } else if (selectKind == Item.ARMOR) {
                    System.out.println("===[방어구]===");
                } else if (selectKind == Item.RING) {
                    System.out.println("===[반지]===");
                }
                printItems(selectKind);
                System.out.println("[골드 :" + Player.money + "]");
                System.out.println("구입할 아이템 번호를 입력하세요 [0. 뒤로가기]");

                int selectNum = MainGame.scanner.nextInt();
                if (selectNum == 0) break;

                int count = 0;
                for (int i = 0; i < itemList.size(); i++) {
                    if (itemList.get(i).kind == selectKind) {
                        count++;
                        if (count == selectNum) {
                            Player.inven.addItem(itemList.get(i));
                            Player.money -= itemList.get(i).price;
                            System.out.println("[" + itemList.get(i).name + "] 을 구입했습니다");
                            try {
                                Thread.sleep(1000);
                            }catch (InterruptedException e){
                                e.printStackTrace();
                            }
                            break;
                        }
                    }
                }
            }
        }
    }

    public void printItems(int kind) {
        int count = 0;
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).kind != kind) continue;
            System.out.println("[" + (count + 1) + "번]");
            System.out.println("[이름 : " + itemList.get(i).name + "]");
            System.out.println("[능력 : " + itemList.get(i).power + "]");
            System.out.println("[가격 : " + itemList.get(i).price + "]");
            System.out.println("");
            count++;
        }
    }
}
