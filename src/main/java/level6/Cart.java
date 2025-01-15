package level6;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

import static level6.UserType.*;

public class Cart {
    // menuItem(메뉴명, 가격정보)과 수량을 저장
    final Map<MenuItem, Integer> cartItems = new LinkedHashMap<>();

    // 장바구니 담기
    public void addItem(MenuItem item) {
        if (cartItems.containsKey(item)) {
            cartItems.put(item, cartItems.get(item) + 1);
        } else {
            cartItems.put(item, 1);
        }
    }

    // 장바구니 삭제
    private boolean removeItem(String name) {
        return cartItems.keySet().removeIf(item -> item.getName().equals(name));
    }

    // 장바구니 출력
    private void printCart() {
        // Map의 경우 stream을 사용하지 않고 Map.forEach((K,V))로 entry를 순회할 수 있다.
        cartItems.forEach((key, value) -> System.out.printf("%-21s | W %4.1f | %s%n",
                key.getName(),
                BigDecimal.valueOf(value * key.getPrice()),
                key.getDescription()));
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
            BigDecimal discountPrice = selectDiscount(getTotalPrice());
            System.out.println("주문이 완료되었습니다. 금액은 W " + discountPrice + " 입니다. \n");
            clearCart();
        } else if ("2".equals(input)) {
            System.out.println("메뉴판으로 돌아갑니다.");
        } else {
            throw new IllegalStateException("유효하지 않은 입력입니다. : " + input);
        }
    }

    // 사용자 유형에 맞는 할인율 적용하여 총 금액 계산
    private BigDecimal selectDiscount(BigDecimal totalPrice) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n할인 정보를 입력해주세요.");
        for (int i = 0; i < UserType.values().length; i++) {
            System.out.printf(i + 1 + ". %-6s : %3d%%%n"
                    , UserType.values()[i].getDefinition()
                    , UserType.values()[i].getDiscountPercent());
        }
        String input = sc.next();
        return switch (input) {
            case "1" -> VETERAN.discount(totalPrice);
            case "2" -> SOLDIER.discount(totalPrice);
            case "3" -> STUDENT.discount(totalPrice);
            case "4" -> COMMON.discount(totalPrice);
            default -> throw new IllegalStateException("유효하지 않은 입력입니다. : " + input);
        };
    }

    // 장바구니 진행 주문 취소
    public void cancel() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n진행중인 주문을 취소하시겠습니까? (장바구니의 모든 품목이 삭제됩니다.)");
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

    // 장바구니 특정 메뉴 삭제
    public void remove() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n[ Orders ]");
        printCart();

        System.out.println("\n장바구니 목록 중 특정 메뉴를 삭제하시겠습니까?");
        System.out.printf("1. %-8s 2. %s%n", "메뉴 삭제", "메뉴판");
        String input = sc.next();
        if ("1".equals(input)) {
            filterByName(sc);
        } else if ("2".equals(input)) {
            System.out.println("메뉴판으로 돌아갑니다.");
        } else {
            throw new IllegalStateException("유효하지 않은 입력입니다. : " + input);
        }
    }

    private void filterByName(Scanner sc) {
        System.out.println("삭제할 메뉴를 입력하세요");
        String input = sc.next();
        if (removeItem(input)) {
            System.out.println("해당 메뉴가 삭제되었습니다.");
        } else {
            throw new IllegalStateException("유효하지 않은 입력입니다. : " + input);
        }
    }
}

