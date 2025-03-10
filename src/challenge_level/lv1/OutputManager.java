package challenge_level.lv1;

import java.util.List;
import java.util.Scanner;

public class OutputManager {

    //  속성
    private Scanner sc;
    private Menu menu;

    // 생성자
    public OutputManager(Scanner sc, Menu menu) {
        this.sc = sc;
        this.menu = menu;
    }

    // 기능
    public void mainMenu() {

        System.out.println("[                          SHAKESHACK MENU                             ]");
        System.out.println("-----------------------------------------------------------------------");

        System.out.println("[                             MAIN MENU                                ]");
        System.out.println("-----------------------------------------------------------------------");

        int i = 1;
        for (String key : menu.getMenuList().keySet()) {
            System.out.println("| " + (i) + ". " + key + "                                                           |");
            System.out.println("-----------------------------------------------------------------------");
            i++;
        }

        System.out.println("| 0. 종료                                                              |");
        System.out.println("-----------------------------------------------------------------------");
    }


    public void showMenu(String category) {
        List<MenuItem> itemList = menu.getMenuList().get(category);

        for(int i = 0; i < itemList.size(); i++) {
            MenuItem item = itemList.get(i);
            System.out.println("| " + (i + 1) + ". " + item.getName() +
                    "    |  W " + item.getPrice() + "  |  " + item.getDescription() + " |");
            System.out.println("-----------------------------------------------------------------------");
        }
        System.out.println("| 0. 메인메뉴로 돌아가기  |  돌아가기                                         |");
        System.out.println("-----------------------------------------------------------------------");


    }

    public void orderMenu() {
        System.out.println("[                            ORDER MENU                                ]");
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("| 4. Orders        | 장바구니를 확인 후 주문합니다.                           |");
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("| 5. Cancel        | 진행 중인 주문을 취소합니다.                            |");
        System.out.println("-----------------------------------------------------------------------");
    }

    public void askToAddToCart() {
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인                2. 취소");
    }

    // 선택한 메뉴 설명기능
    public void showMenuDetails(MenuItem selectedItem) {
        System.out.println("\n선택한 메뉴: " + selectedItem.getName());
        System.out.println("가격: W " + selectedItem.getPrice());
        System.out.println("설명: " + selectedItem.getDescription() + "\n");
    }

}
