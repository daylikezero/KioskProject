package level2;

public class MenuItem {
    private final String name; // 이름
    private final Double price; // 가격
    private final String description; // 설명

    public MenuItem(String name, Double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return String.format("%-12s | W %.1f | %s", name, price, description);
    }
}
