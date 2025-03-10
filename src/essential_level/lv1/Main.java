package essential_level.lv1;

import java.util.Scanner;

public class Main {
    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);
        int answer;
        do {
            System.out.println("[   SHAKESHACK MENU   ]");
            System.out.println("1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑 된 치즈버거");
            System.out.println("-----------------------------------------------------------");
            System.out.println("2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑 된 치즈버거");
            System.out.println("-----------------------------------------------------------");
            System.out.println("3. CheeseBurger  | W 8.9 | 포테이토 번과 비프패티, 치즈가 토핑 된 치즈버거");
            System.out.println("-----------------------------------------------------------");
            System.out.println("4. HamBurger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거");
            System.out.println("-----------------------------------------------------------");
            System.out.println("0. 0을 입력하면 종료가 됩니다. | 종료 ");
            System.out.println("-----------------------------------------------------------");
            System.out.print(" 번호를 입력하세요 : ");
            answer = sc.nextInt();

            switch (answer) {
                case 1 :
                    System.out.println("ShackBurger를 선택하셨습니다. \n");
                    break;
                case 2 :
                    System.out.println("SmokeShack를 선택하셨습니다.\n");
                    break;
                case 3 :
                    System.out.println("CheeseBurger를 선택하셨습니다.\n");
                    break;
                case 4 :
                    System.out.println("HamBurger를 선택하셨습니다.\n");
                    break;
                case 0 :
                    break;
                default :
                    System.out.println("번호를 잘못 입력하셨습니다. 다시 입력해주세요. \n");

            }

        } while (answer != 0);

        System.out.println("프로그램을 종료합니다.");
        sc.close();


    }
}
