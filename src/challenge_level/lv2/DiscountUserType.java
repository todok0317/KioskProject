package challenge_level.lv2;

public enum DiscountUserType {

    // 속성
    MERITORIOUS_PERSON(0.10),
    SOLDIER(0.05),
    STUDENT(0.03),
    GENERAL(0.00);

    private double discount;

    // 생성자
    DiscountUserType(double discount) {
    this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    public static DiscountUserType fromInput(int input) {
        switch (input) {
            case 1 :
                return MERITORIOUS_PERSON;
            case 2 :
                return SOLDIER;
            case 3 :
                return STUDENT;
            case 4 :
                return GENERAL;
            default :
                throw new IllegalArgumentException("해당 유형이 없습니다. 다시 선택해주세요.");
        }
    }
}

