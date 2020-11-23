package Day049P;

/**
 * 학생정보와 성적이 담긴 데이터이다.
 * student 배열 : id, 주소, 번호
 * score 배열 : 번호, 과목명, 성적
 * <p>
 * 문제) 전체 성적이 1등인 학생의 이름을 출력해보자.
 * 정답) ccc
 */

public class Ex00502학생정보문제 {
    public static void main(String[] args) {
        StudentInfo studentInfo = new StudentInfo();
        studentInfo.mainActor();
    }
}

class StudentInfo {
    String[][] student = {
            {"aaa", "신촌", "1001"},
            {"bbb", "강남", "1002"},
            {"ccc", "대치", "1003"},
            {"ddd", "강동", "1004"}
    };

    String[][] score = {
            {"번호", "과목", "점수"},
            {"1001", "국어", "20"},
            {"1002", "국어", "50"},
            {"1003", "국어", "60"},
            {"1004", "국어", "17"},
            {"1001", "수학", "65"},
            {"1002", "수학", "15"},
            {"1003", "수학", "80"},
            {"1004", "수학", "70"},
            {"1001", "영어", "43"},
            {"1002", "영어", "90"},
            {"1003", "영어", "30"},
            {"1004", "영어", "70"}
    };

    /*
    각각의 총합 점 찾기
     */
    public int totalScore(String student) {
        int total = 0;
        for (int i = 1; i < score.length; i++) {
            if (student.equals(score[i][0])) {
                total += Integer.parseInt(score[i][2]);
            }
        }
        return total;
    }

    /*
    비교하기
     */
    public void checkScore() {
        int maxScore = 0;
        for (int i = 0; i < student.length; i++) {
            if (maxScore < totalScore(student[i][2])) {
                maxScore = totalScore(student[i][2]);
            }
        }
        for (int i = 0; i < student.length; i++) {
            if (maxScore == totalScore(student[i][2])){
                System.out.println("1등 : " + student[i][0]);
            }
        }
    }
    /*
    결과값 출력
     */
    public void mainActor(){
        checkScore();
    }
}
