package level6;

import java.math.BigDecimal;
import java.math.RoundingMode;

public enum UserType {
    VETERAN("1", "국가유공자", 10),
    SOLDIER("2", "군인", 5),
    STUDENT("3", "학생", 3),
    COMMON("4", "일반", 0);

    private final String index; // 순서
    private final String definition; // 정의
    private final int discountPercent; // 할인율

    UserType(String index, String definition, int discountPercent) {
        this.index = index;
        this.definition = definition;
        this.discountPercent = discountPercent;
    }

    public String getDefinition() {
        return definition;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    // index로 조회된 사용자 유형(Enum)을 반환하는 메서드
    public static UserType getUserType(String index) {
        for (UserType userType : UserType.values()) {
            if (userType.index.equals(index)) {
                return userType;
            }
        }
        throw new IllegalStateException("유효하지 않은 입력입니다. : " + index);
    }

    // 사용자 유형의 할인율에 따라 할인된 가격을 계산하는 메서드
    public BigDecimal discount(BigDecimal price) {
        return price.multiply(BigDecimal.valueOf(100 - discountPercent)
                        .divide(BigDecimal.valueOf(100), 2, RoundingMode.DOWN))
                .stripTrailingZeros();
    }
}
