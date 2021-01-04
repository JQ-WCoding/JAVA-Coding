package Day073P;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class User {
    int num;
    String name;
    int money;

    @Override
    public String toString() {
        return "User{" +
                "num=" + num +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}

class UserDAO {
    private UserDAO() {
    }

    private static UserDAO instance = new UserDAO();

    public static UserDAO getInstance() {
        return instance;
    }

    ArrayList<User> userList = new ArrayList<>();

    public void add() {

    }

    public void update() {

    }

    public void delete() {

    }

    public void select() {

    }
}

public class Ex01 {
    public static void main(String[] args) {
        String data1 = "";
        data1 += "1001/김철수/8700\n";
        data1 += "1002/민병철/3100\n";
        data1 += "1003/최민정/5400\n";
        data1 += "1004/박병민/1700";

        // 문제 1) data1의 내용을 userList에 모두 저장하시오.
        String[] insertData = data1.split("\n");
        for (String insertDatum : insertData) {
            String[] inputData = insertDatum.split("/");
            User newUser = new User();
            newUser.num = Integer.parseInt(inputData[0]);
            newUser.name = inputData[1];
            newUser.money = Integer.parseInt(inputData[2]);
            UserDAO.getInstance().userList.add(newUser);
        }

        for (int i = 0; i < UserDAO.getInstance().userList.size(); i++) {
            System.out.println(UserDAO.getInstance().userList.get(i));
        }
        System.out.println();
        // 문제 2) 1003번의 이름을 유재석으로 변경해보시오.
        UserDAO.getInstance().userList.get(3).name = "유재석";
        // 문제 3) 돈이 2000원 미만인 사람은 삭제하시오. (일부러 2,000원 미만으로 변경)
        for (int i = 0; i < UserDAO.getInstance().userList.size(); i++) {
            if (UserDAO.getInstance().userList.get(i).money < 2000) {
                UserDAO.getInstance().userList.remove(i);
                i--;
            }
        }

        for (int i = 0; i < UserDAO.getInstance().userList.size(); i++) {
            System.out.println(UserDAO.getInstance().userList.get(i));
        }
        System.out.println();
        // 문제 4) 돈이 큰순서대로 정렬후 출력하시오.
        UserDAO.getInstance().userList.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o2.money, o1.money);
            }
        });

        for (int i = 0; i < UserDAO.getInstance().userList.size(); i++) {
            System.out.println(UserDAO.getInstance().userList.get(i));
        }
    }
}
