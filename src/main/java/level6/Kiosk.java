package level6;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Kiosk {
    private final List<Menu> menuList;

    public Kiosk(List<Menu> menuList) {
        this.menuList = menuList;
    }

    // 상위 메뉴
    public void start() {
        // 스캐너 선언
        Scanner sc = new Scanner(System.in);
        Cart cart = new Cart();
        // 반복문 시작
        while (true) {
            try {
                // List와 Menu 클래스 활용하여 상위 카테고리 메뉴 출력
                printMain(cart);
                // 숫자 입력 받기
                // 입력 받은 숫자가 올바르다면 인덱스로 활용하여 List에 접근하기
                // List<Menu>에 인덱스로 접근하면 Menu만 추출할 수 있겠죠?
                selectMain(sc.next(), cart);
            } catch (IllegalStateException e) {
                // 유효하지 않은 입력에 대해 오류메세지를 출력합니다.
                System.out.println("[입력 오류] " + e.getMessage());
            } catch (Exception e) {
                System.out.println("[알 수 없는 오류] " + e.getMessage());
                e.printStackTrace(System.out);
            }
        }
    }

    // 상위 메뉴 출력 메서드
    private void printMain(Cart cart) {
        if(!cart.isEmpty()) {
            System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.\n");
        }
        System.out.println("[ MAIN MENU ]");
        for (int i = 0; i < menuList.size(); i++) {
            System.out.println(i + 1 + ". " + menuList.get(i).getCategoryName());
        }
        System.out.printf("0. %-7s | %s%n", "종료", "종료");

        // 장바구니에 물건이 들어 있으면 아래와 같이 [ ORDER MENU ] 가 추가로 출력됩니다.
        // 만약에 장바구니에 물건이 들어 있지 않다면 [ ORDER MENU ] 가 출력되지 않습니다.
        // 미출력일 때 4,5 번을 누르면 예외를 던저줘야 합니다.
        if (!cart.isEmpty()) {
            System.out.println("\n[ ORDER MENU ]");
            System.out.printf("4. %-8s | %s%n", "Orders", "장바구니를 확인 후 주문합니다.");
            System.out.printf("5. %-8s | %s%n", "Cancel", "진행중인 주문을 취소합니다.");
        }
    }

    // 상위 메뉴 선택 메서드
    private void selectMain(String menuIndex, Cart cart) {
        Menu menu = null;
        if (cart.isEmpty()) {
            switch (menuIndex) {
                case "0" -> {
                    // 0을 입력하면 프로그램이 '뒤로가기' 되거나 '종료'됩니다.
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                }
                case "1" -> menu = menuList.get(0);
                case "2" -> menu = menuList.get(1);
                case "3" -> menu = menuList.get(2);
                default -> throw new IllegalStateException("유효하지 않은 입력입니다. : " + menuIndex);
            }
        } else {
            switch (menuIndex) {
                case "0" -> {
                    // 0을 입력하면 프로그램이 '뒤로가기' 되거나 '종료'됩니다.
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                }
                case "1" -> menu = menuList.get(0);
                case "2" -> menu = menuList.get(1);
                case "3" -> menu = menuList.get(2);
                case "4" -> {
                    orders(cart);
                    return;
                }
                case "5" -> {
                    cancel(cart);
                    return;
                }
                default -> throw new IllegalStateException("유효하지 않은 입력입니다. : " + menuIndex);
            }
        }
        selectMenu(menu, cart);
    }

    // 하위 메뉴
    private void selectMenu(Menu menu, Cart cart) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                // Menu가 가진 List<MenuItem>을 반복문을 활용하여 메뉴 출력
                menu.printSub();
                // 숫자 입력 받기
                // 입력 받은 숫자가 올바르다면 인덱스로 활용해서 Menu가 가지고 있는 List<MenuItem>에 접근하기
                Optional<MenuItem> selectItem = menu.selectItem(sc.next());
                if (selectItem.isEmpty()) {
                    return;
                }
                System.out.printf("%n%s", selectItem.get());
                System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                System.out.printf("1. %-8s 2. %s%n", "확인", "취소");
                confirmAdd(sc.next(), cart, selectItem.get());

            } catch (IllegalStateException e) {
                // 유효하지 않은 입력에 대해 오류메세지를 출력합니다.
                System.out.println("[입력 오류] " + e.getMessage());
            } catch (Exception e) {
                System.out.println("[알 수 없는 오류] " + e.getMessage());
                e.printStackTrace(System.out);
            }
        }
    }

    private void confirmAdd(String input, Cart cart, MenuItem item) {
        if ("1".equals(input)) {
            cart.addItem(item);
            System.out.println(item.getName() + " 이 장바구니에 추가되었습니다.\n");
        } else if ("2".equals(input)) {
            System.out.println("이전 메뉴로 돌아갑니다.");
        } else {
            throw new IllegalStateException("유효하지 않은 입력입니다. : " + input);
        }
    }

    private void orders(Cart cart) {
        Scanner sc = new Scanner(System.in);
        System.out.println("아래와 같이 주문하시겠습니까?");
        System.out.println("\n[ Orders ]");
        cart.printCart();

        System.out.println("\n[ Total ]");
        System.out.println("W " + cart.getTotalPrice() + "\n");

        System.out.printf("1. %-8s 2. %s%n", "주문", "메뉴판");
        String input = sc.next();
        if ("1".equals(input)) {
            System.out.println("주문이 완료되었습니다. 금액은 W " + cart.getTotalPrice() + " 입니다. \n" );
            cart.clearCart();
        } else if ("2".equals(input)) {
            System.out.println("메뉴판으로 돌아갑니다.");
        } else {
            throw new IllegalStateException("유효하지 않은 입력입니다. : " + input);
        }
    }

    private void cancel(Cart cart) {
        Scanner sc = new Scanner(System.in);
        System.out.println("진행중인 주문을 취소하시겠습니까? (장바구니의 모든 품목이 삭제됩니다.)");
        System.out.printf("1. %-8s 2. %s%n", "주문취소", "메뉴판");
        String input = sc.next();
        if ("1".equals(input)) {
            System.out.println("주문을 취소합니다. 메인 메뉴로 돌아갑니다. \n" );
            cart.clearCart();
        } else if ("2".equals(input)) {
            System.out.println("메뉴판으로 돌아갑니다.");
        } else {
            throw new IllegalStateException("유효하지 않은 입력입니다. : " + input);
        }
    }
}

