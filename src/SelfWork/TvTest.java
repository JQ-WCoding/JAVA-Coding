//package SelfWork;
//
//public class TvTest {
//    class Tv { // 왜 static이 필요한가?
//        // 속성 선언
//        String color;
//        boolean power;
//        int channel;
//
//        // 메서드
//        void power() { // 전원 on/off
//            power = !power;
//        }
//
//        void channelUp() { // 채널 위로가기
//            ++channel;
//        }
//
//        void channelDown() { // 채널 아래로가기?
//            --channel;
//        }
//    }
//
//    public static void main(String[] args) { // 메인 문
//        Tv[] tvArr = new Tv[3]; // 새 인스턴스 배열로 선언 총 3개
//        for (int i = 0; i < tvArr.length; i++) {
//            tvArr[i] = new Tv();
//            tvArr[i].channel = i + 10; // 11 12 13으로 선언
//        }
//        for (int i = 0;i<tvArr.length;i++){
//            tvArr[i].channel = channelUp();
//        }
//    }
//}
