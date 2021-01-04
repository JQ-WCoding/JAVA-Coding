package Day073P;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Member {
    int num;
    String id;
    String pw;

    public Member() {
    }

    public Member(int num, String id, String pw) {
        this.num = num;
        this.id = id;
        this.pw = pw;
    }

    @Override
    public String toString() {
        return "Member{" +
                "num=" + num +
                ", id='" + id + '\'' +
                ", pw='" + pw + '\'' +
                '}';
    }
}

class Item {
    int num;
    String name;
    int price;

    public Item() {
    }

    public Item(int num, String name, int price) {
        this.num = num;
        this.name = name;
        this.price = price;
    }
}

class Order {
    int num;
    String memberId;
    String itemName;

    public Order() {
    }

    public Order(int num, String memberId, String itemName) {
        this.num = num;
        this.memberId = memberId;
        this.itemName = itemName;
    }

    @Override
    public String toString() {
        return "Order{" +
                "num=" + num +
                ", memberId='" + memberId + '\'' +
                ", itemName='" + itemName + '\'' +
                '}';
    }
}

class MemberDAO {
    private MemberDAO() {
    }

    private static MemberDAO instance = new MemberDAO();

    public static MemberDAO getInstance() {
        return instance;
    }

    ArrayList<Member> memberList = new ArrayList<>();

    public void setData() {
        memberList.add(new Member(0, "qwer", "1234"));
        memberList.add(new Member(1, "abcd", "1234"));
        memberList.add(new Member(2, "haha", "1234"));
        memberList.add(new Member(3, "java", "1234"));
    }
}

class ItemDAO {
    private ItemDAO() {
    }

    private static ItemDAO instance = new ItemDAO();

    public static ItemDAO getInstance() {
        return instance;
    }

    ArrayList<Item> itemList = new ArrayList<>();

    public void setData() {
        itemList.add(new Item(0, "사과", 1000));
        itemList.add(new Item(1, "바나나", 1300));
        itemList.add(new Item(2, "귤", 1200));
        itemList.add(new Item(3, "배", 1500));
    }
}

class OrderDAO {
    private OrderDAO() {
    }

    private static OrderDAO instance = new OrderDAO();

    public static OrderDAO getInstance() {
        return instance;
    }

    ArrayList<Order> orderList = new ArrayList<>();

    public void setData() {
        orderList.add(new Order(0, "qwer", "사과"));
        orderList.add(new Order(1, "haha", "귤"));
        orderList.add(new Order(2, "java", "바나나"));
        orderList.add(new Order(3, "abcd", "배"));
        orderList.add(new Order(4, "qwer", "사과"));
        orderList.add(new Order(5, "haha", "배"));
        orderList.add(new Order(6, "abcd", "바나나"));
        orderList.add(new Order(7, "java", "사과"));
        orderList.add(new Order(8, "qwer", "배"));
    }
}

public class Ex02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        MemberDAO.getInstance().setData();
        ItemDAO.getInstance().setData();
        OrderDAO.getInstance().setData();

        // 문제1) id를 입력받아 해당 회원이 구입한 아이템 전체 출력해보시오
        // 조건1) 겹치는 아이템은 개수도 함께 출력하시오.
        // 예1) 입력 : qwer
        // 출력1) 사과 2개, 배 1개 (총합 3500원)
        System.out.println("아이디를 입력하세요");
        String myId = scanner.next();

        HashMap<String, Integer> count = new HashMap<>();

        for (int i = 0; i < OrderDAO.getInstance().orderList.size(); i++) {
            if (OrderDAO.getInstance().orderList.get(i).memberId.equals(myId)) {
                count.put(OrderDAO.getInstance().orderList.get(i).itemName, count.getOrDefault(OrderDAO.getInstance().orderList.get(i).itemName, 0) + 1);
            }
        }

        int total = 0;
        for (String key : count.keySet()) {
            System.out.println(key + " : " + count.get(key));
            for (int i = 0; i < ItemDAO.getInstance().itemList.size(); i++) {
                if (key.equals(ItemDAO.getInstance().itemList.get(i).name)) {
                    total += count.get(key) * ItemDAO.getInstance().itemList.get(i).price;
                    break;
                }
            }
        }

        System.out.println(count);
        System.out.println(total + "원");

        // 문제2) 회원 번호를 입력하면, 탈퇴시키시오.
        // 조건2) orderList에서도 찾아서 삭제하시오.
        System.out.println("회원 번호를 입력하세요");
        int userNum = scanner.nextInt();
        String getId = "";
        for (int i = 0; i < MemberDAO.getInstance().memberList.size(); i++) {
            if (userNum == MemberDAO.getInstance().memberList.get(i).num) {
                getId = MemberDAO.getInstance().memberList.get(i).id;
                MemberDAO.getInstance().memberList.remove(i);
                break;
            }
        }
        for (int i = 0; i < OrderDAO.getInstance().orderList.size(); i++) {
            if (getId.equals(OrderDAO.getInstance().orderList.get(i).memberId)) {
                OrderDAO.getInstance().orderList.remove(i);
                i--;
            }
        }

        for (int i = 0; i < MemberDAO.getInstance().memberList.size(); i++) {
            System.out.println(MemberDAO.getInstance().memberList.get(i).toString());
        }
        for (int i = 0; i < OrderDAO.getInstance().orderList.size(); i++) {
            System.out.println(OrderDAO.getInstance().orderList.get(i).toString());
        }
    }
}
