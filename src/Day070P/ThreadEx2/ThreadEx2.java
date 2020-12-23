package Day070P.ThreadEx2;

class StopWatch extends Thread {
    public String timeText;
    long time = 0L;
    long preTime = 0L;
    boolean play = true;

    @Override
    public void run() {
        preTime = System.currentTimeMillis();
        while (play) {
            try {
                sleep(10);
                time = System.currentTimeMillis() - preTime;

                int m = (int) (time / 1000.0 / 60.0); // 분
                int s = (int) (time % (1000.0 * 60.0) / 1000.0); // 초
                int ms = (int) (time % 1000.0 / 10.0); // 밀리초

                System.out.println(m + " : " + s + " : " + ms);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadEx2 {
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
    }
}
