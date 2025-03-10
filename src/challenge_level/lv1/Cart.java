package challenge_level.lv1;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    // 속성
    private List<MenuItem> cartItems;

    // 생성자
    public Cart() {
        cartItems = new ArrayList<>();

    }

    // 기능

    // 장바구니에 메뉴아이템 담기
    public void addCart (MenuItem item) {
        cartItems.add(item);
    }

    // 장바구니 목록 조회
    public List<MenuItem> getCartItems() {
        return cartItems;
    }

    // 장바구니 비우기
    public void emptyCart() {
        cartItems.clear();
    }

    public void printCartItems() {
        System.out.println("[                            ORDER LIST                                ]");
        // 장바구니가 비어있는지 확인
        if (cartItems.isEmpty()) {
            System.out.println("장바구니에 아이템이 없습니다.");
        } else {
            double totalPrice = 0;

            for (MenuItem item : cartItems) {
                System.out.println("| " + item.getName() + "     | W " + item.getPrice() + " | " + item.getDescription());
                totalPrice += item.getPrice();

            }
                System.out.println("");
                System.out.println("-----------------------------------------------------------------------");
                System.out.println("[                                TOTAL                                 ]");
                System.out.println("| W " + totalPrice);
                System.out.println("");
        }
    }

    public double calculateTotalPrice() {
        double totalPrice = 0;
        for (MenuItem item : cartItems) {
            totalPrice += item.getPrice();
        }
        return totalPrice; // 총 가격 반환
    }

    //
}
