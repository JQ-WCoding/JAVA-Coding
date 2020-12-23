package com.shop;

public class Item {
    int itemNo;
    String name;
    int price;
    String category;

    @Override
    public String toString() {
        return "제품 카테고리 : " + category + " / 품번 : " + itemNo + " / 품명 : " + name + " / 가격 : " + price + "원";
    }
}
