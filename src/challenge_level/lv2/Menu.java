package challenge_level.lv2;

import java.util.List;

public class Menu {

    // 속성
    private String name;
    private List<MenuItem> menuItems;


    // 생성자
    public Menu(String name, List<MenuItem> menuItems) {
        this.name = name;
        this.menuItems = menuItems;

    }

    public String getName() {
        return name;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    @Override
    public String toString() {
        return name;  // 메뉴 이름만 반환하도록 변경
    }

}
