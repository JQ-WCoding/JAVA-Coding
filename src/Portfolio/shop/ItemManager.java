package Portfolio.shop;

import java.util.ArrayList;

public class ItemManager {
    static ArrayList<Item> itemList;

    public ItemManager() {
        itemList = new ArrayList<>();
    }

    /**
     * 물품 등록
     */
    public void addItem() {
        Item addItem = new Item();
        System.out.println("[등록] 등록할 물품 카테고리를 입력하세요");
        String checkCategory = Shop.scanner.next();

        int index = -1;
        for (int i = 0; i < itemList.size(); i++) {
            if (checkCategory.equals(itemList.get(i).category)) {
                index = i;
                break;
            }
        }
        if (index != -1) { // 중복되는 카테고리가 있음
            System.out.println("이미 존재하는 [" + checkCategory + "] 내에 물품을 등록합니다");
        } else { // 중복되는 카테고리가 없음
            System.out.println("새로운 [" + checkCategory + "] 내에 물품을 등록합니다");
        }
        addItem.category = checkCategory;

        System.out.println("[등록] 물품명을 등록하세요");
        addItem.name = Shop.scanner.next();

        System.out.println("[등록] 물품 가격을 등록하세요");
        addItem.price = Shop.scanner.nextInt();

        System.out.println("물품 번호는 가장 마지막 번호 다음으로 자동 등록됩니다 (사이 공백시 공백의 번호로 입력됩니다)");
        addItem.itemNo = addItemNo();

        // 물품 배열에 추가
        itemList.add(addItem);
    }

    /**
     * 물품 번호 자동 입력
     * 10001번 부터 시작
     *
     * @return checkItemNO
     */
    public int addItemNo() {
        int checkItemNo = 10001;
        for (Item item : itemList) {
            if (checkItemNo == item.itemNo) {
                checkItemNo++;
            } else {
                break;
            }
        }
        return checkItemNo;
    }

    /**
     * 전체 물품 리스트 출력
     */
    public void printAll() {
        if (itemList.size() == 0) {
            System.out.println("제품이 비어있습니다");
        } else {
            for (Item item : itemList) {
                System.out.println(item.toString());
            }
        }
    }

    /**
     * 물품 삭제
     */
    public void deleteItem() {
        System.out.println("[삭제] 삭제할 물품명을 입력하세요");
        String checkItem = Shop.scanner.next();

        int index = -1;
        for (int i = 0; i < itemList.size(); i++) {
            if (checkItem.equals(itemList.get(i).name)) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            itemList.remove(index);
        } else {
            System.out.println("삭제할 물품이 없습니다");
        }
    }

    /**
     * 카테고리 삭제
     */
    public void deleteCategory() {
        System.out.println("[삭제] 삭제할 카테고리를 입력하세요");
        String checkCategory = Shop.scanner.next();
        boolean check = false;
        for (Item item : itemList) {
            if (checkCategory.equals(item.category)) {
                check = true;
                break;
            }
        }
        if (check) {
            System.out.println("해당 카테고리의 물품을 모두 삭제합니다");
            int size = itemList.size();
            for (int i = 0; i < size; i++) {
                if (checkCategory.equals(itemList.get(i).category)) {
                    itemList.remove(i);
                    i--;
                    size--;
                }
            }
        } else {
            System.out.println("삭제할 카테고리가 존재하지 않습니다");
        }
//        ArrayList<Integer> indexList = new ArrayList<>();
//        for (int i = 0; i < itemList.size(); i++) {
//            if (checkCategory.equals(itemList.get(i).category)) {
//                indexList.add(i);
//            }
//        }
//        if (indexList.size() != 0) {
//            System.out.println("해당 카테고리가 포함된 물품을 모두 삭제합니다");
//            int size = itemList.size();
//            for (int i = 0; i < indexList.size(); i++) {
//                itemList.remove(indexList.get(i));
//            }
//        } else {
//            System.out.println("삭제할 카테고리가 존재하지 않습니다.");
//        }
    }


}
