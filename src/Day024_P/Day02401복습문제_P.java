package Day024_P;

import java.util.Scanner;

public class Day02401복습문제_P {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // # 회원관리(반복문)
        int dbId1 = 1111;
        int dbPw1 = 1234;
        int dbId2 = 2222;
        int dbPw2 = 2345;

        int log = -1;        // 로그아웃(-1), 1번(1), 2번(2)
        int menuChoice; // 메뉴 선택 선언

        while (true) {
            System.out.println("[1]로그인");
            System.out.println("[2]로그아웃");
            System.out.println("[0]종료");
            menuChoice = scanner.nextInt(); // 메뉴 선택 입력받기 (정수형)
            if (menuChoice == 1) { // 로그인[1] 입력시
                if(log == -1) { // 비로그인 상태인 log = -1일 경우에 로그인이 가능하다
                    System.out.println("[로그인] ID를 입력하세요");
                    int myId = scanner.nextInt(); // 나의 아이디 입력받기
                    // log = 1에 대한 경우
                    if (myId == dbId1) { // myId가 dbId1와 같아야 비밀번호 입력가능
                        System.out.println("[로그인] PW를 입력하세요");
                        int myPw = scanner.nextInt(); // 나의 비밀번호 입력받기
                        // myPw가 dbPw1와 같아야 로그인 가능
                        if (myPw == dbPw1) { // myPw 와 dbPw1이 같으면
                            System.out.println("[메세지] 로그인 성공"); // 로그인 성공 메세지 출력
                            log = 1; // 1번 회원으로 로그인
                        } else { // myPw와 dbPw1의 비밀번호가 일치하지 않을경우 (회원 1에대한 비밀번호가 다를경우)
                            System.out.println("[경고] 비밀번호 기입 오류"); // 경고문 출력
//                        continue; // 메인 메뉴로 이동
                        }
                    }
                    // log = 2에 대한 경우
                    else if (myId == dbId2) { // myId가 dbId2와 같은 경우
                        System.out.println("[로그인] PW를 입력하세요");
                        int myPw = scanner.nextInt(); // 나의 비밀번호 입력받기
                        // myPw가 dbPw1와 같아야 로그인 가능
                        if (myPw == dbPw2) { // myPw와 dbPw2의 값이 같은 경우 (회원2에 대한 로그인)
                            System.out.println("[메세지] 로그인 성공"); // 로그인 성공 메세지 출력
                            log = 2; // 2번 회원으로 로그인
                        } else { // 2번 회원에 대한 비밀번호 기입 오류시
                            System.out.println("[경고] 비밀번호 기입 오류");
//                        continue; // 메인 메뉴로 이동
                        }
                    } else { // myId의 값이 dbId1, 2 와 다를경우 메인 메뉴로 이동
                        System.out.println("[경고] ID 기입오류 (메뉴로 이동합니다)");
                    }// 다시 메인 메뉴 선택으로 반복
                }
                // 이미 로그인된 경우 메인 메뉴로 알림 출력 후 이동
                else if (log == 1){//회원 1이 이미 로그인 상태
                    System.out.println("[알림] 회원1이 로그인 중입니다");
                }
                else if (log == 2){//회원 2가 이미 로그인 상태
                    System.out.println("[알림] 회원2가 로그인 중입니다");
                }
            } else if (menuChoice == 2) { // 로그아웃[2] 입력시
                if (log == -1){// 현재 비로그인 상태
                    System.out.println("[알림] 로그인 상태가 아닙니다");
                }
                else if(log == 1 || log == 2) { // 회원이 로그인 상태일때
                    System.out.println("[알림] 로그아웃"); // 로그아웃 출력
                    log = -1; // 비로그인 상태인 log = -1로 초기화 해줘야한다
                }
            }
            else if (menuChoice == 0){ // 메인 메뉴 0 번 선택시 프로그램 종료
                System.out.println("[알림] 프로그램 종료"); // 프로그램 종료 안내문
                break;
            }
        }
        scanner.close(); // 메모리누수 방지
    }
}
