package level1;

import java.util.Scanner;

/**
 * Lv1. 기본적인 키오스크를 프로그래밍해보자
 * <p>입력처리와 간단한 흐름 제어를 복습합니다.
 * Scanner 활용법, 조건문, 반복문을 제확인하며 입력 데이터를 처리하는 방법 강화</p>
 * <p>
 * 1. 햄버거 메뉴 출력 및 선택하기<br>
 * - Scanner를 사용하여 여러 햄버거 메뉴를 출력합니다.<br>
 * - 제시된 메뉴 중 입력받은 숫자에 따라 다른 로직을 실행하는 코드를 작성합니다.<br>
 * - 반복문을 이용해서 특정 번호가 입력되면 프로그램을 종료합니다.<br>
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] menu = {
                "ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거",
                "SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거",
                "Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거",
                "Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거"
        };
        while (true) {
            // 출력
            System.out.println("[ SHAKESHACK MENU ]");
            for (int i = 0; i < menu.length; i++) {
                System.out.println(i + 1 + ". " + menu[i]);
            }
            System.out.println("0. 종료      | 종료");

            // 입력
            // 제시 된 메뉴 중 입력받은 숫자에 따라 다른 로직을 실행하는 코드를 작성합니다.
            String select;
            switch (sc.nextInt()) {
                case 1:
                    select = menu[0];
                    break;
                case 2:
                    select = menu[1];
                    break;
                case 3:
                    select = menu[2];
                    break;
                case 4:
                    select = menu[3];
                    break;
                case 0:
                    // 반복문을 이용해서 특정 번호가 입력되면 프로그램을 종료합니다.
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 입력입니다.");
                    continue;
            }
            System.out.println("선택한 메뉴: " + select);
        }
    }
}
