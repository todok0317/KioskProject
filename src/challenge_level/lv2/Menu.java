package challenge_level.lv2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu {

    // 속성
    // name은 왜 선언? 물어보기
    private String name;
    private  Map<String, List<MenuItem>> menuList;


    // 생성자
    public Menu() {
        // 햄버거 리스트 생성 후 햄버거 메뉴 추가
        menuList = new HashMap<>();
        this.menuList = menuList;

        List<MenuItem> hambergerList = new ArrayList<>();
        hambergerList.add( new MenuItem("ShackBurger ", 6.9, "토마토, 양상추, 쉑소스가 토핑 된 치즈버거    "));
        hambergerList.add( new MenuItem("SmokeShack  ", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑 된 치즈버거 "));
        hambergerList.add( new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑 된 치즈버거"));
        hambergerList.add( new MenuItem("Hamburger   ", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거    "));
        menuList.put("Burger",hambergerList);

        List<MenuItem> drinkList = new ArrayList<>();
        drinkList.add( new MenuItem("Sprit       ", 0.3, "청량감이 넘치는 시원한 사이다            "));
        drinkList.add( new MenuItem("Cola        ", 0.3, "청량감이 넘치는 시원한 코카콜라           "));
        drinkList.add( new MenuItem("Orenge Juice", 0.5, "오렌지 과즙이 넘치는 시원한 오렌지 쥬스    "));
        drinkList.add( new MenuItem("Tomato Juice", 0.5, "토마토 과즙이 넘치는 달달한 토마토 쥬스    "));
        menuList.put("Drink",drinkList);

        List<MenuItem> dessertList = new ArrayList<>();
        dessertList.add( new MenuItem("Icecream    ", 0.1, "우유 아이스크림                      "));
        dessertList.add( new MenuItem("Pie         ", 0.3, "고구마 파이                         "));
        menuList.put("Dessert",dessertList);
    }

    // 기능


    public Map<String, List<MenuItem>> getMenuList() {
        return menuList;
    }

}
