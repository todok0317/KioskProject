package essential_level.lv4;

public class MenuItem {

    // 속성 - 이름, 가격, 설명 (캡슐화)
    private String name;
    private double price;
    private String description;

    // 생성자
    public MenuItem ( String name, double price, String description) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    // 기능

    // 게터를 이용하여 이름, 가격, 설명 반환
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }


}
