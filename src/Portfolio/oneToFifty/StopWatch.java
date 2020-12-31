package Portfolio.oneToFifty;

import javax.swing.*;

public class StopWatch extends Thread {
    static String timeText;

    long time = 0l, preTime = 0l;
    static boolean play;

    public void run() {
        preTime = System.currentTimeMillis();
        while (play) {
            try {
                // Thread.sleep 0.01초마다 찍기
                sleep(10);
                // time은 처음 시간에서 현재 시간을 뺀 초과 시간을 의미
                time = System.currentTimeMillis() - preTime;
                // 분
                int m = (int) (time / 1000.0 / 60.0);
                // 초
                int s = (int) (time % (1000.0 * 60) / 1000.0);
                // 밀리초
                int ms = (int) (time % 1000 / 10.0);
                // 출력 타이머
                timeText = m + " : " + s + " : " + ms;
                System.out.println(timeText);

                if (!MainPanel.gameStart){
                    MainPanel.time.setText("00 : 00 : 00");
                }else {
                    MainPanel.time.setText(StopWatch.timeText);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
