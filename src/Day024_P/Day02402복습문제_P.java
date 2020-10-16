package Day024_P;

import java.util.Scanner;

public class Day02402복습문제_P {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // # 회원관리(배열)
        int[] ids = {1111, 2222, 0, 0, 0}; // id에 대한 배열
        int[] pws = {1234, 2345, 0, 0, 0}; // pw에 대한 배열

        int count = 2; // 이미 회원 가입 되어있는 수
        int log = -1; // 현재 로그인 상태 표시 (-1, 비로그인 / ids의 인덱스에 따라 어떤 회원이 로그인 되어있는지 확인)
        int mainMenu; // 메인 메뉴 입력받을 변수 선언

        while (true) { // 메뉴상태 반복문 시작
            System.out.println("[1]회원가입");
            System.out.println("[2]로그인");
            System.out.println("[3]로그아웃");
            System.out.println("[0]종료");

            mainMenu = scanner.nextInt();
            int check = -1; // 중복 확인을 위한 변수

            if (mainMenu == 1) { // 메뉴 1번 회원가입
                if (count == 5) { // count 5 초과시 배열의 범위를 넘어 기입 오류
                    System.out.println("[메세지] 회원인원 초과");
                    continue; // 최상단 반복문 시작으로 이동
                }
                if (log == -1) { // 로그아웃 상태일때 log = -1인 경우
                    System.out.println("[메세지] 가입할 아이디를 입력하세요 (1000 ~ 9999)"); // 임의로 4자리로 받기
                    int myId = scanner.nextInt(); // 가입할 아이디 입력받기
                    // 중복 id 유무 확인
                    for (int i = 0; i < count; i++) {
                        if (ids[i] == myId) {
                            check = i; // -1 외의 값이 입력됨으로 이미 존재하는 아이디 확인 가능
                        }
                    }
                    // 중복 확인 완료 후
                    if (check == -1) { // ids배열 내에 myId와 같은 값이 없는 경우
                        while (true) { // 비밀번호 기입에 대한 오류
                            System.out.println("[메세지] 비밀번호를 입력하세요(1000 ~ 9999)"); // 임의로 4자리 받기
                            int myPw = scanner.nextInt(); // myPw 값 입력받기
                            if (myPw >= 1000 && myPw < 10000) { // 4자리 수 내에 올바르게 기입한 경우
                                System.out.println("[알림] 회원가입이 완료되었습니다");
                                ids[count] = myId; // ids[count]를 통해 앞으로 추가될 공간에 채우기
                                pws[count] = myPw; // 비밀번호 저장 ids와 동일함
                                count++; // 아이디가 성공적으로 기입되어 비밀번호 생성가능함
                                break;
                            } else { // 4자리 외의 다른 수 입력시 (실패)
                                System.out.println("[경고] 비밀번호 기입 오류입니다."); // 경고문 출력 후 재 기입
                            }
                        }
                    } else { // ids배열에 myId와 같은 값이 존재하는 경우
                        System.out.println("[알림] 이미 존재하는 아이디입니다."); // 알림 출력문
                    }
                } else {
                    System.out.println("[메세지]" + ids[log] + " 회원 로그인중.."); // 출력문
                }
            } else if (mainMenu == 2) { // 메뉴 2번 로그인
                if (log == -1) { // 비로그인 상태시
                    System.out.println("[로그인] 아이디를 입력하세요");
                    int myId = scanner.nextInt(); // 나의 아이디 입력받기
                    for (int i = 0; i < count; i++) {
                        if (myId == ids[i]) {
                            check = i;
                        }
                    }
                    if (check != -1) { // 아이디가 존재할 경우
                        while (true) {
                            System.out.println("[로그인] 비밀번호를 입력하세요");
                            int myPw = scanner.nextInt();
                            if (myPw == pws[check]) { // 비밀번호 입력이 옳은 경우
                                System.out.println("[메세지] 로그인 성공");
                                log = check; // 로그인 성공시 check를 이용해 ids의 인덱스 번호 미리 받기
                                break; // 로그인 비밀번호 반복문 탈출
                            } else { // 비밀번호 입력이 다른경우
                                System.out.println("[경고] 비밀번호 기입 오류");
                            }
                        }
                    } else {
                        System.out.println("[알림] 아이디가 존재하지 않습니다");
                    }
                } else { // log를 통해 ids 배열 값 출력
                    System.out.println("[메세지]" + ids[log] + " 회원 로그인중.."); // 출력문
                }
            } else if (mainMenu == 3) { // 메뉴 3번 로그아웃
                if (log != -1) { // 현재 로그인 상태인 경우
                    System.out.println("[메세지] 로그아웃");
                    log = -1; // log = -1 초기화를 통해 비로그인 상태로 전환
                } else { // log = -1인 경우 비로그인 상태
                    System.out.println("[메세지] 로그인을 먼저 해주세요");
                }
            } else if (mainMenu == 0) { // 메뉴 0번 프로그램 종료
                System.out.println("[알림] 프로그램 종료");
                log = -1;
                break; // 메인 반복문 탈출
            }
        }
        scanner.close();
    }
}
