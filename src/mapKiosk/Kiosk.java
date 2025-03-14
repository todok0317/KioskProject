package mapKiosk;

import java.util.List;
import java.util.Scanner;

public class Kiosk {

    //속성
    private Scanner sc;
    private Menu menu;
    private Cart cart;
    private InputManager inputManager;
    private OutputManager outputManager;


    // 생성자
    public Kiosk() {
        sc = new Scanner(System.in);
        menu = new Menu();
        cart = new Cart();
        inputManager = new InputManager(sc, menu);
        outputManager = new OutputManager(sc, menu);
    }


    // 기능
    public void start() {
        int first_answer;
        int second_answer;
        int third_answer;
        int choice = -1;
        int cartAnswer;
        int LastOrderAnswer;
        List<MenuItem> HamburgerList = menu.getMenuList().get("Burger");
        List<MenuItem> DrinkList = menu.getMenuList().get("Drink");
        List<MenuItem> DessertList = menu.getMenuList().get("Dessert");


        do {
            // 메뉴 출력
            outputManager.mainMenu();

            // 오더 메뉴 출력
            boolean isCartNotEmpty = !cart.getCartItems().isEmpty();
            if ( isCartNotEmpty) {
                outputManager.orderMenu();
            }

            choice = inputManager.getUserChoice();
            sc.nextLine();

            switch (choice) {

                case 0 :
                    break; // 프로그램 종료

                case 1: // 햄버거 메뉴
                    do {
                        System.out.println("[                            BERGER MENU                               ]");
                        System.out.println("-----------------------------------------------------------------------");

                        outputManager.showMenu("Burger");
                        first_answer = inputManager.getUserChoice();
                        sc.nextLine();

                        if (first_answer == 0) {
                            break;
                        }

                        // 선택한 메뉴 설명 부분
                        if (first_answer >= 1 && first_answer <= HamburgerList.size()) {
                            MenuItem selectedItem = menu.getMenuList().get("Burger").get(first_answer - 1);
                            // 선택한 메뉴 설명 기능
                            outputManager.showMenuDetails(selectedItem);

                            // 장바구니 넣는 기능
                            outputManager.askToAddToCart();
                            cartAnswer = inputManager.getUserChoice();
                            sc.nextLine();

                            switch (cartAnswer) {
                                case 1 :
                                    cart.addCart(selectedItem);
                                    System.out.println(selectedItem.getName() + "이 장바구니에 추가되었습니다.");
                                    break;
                                case 2 :
                                    System.out.println("장바구니에 넣지 않겠습니다.");
                                    break;
                                default : System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                            }
                        } else {
                            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                        }
                        break;
                    } while (true);
                    break;

                // 드링크 메뉴
                case 2:
                    do {
                        System.out.println("[                            DRINK MENU                                ]");
                        System.out.println("-----------------------------------------------------------------------");
                        // Drink 메뉴 리스트
                        outputManager.showMenu("Drink");
                        second_answer = inputManager.getUserChoice();
                        sc.nextLine();

                        if (second_answer == 0) {
                            break;
                        }

                        if (second_answer >= 1 && second_answer <= DrinkList.size()) {
                            MenuItem selectedItem = menu.getMenuList().get("Drink").get(second_answer - 1);
                            // 선택한 메뉴 설명 기능
                            outputManager.showMenuDetails(selectedItem);

                            // 장바구니 넣는 기능
                            outputManager.askToAddToCart();
                            cartAnswer = inputManager.getUserChoice();
                            sc.nextLine();

                            switch (cartAnswer) {
                                case 1 :
                                    cart.addCart(selectedItem);
                                    System.out.println(selectedItem.getName() + "이 장바구니에 추가되었습니다.");
                                    break;
                                case 2 :
                                    System.out.println("장바구니에 넣지 않겠습니다.");
                                    break;
                                default :
                                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                            }
                        } else {
                            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                        }
                    break;
                    } while (true);
                    break;

                // 디져트 메뉴
                case 3:
                    do {
                        System.out.println("[                             DESSERT MENU                            ]");
                        System.out.println("-----------------------------------------------------------------------");

                        outputManager.showMenu("Dessert");
                        third_answer = inputManager.getUserChoice();
                        sc.nextLine();

                        if (third_answer == 0) {
                            break;
                        }

                        if (third_answer >= 1 && third_answer <= DessertList.size()) {
                            MenuItem selectedItem = menu.getMenuList().get("Dessert").get(third_answer - 1);
                            // 선택한 메뉴 설명 기능
                            outputManager.showMenuDetails(selectedItem);

                            // 장바구니 넣는 기능
                            outputManager.askToAddToCart();
                            cartAnswer = inputManager.getUserChoice();
                            sc.nextLine();

                            switch (cartAnswer) {
                                case 1 :
                                    cart.addCart(selectedItem);
                                    System.out.println(selectedItem.getName() + "이 장바구니에 추가되었습니다.");
                                    break;
                                case 2 :
                                    System.out.println("장바구니에 넣지 않겠습니다.");
                                    break;
                            }
                        } else {
                            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                        }
                        break;
                    } while (true);
                    break;

                case 4:
                    // 예외처리
                    if(!isCartNotEmpty) throw new IllegalArgumentException("장바구니가 비어 있습니다. 먼저 상품을 추가해주세요.");

                    // 장바구니 아이템 출력
                    System.out.println("");
                    System.out.println("아래와 같이 주문 하시겠습니까?");
                    System.out.println("");
                    cart.printCartItems();
                    double totalPrice = cart.calculateTotalPrice();
                    System.out.println("| 1. 주문                           | 2. 메뉴판                           |");
                    LastOrderAnswer = inputManager.getUserChoice();
                    sc.nextLine();

                    if(LastOrderAnswer == 1) {
                        System.out.println("주문이 완료되었습니다. 금액은 W " + totalPrice + "입니다.");
                    } else if (LastOrderAnswer == 2) {
                        continue;
                    } else {
                        System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                    }
                    choice = 0;
                    break;

                case 5 :
                    //예외처리
                    if(!isCartNotEmpty) throw new IllegalArgumentException("장바구니가 비어 있습니다. 먼저 상품을 추가해주세요.");

                    System.out.println("메뉴로 돌아갑니다.");
                    cart.emptyCart();
                    break;

                default:
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }

        } while (choice != 0);

        System.out.println("프로그램을 종료합니다.");
        sc.close();
    }

}
