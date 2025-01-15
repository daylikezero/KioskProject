package level6;

import java.math.BigDecimal;
import java.math.RoundingMode;

public enum UserType {
    VETERAN("국가유공자", 10),
    SOLDIER("군인", 5),
    STUDENT("학생", 3),
    COMMON("일반", 0);

    private final String definition;
    private final int discountPercent;

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

    public BigDecimal discount(BigDecimal price) {
        return price.multiply(BigDecimal.valueOf(100 - discountPercent)
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.DOWN))
                .stripTrailingZeros();
    }
}
