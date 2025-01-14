package level2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Lv2. 객체 지향 설계를 적용해 햄버거 메뉴를 클래스로 관리하기
 * <p>객체 지향 개념을 학습하고, 데이터를 구조적으로 관리하며 프로그램을 설계하는 방법을 익힙니다.
 * 햄버거 메뉴를 MenuItem 클래스와 List를 통해 관리합니다.</p>
 * <p>
 * 1. MenuItem 클래스 생성하기<br>
 * - 설명 : 개별 음식 항목을 관리하는 클래스입니다. 현재는 햄버거만 관리합니다.<br>
 * - 클래스는 이름, 가격, 설명 필드를 갖습니다.<br><br>
 * 2. main 함수에서 MenuItem 클래스를 활용하여 햄버거 메뉴를 출력합니다.<br>
 * - MenuItem 객체 생성을 통해 이름, 가격, 설명을 세팅합니다.<br>
 * - 키워드: new <br><br>
 * 3. List를 선언하여 여러 MenuItem을 추가합니다.<br>
 * - List<MenuItem> menuItems = new ArrayList<>();<br><br>
 * 4. 반복문을 활용해 menuItems를 탐색하면서 하나씩 접근합니다.
 */
public class Main {
    public static void main(String[] args) {
        // List 선언 및 초기화
        List<MenuItem> menuItems = new ArrayList<>();
        // add 함수를 통해 new MenuItem(이름, 가격, 설명) List에 삽입 -> List.of()로 대체 가능
        menuItems.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        // Scanner 선언
        Scanner sc = new Scanner(System.in);
        while (true) {
            // 반복문을 활용해 List 안에 있는 MenuItem을 하나씩 출력
            System.out.println("[ SHAKESHACK MENU ]");
            for (int i = 0; i < menuItems.size(); i++) {
                System.out.println(i + 1 + ". " + menuItems.get(i));
            }
            System.out.printf("0. %-11s | %s%n", "종료", "종료");

            // 숫자를 입력 받기
            MenuItem select;
            // 입력한 숫자에 따른 처리
            switch (sc.nextInt()) {
                case 0 -> {
                    // 프로그램을 종료
                    System.out.println("프로그램을 종료합니다.");
                    return;
                }
                case 1 -> select = menuItems.get(0);
                case 2 -> select = menuItems.get(1);
                case 3 -> select = menuItems.get(2);
                case 4 -> select = menuItems.get(3);
                default -> {
                    System.out.println("잘못된 입력입니다.");
                    continue;
                }
            }
            // 선택한 메뉴 : 이름, 가격, 설명
            System.out.println("선택한 메뉴 :" + select.getName() + ", " + select.getPrice() + ", " + select.getDescription());
        }
    }
}
