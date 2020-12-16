package Day065P.실습예제;

public class Main {
    public static void main(String[] args) {
        ScoreList scoreList = new ScoreList();

        scoreList.addScore(new Score("홍길동", 100, 100, 99));
        scoreList.addScore(new Score("임꺽정", 88, 75, 91));
        scoreList.addScore(new Score("장길산", 65, 74, 69));
        scoreList.addScore(new Score("일지매", 85, 78, 91));
        scoreList.addScore(new Score("이몽룡", 89, 58, 73));

        System.out.println(scoreList);
    }
}
