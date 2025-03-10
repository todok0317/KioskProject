package challenge_level.lv2;

import java.util.function.Function;

public enum DiscountType {
    // 속성
    VETERAN(0.10, price -> price * 0.9),
    SOLDIER(0.05, price -> price * 0.95),
    STUDENTS(0.03, price -> price * 0.97),
    GENERIC(0.00, price -> price * 1.00);

    private final double discount;
    private final Function<Double, Double> discountFunction;

    // 생성자
    DiscountType(double discount, Function<Double, Double> discountFunction) {
        this.discount = discount;
        this.discountFunction = discountFunction;
    }

    // 기능
    public double getDiscount() {
        return discount;
    }

    public static DiscountType fromInput (int input) {
            switch (input) {
                case 1 :
                    return VETERAN;
                case 2 :
                    return SOLDIER;
                case 3 :
                    return STUDENTS;
                case 4 :
                    return GENERIC;
                default :
                    throw new IllegalArgumentException("해당 유형이 없습니다. 다시 선택해주세요.");
            }

    }
    // 할인율 적용
    public double applyDiscount(double price) {
        return discountFunction.apply(price);
    }



}
