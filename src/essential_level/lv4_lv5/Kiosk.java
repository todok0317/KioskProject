package essential_level.lv4_lv5;

import java.util.List;
import java.util.Scanner;

public class Kiosk {
    Scanner sc = new Scanner(System.in);
    private Menu menu;


    // 속성


    // 생성자
    public Kiosk() {
        menu = new Menu();
    }


    // 기능

    public void start() {
        int answer;
        int choice;
        List HamburgerList = menu.getMenuList().get("Burger");
        List DrinkList = menu.getMenuList().get("Drink");
        List DessertList = menu.getMenuList().get("Dessert");

        do {
            // 메뉴 출력
            System.out.println("[                          SHAKESHACK MENU                             ]");
            System.out.println("-----------------------------------------------------------------------");

            System.out.println("[                             MAIN MENU                                ]");
            System.out.println("-----------------------------------------------------------------------");

            for (int i = 0; i < menu.getMenuList().size(); i++) {
                for (String key : menu.getMenuList().keySet()) {
                    System.out.println("| " + (i + 1) + ". " + key + "                                                           |");
                    System.out.println("-----------------------------------------------------------------------");
                    i++;
                }
            }
            System.out.println("| 0. 종료                                                              |");
            System.out.println("-----------------------------------------------------------------------");


            System.out.print("번호를 입력하세요 : ");
            choice = sc.nextInt();


            if (choice == 0) {
                break; // 프로그램 종료
            }
            switch (choice) {
                case 1:
                    do {
                        System.out.println("[                            BERGER MENU                               ]");
                        System.out.println("-----------------------------------------------------------------------");
                        for (int i = 0; i < HamburgerList.size(); i++) {
                            // ((Map<String, Object>)map.get("map")).get("PWD") 여기
                            MenuItem item = menu.getMenuList().get("Berger").get(i);
                            System.out.println("| " + (i + 1) + ". " + item.getName() +
                                    "    |  W " + item.getPrice() + "  |  " + item.getDescription() + " |");
                            System.out.println("-----------------------------------------------------------------------");

                        }
                        System.out.println("| 0. 메인메뉴로 돌아가기  |  돌아가기                                         |");
                        System.out.println("-----------------------------------------------------------------------");

                        System.out.print("번호를 입력하세요 : ");
                        answer = sc.nextInt();

                        if (answer == 0) {
                            break;
                        }

                        if (answer >= 1 && answer <= HamburgerList.size()) {
                            MenuItem selectedItem = menu.getMenuList().get("Berger").get(answer - 1);
                            System.out.println("\n선택한 메뉴: " + selectedItem.getName());
                            System.out.println("가격: W " + selectedItem.getPrice());
                            System.out.println("설명: " + selectedItem.getDescription() + "\n");
                        } else {
                            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                        }
                    } while (true);
                    break;
                // 드링크 메뉴
                case 2:
                    System.out.println("[                            DRINK MENU                                ]");
                    System.out.println("-----------------------------------------------------------------------");
                    for (int i = 0; i < DrinkList.size(); i++) {
                        // ((Map<String, Object>)map.get("map")).get("PWD") 여기
                        MenuItem item = menu.getMenuList().get("Drink").get(i);
                        System.out.println("| " + (i + 1) + ". " + item.getName() +
                                "    |  W " + item.getPrice() + "  |  " + item.getDescription() + " |");
                        System.out.println("-----------------------------------------------------------------------");

                    }
                    System.out.println("| 0. 메인메뉴로 돌아가기  |  돌아가기                                         |");
                    System.out.println("-----------------------------------------------------------------------");
                    break;

                // 디져트 메뉴
                case 3:
                    System.out.println("[                             DESSERT MENU                            ]");
                    System.out.println("-----------------------------------------------------------------------");
                    for (int i = 0; i < DessertList.size(); i++) {
                        // ((Map<String, Object>)map.get("map")).get("PWD") 여기
                        MenuItem item = menu.getMenuList().get("Dessert").get(i);
                        System.out.println("| " + (i + 1) + ". " + item.getName() +
                                "    |  W " + item.getPrice() + "  |  " + item.getDescription() + " |");
                        System.out.println("-----------------------------------------------------------------------");

                    }
                    System.out.println("| 0. 메인메뉴로 돌아가기  |  돌아가기                                         |");
                    System.out.println("-----------------------------------------------------------------------");

                    break;

                default:
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요. - 메인 메뉴");

            }

        } while (choice != 0);

        System.out.println("프로그램을 종료합니다.");
        sc.close();
    }

}
