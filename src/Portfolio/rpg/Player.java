package Portfolio.rpg;

import java.util.ArrayList;

public class Player {
    static int money;
    static Guild guild = new Guild();
    static Inventory inven = new Inventory();

    Player() {
        money = 100000;
        guild.setGuild();
    }

    /**
     * 길드 메뉴
     */
    public void guildMenu() {
        guild.guildMenu();
    }

    /**
     * 인벤토리 메뉴
     */
    public void inventoryMenu() {
        inven.inventoryMenu();
    }

    /**
     * 길드 목록 가져오기
     */
    static public ArrayList<Unit> getGuildList() {
        return guild.guildList;
    }

    /**
     * 아이템 목록 가져오기
     */
    static public ArrayList<Item> getItemList() {
        return inven.itemList;
    }

    /**
     * 길드원 목록 가져오기
     *
     * @param num
     * @return guild.getGuildUnit(num)
     */
    static public Unit getGuildUnit(int num) {
        return guild.getGuildUnit(num);
    }

    /**
     * 길드원 총인원 확인
     *
     * @return
     */
    static public int getGuildSize() {
        return guild.guildList.size();
    }

    /**
     * 아이템 총 보유 수 확인
     * @return
     */
    static public int getItemSize() {
        return inven.itemList.size();
    }
}
