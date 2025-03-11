package essential_level.lv4;

import java.util.List;

public class OutputManager {

    // 속성
    private List<Menu> menus;

    // 생성자
    public OutputManager(List<Menu> menus) {
        this.menus = menus;
    }

    // 기능
    public void showMainMenu () {
        System.out.println("[                          SHAKESHACK MENU                             ]");
        System.out.println("-----------------------------------------------------------------------");

        System.out.println("[                               MAIN MENU                              ]");
        System.out.println("-----------------------------------------------------------------------");

        for(int i = 0; i < menus.size(); i++){
            System.out.println("| " + (i+1) + ". " + menus.get(i).getName() + "                                                           |");
            System.out.println("-----------------------------------------------------------------------");
        }
        System.out.println("| 0. 종료                                                               |");
        System.out.println("-----------------------------------------------------------------------");
    }

    public void printMenuItems (Menu selectedMenu) {
        // MenuItem의 리스트(예 햄버거 치즈버거 등)를 selectedMenu로 고른(햄버거)리스트를 items로 변수 설정
        List<MenuItem> items = selectedMenu.getMenuItems();

        for (int i = 0; i < items.size(); i++) {
            MenuItem item = items.get(i);
            System.out.println("| " + (i + 1) + ". " + item.getName() +
                    "    |  W " + item.getPrice() + "  |  " + item.getDescription() + " |");
            System.out.println("-----------------------------------------------------------------------");
        }
    }

    public void printMenuSelection(int categoryChoiceDescription, List<MenuItem> items) {
        MenuItem selectedItem = items.get(categoryChoiceDescription-1);
        System.out.println("\n선택한 메뉴: " + selectedItem.getName());
        System.out.println("가격: W" + selectedItem.getPrice());
        System.out.println("설명: " + selectedItem.getDescription() + "\n");
    }

}
