package level6;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    // menuItem(메뉴명, 가격정보)과 수량을 저장
    final Map<MenuItem, Integer> cartItems = new HashMap<>();

    // 장바구니 담기
    public void addItem(MenuItem item) {
        if (cartItems.containsKey(item)) {
            cartItems.put(item, cartItems.get(item) + 1);
        } else {
            cartItems.put(item, 1);
        }
        System.out.println(item.getName() + " 이 장바구니에 추가되었습니다.");
    }

    // 장바구니 출력
    public void printCart() {
        for (Map.Entry<MenuItem, Integer> entry : cartItems.entrySet()) {
            MenuItem item = entry.getKey();
            String name = item.getName();
            double price = entry.getValue() * item.getPrice();
            String description = item.getDescription();
            System.out.printf("%-21s | W %.1f | %s%n", name, price, description);
        }
    }

    // 장바구니 총 금액
    public double getTotalPrice() {
        return cartItems.entrySet().stream()
                .mapToDouble(i -> i.getKey().getPrice() * i.getValue())
                .sum();
    }

    // 장바구니 비우기
    public void clearCart() {
        cartItems.clear();
    }

    // 빈 장바구니 여부
    public boolean isEmpty() {
        return cartItems.isEmpty();
    }
}
