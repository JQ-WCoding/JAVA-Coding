package Day069P.Day06905ZombieGame;

import java.util.Random;
import java.util.Scanner;

public class ZombieGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        Hero hero = new Hero(1, 200, 20, 5);
        Zombie zombie = new Zombie(5, 100, 10);
        Boss boss = new Boss(9, 300, 20, 100);

        int position = 1;
        hero.setPosition(position);

        boolean run = false;
        while (true) {
            if (run) {
                break;
            }

            System.out.println("현재 위치 = " + position);

            System.out.println("(1) 이동 (2) 종료");
            int move = scanner.nextInt();

            if (move == 1) {
                position++;
                hero.setPosition(position);

                if (hero.getPosition() == 5) {
                    System.out.println("[좀비]를 만났습니다. 공격모드로 바뀝니다.");

                    while (true) {
                        System.out.println("(1) 공격 (2) 포션마시기");
                        int choice = scanner.nextInt();

                        if (choice == 1) {
                            zombie.attack(hero);

                            hero.attack(zombie);
                        } else if (choice == 2) {
                            hero.recovery();
                        }

                        if (hero.getHp() <= 0) {
                            run = true;
                            System.out.println("[히어로]가 죽었습니다. 게임에서 졌습니다.");
                            break;
                        }

                        if (zombie.getHp() <= 0) {
                            System.out.println("[좀비]를 이겼습니다. 이동할 수 있습니다.");
                            break;
                        }
                    }
                }
                if (hero.getPosition() == 9) {
                    System.out.println("[보스]를 만났습니다. 공격모드로 바뀝니다.");

                    while (true) {
                        System.out.println("(1) 공격 (2) 포션마시기");
                        int choice = scanner.nextInt();

                        if (choice == 1) {
                            boss.attack(hero);

                            hero.attack(boss);
                        } else if (choice == 2) {
                            hero.recovery();
                        }
                        if (hero.getHp() <= 0) {
                            run = true;
                            System.out.println("[히어로]가 죽었습니다. 게임에서 졌습니다.");
                            break;
                        }
                        if (boss.getHp() <= 0) {
                            System.out.println("[보스]를 이겼습니다. 이동할 수 있습니다.");
                            break;
                        }
                    }
                }
                if (hero.getPosition() == 10) {
                    System.out.println("[공주]를 만났습니다. 훌륭합니다.");
                    System.out.println("게임을 종료합니다.");
                    break;
                }
            } else if (move == 2) {
                break;
            }
        }
    }
}
