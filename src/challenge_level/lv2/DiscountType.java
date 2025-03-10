package challenge_level.lv2;

public enum DiscountType {
    // 속성
    VETERAN(0.10),
    SOLDIER(0.05),
    STUDENTS(0.03),
    GENERIC(0.00);

    private double discount;

    // 생성자
    DiscountType(double discount) {
        this.discount = discount;
    }

    // 기능
    public double getDiscount() {
        return discount;
    }

    public static DiscountType fromInput(int input) {
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


}
