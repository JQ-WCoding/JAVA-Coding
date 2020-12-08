package Day058P;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Member {
    private int customerNo; // 회원번호
    private String customerName; // 회원성명
    private String phone; // 회원 전화
    private String address; // 통신사?
    private String joinDate; // 가입일자
    private String grade; // 고객등급
    private String city; // 거주도시

    public Member() {

    }

    public Member(int customerNo, String customerName, String phone, String address, String joinDate, String grade, String city) {
        this.customerNo = customerNo;
        this.customerName = customerName;
        this.phone = phone;
        this.address = address;
        this.joinDate = joinDate;
        this.grade = grade;
        this.city = city;
    }
}

class Money {
    int customerNo; // 회원번호
    int saleNo; // 판매번호
    int productCost; // 단가
    int amount; // 수량
    int price; // 가격(매출)
    String productCode; // 상품코드
    String sellDate; // 판매일자

    public Money() {

    }

    public Money(int customerNo, int saleNo, int productCost, int amount, int price, String productCode, String sellDate) {
        this.customerNo = customerNo;
        this.saleNo = saleNo;
        this.productCost = productCost;
        this.amount = amount;
        this.price = price;
        this.productCode = productCode;
        this.sellDate = sellDate;
    }
}

class Manager {
    ArrayList<Member> memberList = new ArrayList<>();
    ArrayList<Money> moneyList = new ArrayList<>();

    public void init() {
        memberList.add(new Member(100001, "김행복", "010-1111-2222", "SK", "20151202", "A", "01"));
        memberList.add(new Member(100002, "이축복", "010-1111-3333", "SK", "20151206", "B", "01"));
        memberList.add(new Member(100003, "장믿음", "010-1111-4444", "SK", "20151001", "B", "30"));
        memberList.add(new Member(100004, "최사랑", "010-1111-5555", "SK", "20151113", "A", "30"));
        memberList.add(new Member(100005, "진평화", "010-1111-6666", "SK", "20151225", "B", "60"));
        memberList.add(new Member(100006, "차공단", "010-1111-7777", "SK", "20151211", "C", "60"));

        moneyList.add(new Money(100001, 20160001, 500, 5, 2500, "A001", "20160101"));
        moneyList.add(new Money(100001, 20160002, 1000, 4, 4000, "A002", "20160101"));
        moneyList.add(new Money(100001, 20160003, 500, 3, 1500, "A008", "20160101"));
        moneyList.add(new Money(100002, 20160004, 2000, 1, 2000, "A004", "20160102"));
        moneyList.add(new Money(100002, 20160005, 500, 1, 500, "A001", "20160103"));
        moneyList.add(new Money(100003, 20160006, 1500, 2, 3000, "A003", "20160103"));
        moneyList.add(new Money(100004, 20160007, 500, 2, 1000, "A001", "20160104"));
        moneyList.add(new Money(100004, 20160008, 300, 1, 300, "A005", "20160104"));
        moneyList.add(new Money(100004, 20160009, 600, 1, 600, "A006", "20160104"));
        moneyList.add(new Money(100004, 20160010, 3000, 1, 3000, "A007", "20160106"));
    }
}

public class Day05801정처리산기문제 {
    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.init();
    }
}
