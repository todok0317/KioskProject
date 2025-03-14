package challenge_level.lv3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {


    // 속성
    private Scanner sc;
    private List<Menu> menus;
    private Cart cart;
    private OutputManager outputManager;
    private InputManager inputManager;


    // 생성자
    public Kiosk() {
        sc = new Scanner(System.in);
        menus = new ArrayList<>();
        cart = new Cart();
        outputManager = new OutputManager(menus);
        inputManager = new InputManager();

        List<MenuItem> burger = new ArrayList<>();
        burger.add(new MenuItem("ShackBurger ", 6.9, "토마토, 양상추, 쉑소스가 토핑 된 치즈버거    "));
        burger.add(new MenuItem("SmokeShack  ", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑 된 치즈버거 "));
        burger.add(new MenuItem("CheeseBurger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑 된 치즈버거"));
        burger.add(new MenuItem("Hamburger   ", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거    "));
        menus.add(new Menu("Burger ", burger));

        List<MenuItem> drink = new ArrayList<>();
        drink.add(new MenuItem("Sprite      ", 0.3, "청량감이 넘치는 시원한 사이다            "));
        drink.add(new MenuItem("Cola        ", 0.3, "청량감이 넘치는 시원한 코카콜라           "));
        drink.add(new MenuItem("Orange Juice", 0.5, "오렌지 과즙이 넘치는 시원한 오렌지 주스    "));
        drink.add(new MenuItem("Tomato Juice", 0.5, "토마토 과즙이 넘치는 달달한 토마토 주스    "));
        menus.add(new Menu("Drink  ", drink));

        List<MenuItem> dessert = new ArrayList<>();
        dessert.add(new MenuItem("Ice-cream   ", 0.1, "우유 아이스크림                      "));
        dessert.add(new MenuItem("Pie         ", 0.3, "고구마 파이                         "));
        dessert.add(new MenuItem("FrenchFries ", 0.5, "갓 튀긴 감자튀김                     "));
        menus.add(new Menu("Dessert", dessert));

        List<MenuItem> alcohol = new ArrayList<>();
        alcohol.add(new MenuItem("Beer        ", 0.4, "시원한 생맥주                        "));
        alcohol.add(new MenuItem("Soju        ", 0.4, "술은 역시 소주!                      "));
        alcohol.add(new MenuItem("HighBall    ", 0.6, "달콤 상콤한 하이볼                    "));
        menus.add(new Menu("Alcohol", alcohol));

    }


    // 기능

    public void start() {
        int categoryChoice;
        int categoryChoiceDescription;
        int cartAddChoice;

        do {
            // 메인메뉴 출력
            outputManager.showMainMenu();

            // 장바구니 Order Menu 출력(장바구니에 아무것도 없으면 출력하지 않음)
            boolean isCartNotEmpty = !cart.getCartItems().isEmpty();
            if (isCartNotEmpty) {
                outputManager.orderMenu();
            }

            // 메인메뉴 번호 출력
            categoryChoice = inputManager.choiceAnswer();
            System.out.println("");

            // 메뉴들이 늘어나도 동적으로 숫자가 변동되고 기능도 변동됩니다.
            // categoryChoice == menus.size() + 1; -> 주문번호
            if (categoryChoice == 0) {
                break;
            }
            else if (categoryChoice >= 1 && categoryChoice <= menus.size()) {

                // 메뉴에 있는 리스트(버거,음료,디져트)에서 사용자가 선택한 카테고리 selectMenu 변수로 설정
                Menu selectedMenu = menus.get(categoryChoice - 1);
                // MenuItem의 리스트(예: 햄버거 치즈버거 등)를 selectedMenu로 고른(예: 햄버거)리스트를 items로 변수 설정
                List<MenuItem> items = selectedMenu.getMenuItems();

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
                System.out.println("");
                System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                System.out.println("| 1. 확인                           | 2. 취소                             |");

                cartAddChoice = inputManager.choiceAnswer();

                if (cartAddChoice == 1) {
                    MenuItem selectedItem = items.get(categoryChoiceDescription - 1);
                    cart.addCart(selectedItem);
                    System.out.println(selectedMenu.getName() + " 이 장바구니에 추가되었습니다.");
                } else if (cartAddChoice == 2) {
                    System.out.println("장바구니에 추가되지 않습니다.");
                } else {
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                }

            }
            else if (categoryChoice == menus.size() + 1) {
                // 예외처리
                if (!isCartNotEmpty) throw new IllegalArgumentException("장바구니가 비어 있습니다. 먼저 상품을 추가해주세요.");
                // 장바구니 아이템 출력
                System.out.println("");
                System.out.println("아래와 같이 주문 하시겠습니까?");
                System.out.println("");
                // 오더리스트 출력
                cart.printCartItems();
                double totalPrice = cart.calculateTotalPrice();
                System.out.println("| 1. 주문                           | 2. 메뉴판                           |");
                int cartOrderChoice = inputManager.choiceAnswer();

                if (cartOrderChoice == 1) {
                    // 할인 유형 출력
                    outputManager.discountUserTypePrint();
                    // 할인유형 선택 번호 입력
                    int discountTypeChoice = inputManager.choiceAnswer();
                    // 할인받은 가격 출력
                    double discoutTotalprice = outputManager.discountTypeCalculator(discountTypeChoice, totalPrice);
                    System.out.println("주문이 완료되었습니다. 금액은 W " + discoutTotalprice + " 입니다.");
                    // 프로그램 종료
                    categoryChoice = 0;
                    break;
                } else if (cartOrderChoice == 2) {
                    continue; // 계속
                } else {
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                }
            }
            else if (categoryChoice == menus.size() + 2) {
                if (!isCartNotEmpty) throw new IllegalArgumentException("장바구니가 비어 있습니다. 먼저 상품을 추가해주세요.");
                System.out.println("메뉴로 돌아갑니다.");
                cart.emptyCart();
                break;
            }
            else {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }


        } while (categoryChoice != 0);
        System.out.println("프로그램을 종료합니다.");
        sc.close();
    }

}
