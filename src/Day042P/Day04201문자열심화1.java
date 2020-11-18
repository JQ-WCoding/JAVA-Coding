package Day042P;

/**
 * . 학생정보와 성적이 담긴 데이터이다.
 * . student배열 {아이디, 주소, 학번}
 * . score배열 {학번, 국어성적, 수학성적, 영어성적}
 * <p>
 * 문제) 전체 성적이 1등인 학생의 이름을 출력
 * 정답) bbb
 */
public class Day04201문자열심화1 {
    String[][] student = {
            {"aaa", "신촌", "1001"},
            {"bbb", "강남", "1002"},
            {"ccc", "대치", "1003"},
            {"ddd", "강동", "1004"}
    };

    String[][] score = {
            {"1001", "10", "20", "30"},
            {"1002", "100", "60", "60"},
            {"1003", "23", "63", "31"},
            {"1004", "45", "30", "35"},
    };
    /*
    전체 성적 1등을 위해 score[x][1 ~ 3]의 성적 총합이 필요
    student 배열의 학번을 이용해 점수를 참조 가능하도록 설정한다
     */

    /*
    성적의 종합 비교
     */
    public String scoreTotal() {
        // 4명의 종합을 구한다
        int[] total = new int[score.length];

        for (int i = 0; i < score.length; i++) {
            for (int j = 0; j < score[i].length; j++) {
                total[i] += Integer.parseInt(score[i][j]);
            }
        }
        // 최고로 점수가 높은 학생의 인덱스 값을 찾는다
        int highScoreIndex = -1;
        int minNum = 0;
        for (int i = 0; i < total.length; i++) {
            if (minNum < total[i]) {
                minNum = total[i];
                highScoreIndex = i;
            }
        }
        return score[highScoreIndex][0];
    }

    /*
    student 배열에서 학번을 이용해 이름 찾기
     */
    public void findName() {
        int thatIndex = -1;
        for (int i = 0; i < student.length; i++) {
            if (scoreTotal().equals(student[i][2])) {
                thatIndex = i;
            }
        }
        System.out.printf("전체성적이 1등인 학생 : %s 입니다 \n", student[thatIndex][0]);
    }

    public static void main(String[] args) {
        Day04201문자열심화1 whoIsTheBest = new Day04201문자열심화1();
        whoIsTheBest.findName();
    }
}
