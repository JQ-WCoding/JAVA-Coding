package com.rpg;

import java.io.*;
import java.util.ArrayList;

public class FileData {
    public void save() throws IOException {
        FileWriter fileWriter = null;
        String path = "gameData.txt";

        fileWriter = new FileWriter(path);
        ArrayList<Unit> temp = Player.getGuildList();
        String gameData = "";
        gameData += Player.money;
        gameData += "$r$n";
        gameData += temp.size();
        gameData += "$r$n";
        // Unit temp = new Unit("호랑이",1,100,10,5,0);
        for (int i = 0; i < temp.size(); i++) {
            gameData += temp.get(i).name;
            gameData += "/";
            gameData += temp.get(i).level;
            gameData += "/";
            gameData += temp.get(i).maxHp;
            gameData += "/";
            gameData += temp.get(i).attack;
            gameData += "/";
            gameData += temp.get(i).defense;
            gameData += "/";
            gameData += temp.get(i).exp;
            gameData += "/";
            gameData += temp.get(i).party;
            gameData += "$r$n";
            if (temp.get(i).weapon == null) {
                gameData += temp.get(i).weapon;
            } else {
                Item item = temp.get(i).weapon;
                String weaponData = "";
                weaponData += item.kind;
                weaponData += ",";
                weaponData += item.name;
                weaponData += ",";
                weaponData += item.power;
                weaponData += ",";
                weaponData += item.price;
                gameData += weaponData;
            }
            gameData += "/";
            if (temp.get(i).armor == null) {
                gameData += temp.get(i).armor;
            } else {
                Item item = temp.get(i).armor;
                String armorData = "";
                armorData += item.kind;
                armorData += ",";
                armorData += item.name;
                armorData += ",";
                armorData += item.power;
                armorData += ",";
                armorData += item.price;
                gameData += armorData;
            }
            gameData += "/";
            if (temp.get(i).ring == null) {
                gameData += temp.get(i).ring;
            } else {
                Item item = temp.get(i).ring;
                String ringData = "";
                ringData += item.kind;
                ringData += ",";
                ringData += item.name;
                ringData += ",";
                ringData += item.power;
                ringData += ",";
                ringData += item.price;
                gameData += ringData;
            }
            gameData += "$r$n";
        }
        gameData += Player.getItemSize();
        gameData += "$r$n";

        for (int i = 0; i < Player.getItemSize(); i++) {
            Item item = Player.getItemList().get(i);

            gameData += item.kind;
            gameData += "/";
            gameData += item.name;
            gameData += "/";
            gameData += item.power;
            gameData += "/";
            gameData += item.price;
            gameData += "$r$n";
        }
        System.out.println(gameData);
        fileWriter.write(gameData, 0, gameData.length());
        fileWriter.close();
    }

    public void loadData() throws IOException{
        File file = null;
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        String path = "gameData.txt";
        file = new File(path);
        if (file.exists()){
            fileReader = new FileReader(path);
        }
    }
}
