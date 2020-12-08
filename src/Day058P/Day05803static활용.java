package Day058P;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class User {
    String id;
    String pw;
    String name;
}

class UserManager {
    Scanner scanner = new Scanner(System.in);
    ArrayList<User> userList = new ArrayList<>();

    public void dataSetting(String data) {
        String[] token = data.split("\n");
        for (String s : token) {
            User user = new User();
            String[] token2 = s.split("/");
            user.id = token2[0];
            user.pw = token2[1];
            user.name = token2[2];
            userList.add(user);
        }
    }

    public boolean checkId(String id) {
        for (User user : userList) {
            if (id.equals(user.id)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkLogin(String id, String pw) {
        for (User user : userList) {
            if (id.equals(user.id) && pw.equals(user.pw)) {
                return true;
            }
        }
        return false;
    }

    public void join(AccountManager accountManager) {
        System.out.println("[회원가입] id를 입력하세요");
        String id = scanner.next();
        if (checkId(id)) {
            System.out.println("중복id 입니다.");
        } else {
            System.out.println("[회원가입] 비밀번호를 입력하세요");
            String pw = scanner.next();
            System.out.println("[회원가입] 이름을 입력하세요");
            String name = scanner.next();
            User user = new User();
            user.id = id;
            user.pw = pw;
            user.name = name;
            userList.add(user);
            // accountManager
            System.out.println("회원가입을 축하합니다");
        }
    }
}

class Account {
    String userId;
    String accountId;
    int money;
}

class AccountManager {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Account> accountList = new ArrayList<>();

    public void dataSetting(String data) {
        String[] token = data.split("\n");
        for (String s : token) {
            Account account = new Account();
            String[] token2 = s.split("/");
            account.userId = token2[0];
            account.accountId = token2[1];
            account.money = Integer.parseInt(token2[2]);
            accountList.add(account);
        }
    }

    ArrayList<Account> getPersonalAccount(String id) {
        ArrayList<Account> personalList = new ArrayList<Account>();
        for (Account account : accountList) {
            if (account.userId.equals(id)) {
                personalList.add(account);
            }
        }
        return personalList;
    }

    public void openAccount(String id) { // 계좌 개설
        Random random = new Random();
        String accountId = "";
        for (int i = 0; i < 3; i++) {
            int r1 = random.nextInt(10);
            accountId += r1;
            int r2 = random.nextInt(10);
            accountId += r2;
            int r3 = random.nextInt(10);
            accountId += r3;
            int r4 = random.nextInt(10);
            accountId += r4;
            if (i < 3 - 1) {
                accountId += "";
            }
            System.out.println(id + " : " + accountId);
            Account account = new Account();
            account.accountId = accountId;
            account.userId = id;
            account.money = 0;
            accountList.add(account);
        }
    }

    public void deposit(UserManager userManager) {
        System.out.println("[입금] id 를 입력하세요");
        String id = scanner.next();
        System.out.println("[입금] pw 를 입력하세요");
        String pw = scanner.next();
        if (userManager.checkLogin(id, pw)) {
            System.out.println("[입급] 계좌번호를 선택하세요");
            ArrayList<Account> personalAccount = getPersonalAccount(id);
            for (int i = 0; i < personalAccount.size(); i++) {
                System.out.println("[" + i + "]" + personalAccount.get(i).accountId + " : ");
                System.out.println(personalAccount.get(i).money);
            }
            int sel = scanner.nextInt();
            System.out.println("[입금] 금액을 입력하세요");
            int money = scanner.nextInt();
            personalAccount.get(sel).money += money;
        }
    }

    public void checkBalance(UserManager userManager) {
        System.out.println("[입금] id를 입력하세요");
        String id = scanner.next();
        System.out.println("[입금] pw를 입력하세요");
        String pw = scanner.next();
        if (userManager.checkLogin(id, pw)) {
            ArrayList<Account> personalAccount = getPersonalAccount(id);
            for (int i = 0; i < personalAccount.size(); i++) {
                System.out.println("[" + i + "]" + personalAccount.get(i).accountId + " : ");
                System.out.println(personalAccount.get(i).money);
            }
        }
    }
}

class Bank {
    AccountManager accountManager;
    UserManager userManager;
    Scanner scanner = new Scanner(System.in);

    public void bankSetting(AccountManager accountManager, UserManager userManager) {
        this.accountManager = accountManager;
        this.userManager = userManager;
    }

    public void run() {
        while (true) {
            System.out.println("(1) 회원가입 (2) 입금 (3) 조회 (4) 계좌추가 (5) 이체 (6) 회원탈퇴 (7) 계좌삭제 (0) 종료");
            int sel = scanner.nextInt();
            if (sel == 1) { // 회원가입
                userManager.join(accountManager);
            } else if (sel == 2) { // 입금
                accountManager.deposit(userManager);
            } else if (sel == 3) { // 조회
                accountManager.checkBalance(userManager);
            } else if (sel == 4) { // 계좌추가

            } else if (sel == 5) { // 이체
                accountManager.deposit(userManager);
            } else if (sel == 6) { // 회원탈퇴

            } else if (sel == 7) { // 계좌삭제

            } else if (sel == 0) {
                System.out.println("종료");
                break;
            }
        }
    }
}

public class Day05803static활용 {
    public static void main(String[] args) {
        String userdata = "test01/pw1/김철수\n";
        userdata += "test02/pw2/이영희\n";
        userdata += "test03/pw3/신민수\n";
        userdata += "test04/pw4/최상민";

        String accountdata = "test01/1111-1111-1111/8000\n";
        accountdata += "test02/2222-2222-2222/5000\n";
        accountdata += "test01/3333-3333-3333/11000\n";
        accountdata += "test03/4444-4444-4444/9000\n";
        accountdata += "test01/5555-5555-5555/5400\n";
        accountdata += "test02/6666-6666-6666/1000\n";
        accountdata += "test03/7777-7777-7777/1000\n";
        accountdata += "test04/8888-8888-8888/1000";
        // 1) test01 김철수 는 계좌를 3개 가지고있다.
        // 2) test02 이영희 는 계좌를 2개 가지고있다.
        // 3) test03 신민수 는 계좌를 2개 가지고있다.
        // 4) test04 최상민 은 계좌를 1개 가지고있다.

        UserManager userManager = new UserManager();
        userManager.dataSetting(userdata);
        AccountManager accountManager = new AccountManager();
        accountManager.dataSetting(accountdata);

        Bank bank = new Bank();
        bank.bankSetting(accountManager, userManager);
        bank.run();
    }
}
