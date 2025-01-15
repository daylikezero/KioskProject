package level6;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
    }

    // 장바구니 출력
    private void printCart() {
        for (Map.Entry<MenuItem, Integer> entry : cartItems.entrySet()) {
            MenuItem item = entry.getKey();
            String name = item.getName();
            double price = entry.getValue() * item.getPrice();
            String description = item.getDescription();
            System.out.printf("%-21s | W %.1f | %s%n", name, price, description);
        }
    }

    // 장바구니 총 금액
    private BigDecimal getTotalPrice() {
        return cartItems.entrySet().stream()
                .map(i -> BigDecimal.valueOf(i.getKey().getPrice() * i.getValue()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    // 장바구니 비우기
    private void clearCart() {
        cartItems.clear();
    }

    // 빈 장바구니 여부
    public boolean isEmpty() {
        return cartItems.isEmpty();
    }

    // 장바구니 담기 확인
    public void confirmAdd(String input, MenuItem item) {
        if ("1".equals(input)) {
            addItem(item);
            System.out.println(item.getName() + " 이 장바구니에 추가되었습니다.\n");
        } else if ("2".equals(input)) {
            System.out.println("이전 메뉴로 돌아갑니다.");
        } else {
            throw new IllegalStateException("유효하지 않은 입력입니다. : " + input);
        }
    }

    // 장바구니 주문
    public void orders() {
        Scanner sc = new Scanner(System.in);
        System.out.println("아래와 같이 주문하시겠습니까?");
        System.out.println("\n[ Orders ]");
        printCart();

        System.out.println("\n[ Total ]");
        System.out.println("W " + getTotalPrice() + "\n");

        System.out.printf("1. %-8s 2. %s%n", "주문", "메뉴판");
        String input = sc.next();
        if ("1".equals(input)) {
            System.out.println("주문이 완료되었습니다. 금액은 W " + getTotalPrice() + " 입니다. \n");
            clearCart();
        } else if ("2".equals(input)) {
            System.out.println("메뉴판으로 돌아갑니다.");
        } else {
            throw new IllegalStateException("유효하지 않은 입력입니다. : " + input);
        }
    }

    // 장바구니 진행 주문 취소
    public void cancel() {
        Scanner sc = new Scanner(System.in);
        System.out.println("진행중인 주문을 취소하시겠습니까? (장바구니의 모든 품목이 삭제됩니다.)");
        System.out.printf("1. %-8s 2. %s%n", "주문취소", "메뉴판");
        String input = sc.next();
        if ("1".equals(input)) {
            System.out.println("주문을 취소합니다. 메인 메뉴로 돌아갑니다. \n");
            clearCart();
        } else if ("2".equals(input)) {
            System.out.println("메뉴판으로 돌아갑니다.");
        } else {
            throw new IllegalStateException("유효하지 않은 입력입니다. : " + input);
        }
    }
}

