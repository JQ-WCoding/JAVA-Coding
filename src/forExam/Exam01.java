package forExam;

/**
 * 1 ~ 100까지 더하기
 */
public class Exam01 {
    public static void main(String[] args) {
        ExamMethod01 examMethod01 = new ExamMethod01();
        System.out.println("Answer1 : " + examMethod01.ex01());
        System.out.println();

        examMethod01.ex02();
        System.out.println();

        examMethod01.ex03();
        System.out.println();
    }
}

class ExamMethod01 {
    /**
     * 1 ~ 100 까지 더하기
     */
    public int ex01() {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += (i + 1);
        }
        return sum;
    }

    /**
     * for 문을 이용한 구구단
     */
    public void ex02() {
        int sum;
        System.out.println("Answer2 : ");
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                sum = i * j;
                System.out.print(i + " * " + j + " = " + sum + "\t");
            }
            System.out.println();
        }
    }

    /**
     * 구구단 3단에서 4의 배수 제외하고 표현
     */
    public void ex03() {
        System.out.println("Answer3 : ");
        int sum;
        for (int i = 1; i < 10; i++) {
            sum = 3 * i;
            if (sum % 4 != 0){
                System.out.print("3 * " + i + " = " + sum + "\t");
            }
        }
    }
}
