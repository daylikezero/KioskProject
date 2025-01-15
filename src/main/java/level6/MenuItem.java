package level6;

public class MenuItem implements Comparable<MenuItem> {
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
        return String.format("%-21s | W %.1f | %s", name, price, description);
    }

    @Override
    public int compareTo(MenuItem o) {
        // 길이 비교
        if (this.name.length() > o.name.length()) {
            return 1;
        } else if (this.name.length() < o.name.length()) {
            return -1;
        } else {
            // 길이가 같으면 사전순
            return this.name.compareTo(o.name);
        }
    }
}
