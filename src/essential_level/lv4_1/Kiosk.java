package essential_level.lv4_1;

import java.util.List;
import java.util.Scanner;

public class Kiosk {
    Scanner sc = new Scanner(System.in);
    private Menu menu;


    // 속성


    // 생성자
    public Kiosk () {
        menu = new Menu();
    }


    // 기능

    public void start () {
        int answer1 = -1;
        int answer2 = -1;

        do {
            // 메뉴 출력
            System.out.println("[                          SHAKESHACK MENU                             ]");
            System.out.println("-----------------------------------------------------------------------");

            System.out.println("[                               MAIN MENU                              ]");
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("| 1. Burgers                                                           |");
            System.out.println("| 2. Drinks                                                            |");
            System.out.println("| 3. Desserts                                                          |");
            System.out.println("| 0. 종료                                                               |");
            System.out.println("-----------------------------------------------------------------------");
            // 메인메뉴 번호 입력 시 나오는 것
            while (true) {
                System.out.print("번호를 입력하세요 : ");
                answer1 = sc.nextInt();
                System.out.println("");
                if (answer1 == 0) {
                    break;
                } else if (answer1 > 0 && answer1 <= 3) {
                    if (answer1 == 1) {
                        System.out.println("[                          BURGERS MENU                               ]");
                        System.out.println("-----------------------------------------------------------------------");
                        for (int i = 0; i < menu.getHambergerList().size(); i++) {
                            MenuItem item = menu.getHambergerList().get(i);
                            System.out.println("| " + (i + 1) + ". " + item.getBurgerName() +
                                    "    |  W " + item.getPrice() + "  |  " + item.getDescription() + " |");
                            System.out.println("-----------------------------------------------------------------------");
                        }
                        System.out.println("| 0. Main Menu로 돌아가기                                                |");
                        System.out.println("-----------------------------------------------------------------------");
                        while (true) {
                            System.out.print("번호를 입력하세요 : ");
                            answer2 = sc.nextInt();
                            if (answer2 == 0) {
                                break;
                            } else if (answer2 >= 1 && answer2 <= menu.getHambergerList().size()) {
                                MenuItem selectedItem = menu.getHambergerList().get(answer2 - 1);
                                System.out.println("\n선택한 메뉴: " + selectedItem.getBurgerName());
                                System.out.println("가격: W" + selectedItem.getPrice());
                                System.out.println("설명: " + selectedItem.getDescription() + "\n");
                                break;
                            } else {
                                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                            }
                        }
                    }
                    if (answer1 == 2) {
                        // 드링크 리스트 가져오기
                    }
                    if (answer1 == 3) {
                        // 디져트 리스트 가져오기
                    }
                }
            }
        }while (answer1 != 0) ;
        System.out.println("프로그램을 종료합니다.");
        sc.close();
    }



}
