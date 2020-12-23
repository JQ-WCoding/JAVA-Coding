package Day070P.ThreadEx;

/**
 * # 쓰레드
 * 1. 원래 프로그램 이외의 별도로 동작하는 프로그램을 의미한다.
 * 2. 채팅, 로딩화면, 배경음악, 스톱워치 등에 쓰이며 메인 프로그램에 방해받지 않고 독립적으로 작동
 * 3. 완전히 독립적이므로 순서는 조금 달라질 수 있다.
 * <p>
 * # 쓰레드 사용법
 * 1. Thread를 상속받는 클래스를 작성한다.
 * 2. Thread를 상속받은 클래스는 run() 메서드를 구현한다.
 * 3. start() 메서드로 실행시킨다.
 * start() 메서드는 가실행 후, run() 메서드를 호출한다.
 */
class BGMPlay extends Thread {
    boolean play = true;

    @Override
    public void run() {
        while (play) {
            System.out.println("배경 음악이 연주되는 중....");
            try {
                Thread.sleep(500); // 0.5초
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadEx {
    public static void main(String[] args) {
        BGMPlay bgmPlay = new BGMPlay();
        bgmPlay.start();

        for (int i = 0; i <= 10; i++) {
            System.out.println("신나게 게임을 하는 중...");

            if (i == 8) {
                System.out.println("엄크..");
                System.out.println("게임을 종료합니다 ㅜㅜ");

                bgmPlay.play = false;
                break;
            }
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
