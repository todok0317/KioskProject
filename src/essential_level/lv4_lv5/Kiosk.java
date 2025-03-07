package essential_level.lv4_lv5;

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
        int answer;
        List HambergerList = menu.getMenuList().get("Berger");

        do {
            // 메뉴 출력
            System.out.println("[                          SHAKESHACK MENU                             ]");
            System.out.println("-----------------------------------------------------------------------");

            System.out.println("[                               MAIN MENU                              ]");
            System.out.println("-----------------------------------------------------------------------");


            for (int i = 0; i < HambergerList.size(); i++) {
                MenuItem item = menu.getMenuList().hambergerList().get(i);
                System.out.println("| " + (i + 1) + ". " + item.getName() +
                        "    |  W " + item.getPrice() + "  |  " + item.getDescription() + " |");
                System.out.println("-----------------------------------------------------------------------");

            }
            System.out.println("| 0. 종료             | 종료                                             |");
            System.out.println("-----------------------------------------------------------------------");
            while (true) {
                System.out.print("번호를 입력하세요 : ");
                answer = sc.nextInt();
                if (answer >= 0 && answer <= 4) {
                    break;
                }
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }

        } while (answer != 0 && (answer < 1 || answer > 4));

        if (answer != 0) {
            MenuItem selectedItem = menu.getHambergerList().get(answer - 1);
            System.out.println("\n선택한 메뉴: " + selectedItem.getName());
            System.out.println("가격: W" + selectedItem.getPrice());
            System.out.println("설명: " + selectedItem.getDescription() + "\n");
        }

        System.out.println("프로그램을 종료합니다.");
        sc.close();
    }



}
