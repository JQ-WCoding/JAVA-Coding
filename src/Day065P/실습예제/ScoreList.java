package Day065P.실습예제;

import java.util.ArrayList;

public class ScoreList {
    private ArrayList<Score> scoreList = new ArrayList<>();

    public ArrayList<Score> getScoreList() {
        return scoreList;
    }

    public void setScoreList(ArrayList<Score> scoreList) {
        this.scoreList = scoreList;
    }

    @Override
    public String toString() {
        String str = "";
        str += "=============================\n";
        str += "번호 이름 java jsp spring 총점 평균 석차 \n";
        str += "=============================\n";

        // 석차 계산
        for (int i = 0; i < scoreList.size() - 1; i++) {
            for (int j = i + 1; j < scoreList.size(); j++) {
                if (scoreList.get(i).getTotal() > scoreList.get(j).getTotal()) {
                    // i번째 총점이 크면 j번째 석차를 증가시킨다
                    scoreList.get(j).setRank(scoreList.get(j).getRank() + 1);
                }
                if (scoreList.get(i).getTotal() < scoreList.get(j).getTotal()) {
                    // j번째 총점이 크면 i번째 석차를 증가시킨다
                    scoreList.get(i).setRank(scoreList.get(i).getRank() + 1);
                }
            }
        }

        for (Score score : scoreList) {
            str += score + "\n";
        }
        str += "================================\n";

        return str;
    }
    // ArrayList에 인수로 넘겨받은 성적을 추가하는 메서드
    public void addScore(Score score) {
        scoreList.add(score);
    }
}
