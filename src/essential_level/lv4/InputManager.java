package essential_level.lv4;

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
}
