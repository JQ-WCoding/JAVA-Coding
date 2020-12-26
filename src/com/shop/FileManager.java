package com.shop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class FileManager {
    String userFileName = "userData.txt";
    String itemFileName = "itemData.txt";
    String cartFileName = "cartData.txt";

    /**
     * 회원 데어터 저장
     */
    public void saveUserData() {
        FileWriter fileWriter;
        StringBuilder userData = new StringBuilder();

        try {
            fileWriter = new FileWriter(userFileName);
            // 총회원 수
            int userSize = UserManager.userList.size();
            userData.append("총 회원 : ").append(userSize).append("명\n");

            for (int i = 0; i < userSize; i++) {
                userData.append(UserManager.userList.get(i).userNo).append("/");
                userData.append(UserManager.userList.get(i).id).append("/");
                userData.append(UserManager.userList.get(i).pw).append("/");
                userData.append(UserManager.userList.get(i).name).append("\n");
            }

            fileWriter.write(userData.toString());
            fileWriter.close();
        } catch (Exception e) {
            System.out.println("회원 데이터 저장 오류");
        }
    }

    /**
     * 물품 데이터 저장
     */
    public void saveItemData() {
        FileWriter fileWriter;
        StringBuilder itemData = new StringBuilder();

        try {
            fileWriter = new FileWriter(itemFileName);
            // 총 물품 수
            int itemSize = ItemManager.itemList.size();
            itemData.append("총 물품 : ").append(itemSize).append("개\n");

            for (int i = 0; i < itemSize; i++) {
                itemData.append(ItemManager.itemList.get(i).itemNo).append("/");
                itemData.append(ItemManager.itemList.get(i).name).append("/");
                itemData.append(ItemManager.itemList.get(i).price).append("/");
                itemData.append(ItemManager.itemList.get(i).category).append("\n");
            }

            fileWriter.write(itemData.toString());
            fileWriter.close();
        } catch (Exception e) {
            System.out.println("물품 데이터 저장 오류");
        }
    }

    /**
     * 장바구니 데이터 저장
     */
    public void saveCartData() {
        FileWriter fileWriter;
        StringBuilder cartData = new StringBuilder();

        try {
            fileWriter = new FileWriter(cartFileName);
            for (int i = 0; i < CartManager.cartList.size(); i++) {
                cartData.append(CartManager.cartList.get(i).userNo).append("/");
                cartData.append(CartManager.cartList.get(i).itemNo).append("\n");
            }

            fileWriter.write(cartData.toString());
            fileWriter.close();
        } catch (Exception e) {
            System.out.println("장바구니 데이터 저장 오류");
        }
    }

    /**
     * 모든 데이터 저장하기
     */
    public void saveAll() {
        saveCartData();
        saveItemData();
        saveUserData();
    }

    /**
     * 유저 데이터 로드하기
     */
    public void loadUserData() {
        String userData = loadLineData(userFileName);
        if (userData.equals("")) {
            System.out.println("로드할 사용자 데이터가 없습니다");
        } else {
            String[] tempUserData = userData.split("\n");

            for (int i = 1; i < tempUserData.length; i++) {
                String[] lineUserData = tempUserData[i].split("/");
                User addUser = new User();
                addUser.userNo = Integer.parseInt(lineUserData[0]);
                addUser.id = lineUserData[1];
                addUser.pw = lineUserData[2];
                addUser.name = lineUserData[3];

                UserManager.userList.add(addUser);
            }
        }
    }

    /**
     * 물품 데이터 로드하기
     */
    public void loadItemData() {
        String itemData = loadLineData(itemFileName);
        if (itemData.equals("")) {
            System.out.println("로드할 물품 데이터가 없습니다");
        } else {
            String[] tempItemData = itemData.split("\n");

            for (int i = 1; i < tempItemData.length; i++) {
                String[] lineItemData = tempItemData[i].split("/");
                Item addItem = new Item();

                addItem.itemNo = Integer.parseInt(lineItemData[0]);
                addItem.name = lineItemData[1];
                addItem.price = Integer.parseInt(lineItemData[2]);
                addItem.category = lineItemData[3];

                ItemManager.itemList.add(addItem);
            }
        }
    }

    /**
     *
     */
    public void loadCartData() {
        String cartData = loadLineData(cartFileName);
        if (cartData.equals("")) {
            System.out.println("로드할 장바구니 데이터가 없습니다");
        } else {
            String[] tempCartData = cartData.split("\n");
            for (String tempCartDatum : tempCartData) {
                String[] lineCartData = tempCartDatum.split("/");
                Cart addCart = new Cart();

                addCart.userNo = Integer.parseInt(lineCartData[0]);
                addCart.itemNo = Integer.parseInt(lineCartData[1]);

                CartManager.cartList.add(addCart);
            }
        }
    }

    /**
     * 데이터 로드 메소드
     *
     * @param fileName
     * @return String data
     */
    public String loadLineData(String fileName) {
        FileReader fileReader;
        BufferedReader bufferedReader;

        StringBuilder data = new StringBuilder();

        try {
            fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader);

            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                data.append(line).append("\n");
            }
            return data.toString();
        } catch (Exception e) {
            System.out.println("로드 오류");
            return null;
        }
    }

    /**
     * 모든 데이터 로드
     */
    public void loadAll() {
        loadCartData();
        loadItemData();
        loadUserData();
    }
}
