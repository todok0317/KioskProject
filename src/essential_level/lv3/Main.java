package essential_level.lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        // List 선언 및 초기화
        List<MenuItem> menuItems = new ArrayList<>();

        // 메뉴 항목 추가
        menuItems.add(new MenuItem("ShackBurger ", 6.9, "토마토, 양상추, 쉑소스가 토핑 된 치즈버거    "));
        menuItems.add(new MenuItem("SmokeShack  ", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑 된 치즈버거 "));
        menuItems.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑 된 치즈버거"));
        menuItems.add(new MenuItem("Hamburger   ", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거    "));

        // 사용자 선택 변수
        int answer;

        do {
            // 메뉴 출력
            System.out.println("[   SHAKESHACK MENU   ]");
            System.out.println("---------------------------------------------------------------------");

            for (int i = 0; i < menuItems.size(); i++) {
                MenuItem item = menuItems.get(i);
                System.out.println("| " + (i +1) + ". " + item.getBurgerName() +
                        "    |  W" + item.getPrice() + "  |  " + item.getDescription() + " |");
                System.out.println("---------------------------------------------------------------------");

            }
            System.out.println("| 0. 종료             | 종료                                           |");
            System.out.println("---------------------------------------------------------------------");
            while (true) {
                System.out.print("번호를 입력하세요 : ");
                answer = sc.nextInt();
                if (answer >=0 && answer <= 4) {
                    break;
                }
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }

        } while (answer != 0 && (answer < 1 || answer > 4));

        if (answer != 0) {
            MenuItem selectedItem = menuItems.get(answer - 1);
            System.out.println("\n선택한 메뉴: " + selectedItem.getBurgerName());
            System.out.println("가격: W" + selectedItem.getPrice());
            System.out.println("설명: " + selectedItem.getDescription() + "\n");
        }

        System.out.println("프로그램을 종료합니다.");
        sc.close();


    }
}
