package challenge_level.lv3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cart {

    // 속성
    private List<MenuItem> cartItems;

    // 생성자
    public Cart() {
        cartItems = new ArrayList<>();

    }

    // 기능

    // 장바구니에 메뉴아이템 담기
    public void addCart(MenuItem item) {
        cartItems.add(item);
    }

    // 게터
    public List<MenuItem> getCartItems() {
        return cartItems;
    }

    // 장바구니 비우기
    public void emptyCart() {
        cartItems.clear();
    }

    // 특정메뉴 삭제기능
    public void removeCartItem (String itemName) {
        cartItems = cartItems.stream()
                .filter(item -> !item.getName().equalsIgnoreCase(itemName))
                .collect(Collectors.toList());
    }

    // 장바구니 아이템 리스트 출력
    public void printCartItems() {
        System.out.println("[                            ORDER LIST                                ]");

        // 장바구니 비어있는지 확인
        if (cartItems.isEmpty()) {
            System.out.println("장바구니에 아이템이 없습니다.");
        } else {
            double totalPrice = cartItems.stream()
                    .mapToDouble(MenuItem::getPrice)
                    .sum();

//            for (MenuItem item : cartItems) {
//                System.out.println("| " + item.getName() + "     | W " + item.getPrice() + " | " + item.getDescription());
//                totalPrice += item.getPrice();
//
//            }

            // for문을 스트림 람다식으로 구현
            cartItems.forEach(item ->
                    System.out.println("| " + item.getName() + "     | W " + item.getPrice() + " | " + item.getDescription()));

            System.out.println("");
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("[                                TOTAL                                 ]");
            System.out.println("| W " + totalPrice);
            System.out.println("");
        }
    }

    public double calculateTotalPrice() {
        double totalPrice = 0;
        for(MenuItem item : cartItems) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }




}
