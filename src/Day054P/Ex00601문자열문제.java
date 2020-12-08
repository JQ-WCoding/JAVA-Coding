package Day054P;

class Employee {
    int no;
    int point;
    String name;
    // 판매 실적이 4이상이면 true 로 입력
    boolean best;

    public void print() {
        System.out.println("사원 번호 : " + no);
        System.out.println("사원 점수 : " + point);
        System.out.println("사원 이름 : " + name);
        System.out.println("우수 사원 여부 : " + best);
    }
}

public class Ex00601문자열문제 {
    public static void main(String[] args) {
        String data1 = "1001/3,1002/1,1001/3,1003/5,1004/1,1002/2";
        String data2 = "1001/이만수,1002/김철수,1003/신민아,1004/박상아";

        Employee[] list = null;

        String[] splitData1 = data1.split(",");

        String[] splitData2 = data2.split(",");

        list = new Employee[splitData2.length];

        for (int i = 0; i < splitData2.length; i++) {
            list[i] = new Employee();
            int total = 0;
            for (int j = 0; j < splitData1.length; j++) {
                if (splitData2[i].substring(0, 4).equals(splitData1[j].substring(0, 4))) {
                    total += Integer.parseInt(splitData1[j].substring(5));
                }
            }
            list[i].no = Integer.parseInt(splitData2[i].substring(0, 4));
            list[i].point = total;
            list[i].name = splitData2[i].substring(5);
            if (total >= 4) {
                list[i].best = true;
            }
            list[i].print();
            System.out.println();
        }
    }
}
