package essential_level.lv4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {


    // 속성
    private Scanner sc;
    private List<Menu> menus;
    private OutputManager outputManager;
    private InputManager inputManager;


    // 생성자
    public Kiosk() {
        sc = new Scanner(System.in);
        menus = new ArrayList<>();
        outputManager = new OutputManager(menus);
        inputManager = new InputManager();

        List<MenuItem> burger = new ArrayList<>();
        burger.add(new MenuItem("ShackBurger ", 6.9, "토마토, 양상추, 쉑소스가 토핑 된 치즈버거    "));
        burger.add(new MenuItem("SmokeShack  ", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑 된 치즈버거 "));
        burger.add(new MenuItem("CheeseBurger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑 된 치즈버거"));
        burger.add(new MenuItem("Hamburger   ", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거    "));
        menus.add(new Menu("Burger", burger));

        List<MenuItem> drink = new ArrayList<>();
        drink.add(new MenuItem("Sprite      ", 0.3, "청량감이 넘치는 시원한 사이다            "));
        drink.add(new MenuItem("Cola        ", 0.3, "청량감이 넘치는 시원한 코카콜라           "));
        drink.add(new MenuItem("Orange Juice", 0.5, "오렌지 과즙이 넘치는 시원한 오렌지 주스    "));
        drink.add(new MenuItem("Tomato Juice", 0.5, "토마토 과즙이 넘치는 달달한 토마토 주스    "));
        menus.add(new Menu("Drink", drink));

        List<MenuItem> dessert = new ArrayList<>();
        dessert.add(new MenuItem("Ice-cream   ", 0.1, "우유 아이스크림                      "));
        dessert.add(new MenuItem("Pie         ", 0.3, "고구마 파이                         "));
        dessert.add(new MenuItem("FrenchFries ", 0.5, "갓 튀긴 감자튀김                     "));
        menus.add(new Menu("Dessert", dessert));

    }


    // 기능

    public void start() {
        int categoryChoice;
        int categoryChoiceDescription;

        do {
            // 메인메뉴 출력
            outputManager.showMainMenu();

            categoryChoice = inputManager.choiceAnswer();
            System.out.println("");

            if (categoryChoice == 0) {
                break;
            } else if (categoryChoice > 0 && categoryChoice <= menus.size()) {

                // 메뉴에 있는 리스트(버거,음료,디져트)에서 사용자가 선택한 카테고리 selectMenu 변수로 설정
                Menu selectedMenu = menus.get(categoryChoice - 1);
                // MenuItem의 리스트(예: 햄버거 치즈버거 등)를 selectedMenu로 고른(예: 햄버거)리스트를 items로 변수 설정
                List<MenuItem> items = selectedMenu.getMenuItems();

                if (categoryChoice == 1 || categoryChoice == 2 || categoryChoice == 3) {
                    System.out.println("[                            " + selectedMenu.getName().toUpperCase() + " MENU                             ]");
                    System.out.println("-----------------------------------------------------------------------");

                    // 선택한 메뉴의 리스트들 출력
                    outputManager.printMenuItems(selectedMenu);

                    System.out.println("| 0. Main Menu로 돌아가기                                                |");
                    System.out.println("-----------------------------------------------------------------------");

                    while (true) {
                        // 선택한 메뉴 리스트 설명 출력
                        categoryChoiceDescription = inputManager.choiceAnswer();

                        if (categoryChoiceDescription == 0) {
                            break;
                        } else if (categoryChoiceDescription >= 1 && categoryChoiceDescription <= items.size()) {
                            outputManager.printMenuSelection(categoryChoiceDescription, items);
                            break;
                        } else {
                            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                        }
                    }
                }
                if (categoryChoice == 4) {

                }
                if (categoryChoice == 5) {

                }

            } else {
                System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
            }

    } while(categoryChoice !=0);
        System.out.println("프로그램을 종료합니다.");
        sc.close();
}


}
