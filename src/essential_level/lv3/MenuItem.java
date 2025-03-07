package essential_level.lv2;

import java.util.ArrayList;

public class MenuItem {

    // 속성 - 이름, 가격, 설명 (캡슐화)
    private String burgerName;
    private double price;
    private String description;

    // 생성자
    public MenuItem ( String burgerName, double price, String description) {
        this.burgerName = burgerName;
        this.description = description;
        this.price = price;
    }

    // 기능

    // 게터를 이용하여 버거이름, 가격, 설명 반환
    public String getBurgerName() {
        return burgerName;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }


}
