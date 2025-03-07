package essential_level.lv4_lv5;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    //private String name;
    //private List<MenuItem> menuList;

    // 속성
    private List<MenuItem> drinkList;
    private List<MenuItem> desertList;
    private List<MenuItem> hambergerList;


    // 생성자
    public Menu() {
        // 햄버거 리스트 생성 후 햄버거 메뉴 추가
        hambergerList = new ArrayList<>();
        this.hambergerList = hambergerList;
        hambergerList.add(new MenuItem("ShackBurger ", 6.9, "토마토, 양상추, 쉑소스가 토핑 된 치즈버거    "));
        hambergerList.add(new MenuItem("SmokeShack  ", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑 된 치즈버거 "));
        hambergerList.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑 된 치즈버거"));
        hambergerList.add(new MenuItem("Hamburger   ", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거    "));

        // 음료수 리스트 생성 후 리스트 메뉴 추가
        drinkList = new ArrayList<>();

        // 디져트 리스트 생성 후 리스트 메뉴 추가
        desertList = new ArrayList<>();

    }

    // 기능


    public List<MenuItem> getDrinkList(){
        return drinkList;
    }

    public List<MenuItem> getDesertList() {
        return desertList;
    }

    public List<MenuItem> getHambergerList() {
        return hambergerList;
    }
}
