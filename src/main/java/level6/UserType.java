package level6;

import java.math.BigDecimal;
import java.math.RoundingMode;

public enum UserType {
    VETERAN("국가유공자", 10),
    SOLDIER("군인", 5),
    STUDENT("학생", 3),
    COMMON("일반", 0);

    private final String definition; // 정의
    private final int discountPercent; // 할인율

    UserType(String definition, int discountPercent) {
        this.definition = definition;
        this.discountPercent = discountPercent;
    }

    public String getDefinition() {
        return definition;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    // 사용자 유형의 할인율에 따라 할인된 가격을 계산하는 메서드
    public BigDecimal discount(BigDecimal price) {
        return price.multiply(BigDecimal.valueOf(100 - discountPercent)
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.DOWN))
                .stripTrailingZeros();
    }
}
