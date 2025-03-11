package challenge_level.lv2;

import java.util.Scanner;

public class InputManager {
    // 속성
    private Scanner sc;


    // 생성자
    public InputManager() {
        sc = new Scanner(System.in);
    }



    // 기능
    public int choiceAnswer() {
        System.out.print("번호를 입력하세요 : ");
        return sc.nextInt();
    }

    public double discountTypeCalculator(int discountTypeChoice, double totalprice) {
        switch (discountTypeChoice) {
            case 1 :
                return totalprice * 0.9;
            case 2 :
                return totalprice * 0.95;
            case 3 :
                return totalprice * 0.97;
            case 4 :
                return totalprice * 1.00;
            default :
                throw new IllegalArgumentException("해당 유형이 없습니다. 다시 선택해주세요.");
        }

    }
}
