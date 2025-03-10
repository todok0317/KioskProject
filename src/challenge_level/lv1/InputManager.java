package challenge_level.lv1;

import java.util.Scanner;

public class InputManager {

    // 속성
    private Scanner sc;
    private Menu menu;

    // 생성자
    public InputManager(Scanner sc, Menu menu) {
        this.sc = sc;
        this.menu = menu;
    }


    // 기능

    public int getUserChoice() {
        System.out.print("번호를 입력하세요 : ");
        return sc.nextInt();
    }


}

