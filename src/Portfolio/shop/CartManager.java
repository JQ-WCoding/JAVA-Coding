package Portfolio.shop;

import java.util.ArrayList;

public class CartManager {
    static ArrayList<Cart> cartList;

    public CartManager() {
        cartList = new ArrayList<>();
    }

    /**
     * 카테고리 확인
     */
    public void showCategory() {
        ArrayList<String> itemCategory = new ArrayList<>();

        for (Item item : ItemManager.itemList) {
            if (!itemCategory.contains(item.category)) {
                itemCategory.add(item.category);
            }
        }

        System.out.println(itemCategory);
    }

    /**
     * 물품 구매
     */
    public void buyItem(String logId) {
        System.out.println("원하는 카테고리를 입력하세요");
        showCategory();

        String checkCategory = Shop.scanner.next();

        boolean check = false;
        for (Item item : ItemManager.itemList) {
            if (checkCategory.equals(item.category)) {
                check = true;
                break;
            }
        }

        if (check) { // 해당 카테고리가 존재할 시
            while (true) {
                for (Item item : ItemManager.itemList) {
                    if (checkCategory.equals(item.category)) {
                        System.out.println(item.toString());
                    }
                }

                System.out.println("구매할 제품을 입력하세요 (0)입력시 메뉴로 이동");
                String checkItemName = Shop.scanner.next();

                if (checkItemName.equals("0")) {
                    break;
                }

                for (int i = 0; i < ItemManager.itemList.size(); i++) {
                    if (checkItemName.equals(ItemManager.itemList.get(i).name)) {
                        // 카트에 등록
                        Cart addCart = new Cart();
                        // 유저 넘버 확인하는 방법 찾기
                        addCart.userNo = findUserNo(logId);
                        addCart.itemNo = ItemManager.itemList.get(i).itemNo;
                        cartList.add(addCart);
                        break;
                    }
                }
            }
        } else {
            System.out.println("해당 카테고리가 없습니다");
        }
    }

    /**
     * 유저 번호 찾기
     *
     * @param logId
     * @return userNo
     */
    public int findUserNo(String logId) {
        int index = -1;
        for (int i = 0; i < UserManager.userList.size(); i++) {
            if (logId.equals(UserManager.userList.get(i).id)) {
                index = i;
                break;
            }
        }
        return UserManager.userList.get(index).userNo;
    }

    /**
     * 장바구니 확인
     */
    public void checkCart(String logId) {
        while (true) {
            cartMenuText();
            int choice = Shop.scanner.nextInt();

            if (choice == 1) { // 장바구니 전체 품목 출력
                printAllCartItem(logId);
            } else if (choice == 2) { // 장바구니 물품 삭제
                deleteCartItem(logId);
            } else if (choice == 0) { // 뒤로가기
                System.out.println("전 메뉴로 이동합니다");
                break;
            }
        }
    }

    /**
     * 해당 유저 장바구니 물품 목록 전부 출력
     *
     * @param logId
     */
    public void printAllCartItem(String logId) {
        int checkUserNo = findUserNo(logId);
        int count = 0;
        int price = 0;
        for (Cart cart : cartList) {
            if (checkUserNo == cart.userNo) { // 장바구니 내에 유저의 번호와 같은 물품이 등뢱되어있으면
                cartItemName(cart.itemNo, count);
                count++;
                price += cartItemPrice(cart.itemNo);
            }
        }
        if (count == 0) {
            System.out.println("장바구니가 비었습니다");
        } else {
            System.out.println("장바구니 총 결제금액 : " + price + "원");
        }
    }

    /**
     * 해당 유저 장바구니 내 물품명 출력 (printAllCartItem) 내부 사용
     *
     * @param itemNo
     * @param count
     */
    public void cartItemName(int itemNo, int count) {
        for (int i = 0; i < ItemManager.itemList.size(); i++) {
            if (itemNo == ItemManager.itemList.get(i).itemNo) {
                System.out.println("[" + (count + 1) + "]" + ItemManager.itemList.get(i).name);
                break;
            }
        }
    }

    public int cartItemPrice(int itemNo) {
        for (int i = 0; i < ItemManager.itemList.size(); i++) {
            if (itemNo == ItemManager.itemList.get(i).itemNo) {
                return ItemManager.itemList.get(i).price;
            }
        }
        return 0;
    }

    public void deleteCartItem(String logId) {
        int checkUserNo = findUserNo(logId);
        System.out.println("[삭제] 취소하고 싶은 물품명을 작성하세요");
        String checkItem = Shop.scanner.next();
        int index = -1;
        // 장바구니 내 물품 확인하기
        for (int i = 0; i < cartList.size(); i++) {
            if (checkUserNo == cartList.get(i).userNo && giveItemNo(checkItem) == cartList.get(i).itemNo) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            System.out.println("해당 물품을 장바구니에서 삭제합니다");
            cartList.remove(index);
        } else {
            System.out.println("해당 물품이 존재하지 않습니다");
        }
    }

    public int giveItemNo(String checkItem) {
        for (int i = 0; i < ItemManager.itemList.size(); i++) {
            if (checkItem.equals(ItemManager.itemList.get(i).name)) {
                return ItemManager.itemList.get(i).itemNo;
            }
        }
        return -1;
    }

    /**
     * 장바구니 메뉴 글
     */
    public void cartMenuText() {
        System.out.println("[장바구니 확인]");
        System.out.println("[1] 장바구니 전체 품목 확인");
        System.out.println("[2] 장바구니 물품 삭제");
        System.out.println("[0] 뒤로가기");
    }

    /**
     * 관리자 장바구니 관리
     */
    public void manageCart() {
        System.out.println("[장바구니 관리]");
        System.out.println("관리할 회원의 번호를 입력하세요");
        int checkUserNo = Shop.scanner.nextInt();

        boolean check = false;

        for (Cart cart : cartList) {
            if (checkUserNo == cart.userNo) {
                check = true;
                break;
            }
        }

        if (check) {
            // 장바구니 물품 번호 출력
            int count = 0;
            for (Cart cart : cartList) {
                if (checkUserNo == cart.userNo) {
                    System.out.println(cart.itemNo);
                    cartItemName(cart.itemNo, count);
                    count++;
                }
            }

            System.out.println("삭제할 물품 번호를 입력하세요");
            int checkItemNo = Shop.scanner.nextInt();

            for (int i = 0; i < cartList.size(); i++) {
                if (checkUserNo == cartList.get(i).userNo && checkItemNo == cartList.get(i).itemNo) {
                    System.out.println("해당 물품을 삭제합니다");
                    cartList.remove(i);
                    break;
                }
            }
        } else {
            System.out.println("해당 회원의 장바구니가 비었습니다");
        }
    }
}
