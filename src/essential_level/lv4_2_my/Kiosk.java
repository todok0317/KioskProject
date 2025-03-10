package essential_level.lv4_2_my;

import java.util.List;
import java.util.Scanner;

public class Kiosk {
    Scanner sc = new Scanner(System.in);
    //속성
    private Menu menu;

    // 생성자
    public Kiosk() {
        menu = new Menu();
    }


    // 기능

    public void start() {
        int first_answer;
        int second_answer;
        int third_anwer;
        int choice;
        List<MenuItem> HamburgerList = menu.getMenuList().get("Burger");
        List<MenuItem> DrinkList = menu.getMenuList().get("Drink");
        List<MenuItem> DessertList = menu.getMenuList().get("Dessert");


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
            System.out.println("");


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
                            MenuItem item = menu.getMenuList().get("Burger").get(i);
                            System.out.println("| " + (i + 1) + ". " + item.getName() +
                                    "    |  W " + item.getPrice() + "  |  " + item.getDescription() + " |");
                            System.out.println("-----------------------------------------------------------------------");

                        }
                        System.out.println("| 0. 메인메뉴로 돌아가기  |  돌아가기                                         |");
                        System.out.println("-----------------------------------------------------------------------");

                        System.out.print("번호를 입력하세요 : ");
                        first_answer = sc.nextInt();
                        System.out.println("");

                        if (first_answer == 0) {
                            break;
                        }

                        if (first_answer >= 1 && first_answer <= HamburgerList.size()) {
                            MenuItem selectedItem = menu.getMenuList().get("Burger").get(first_answer - 1);
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
                    do {


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

                        System.out.print("번호를 입력하세요 : ");
                        second_answer = sc.nextInt();
                        System.out.println("");

                        if (second_answer == 0) {
                            break;
                        }

                        if (second_answer >= 1 && second_answer <= DrinkList.size()) {
                            MenuItem selectedItem = menu.getMenuList().get("Drink").get(second_answer - 1);
                            System.out.println("\n선택한 메뉴: " + selectedItem.getName());
                            System.out.println("가격: W " + selectedItem.getPrice());
                            System.out.println("설명: " + selectedItem.getDescription() + "\n");
                        } else {
                            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                        }

                    } while (true);
                    break;

                // 디져트 메뉴
                case 3:
                    do {
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

                        System.out.print("번호를 입력하세요 : ");
                        third_anwer = sc.nextInt();
                        System.out.println("");

                        if (third_anwer == 0) {
                            break;
                        }

                        if (third_anwer >= 1 && third_anwer <= DessertList.size()) {
                            MenuItem selectedItem = menu.getMenuList().get("Dessert").get(third_anwer - 1);
                            System.out.println("\n선택한 메뉴: " + selectedItem.getName());
                            System.out.println("가격: W " + selectedItem.getPrice());
                            System.out.println("설명: " + selectedItem.getDescription() + "\n");
                        } else {
                            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                        }

                    } while (true);
                    break;

                default:
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요. - 메인 메뉴");

            }

        } while (choice != 0);

        System.out.println("프로그램을 종료합니다.");
        sc.close();
    }

}
