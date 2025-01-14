package level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 키오스크 프로그램의 메뉴를 관리하고 사용자 입력을 처리
 */
public class Kiosk {
    // MenuItem을 관리하는 리스트
    private final List<MenuItem> menuItems = new ArrayList<>();

    // 클래스 생성자를 통해 값을 할당
    public Kiosk(MenuItem... menuItem) {
        this.menuItems.addAll(Arrays.asList(menuItem));
    }

    /**
     * start(): 프로그램을 시작하는 메서드
     * <p>입력과 반복문 로직 관리</p>
     */
    public void start() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                printMenu(); // 콘솔에 햄버거 메뉴를 출력합니다.
                selectMenu(sc.next());// 사용자의 입력을 받아 메뉴를 선택하거나 프로그램을 종료합니다.
            } catch (IllegalStateException e) {
                // 유효하지 않은 입력에 대해 오류메세지를 출력합니다.
                System.out.println("[입력 오류] " + e.getMessage());
            } catch (Exception e) {
                System.out.println("[알 수 없는 오류] " + e.getMessage());
                e.printStackTrace(System.out);
            }
        }
    }

    /**
     * 사용자의 입력을 받아 메뉴를 선택하거나 프로그램을 종료
     *
     * @param menuIndex
     */
    private void selectMenu(String menuIndex) {
        switch (menuIndex) {
            case "0" -> {
                // 0을 입력하면 프로그램이 '뒤로가기' 되거나 '종료'됩니다.
                System.out.println("프로그램을 종료합니다.");
                System.exit(0);
            }
            case "1" -> printItem(menuItems.get(0));
            case "2" -> printItem(menuItems.get(1));
            case "3" -> printItem(menuItems.get(2));
            case "4" -> printItem(menuItems.get(3));
            default -> throw new IllegalStateException("잘못된 입력입니다 : " + menuIndex);
        }
    }

    private void printItem(MenuItem menuItem) {
        System.out.println("선택한 메뉴: " + menuItem.getName() + ", " + menuItem.getPrice() + ", " + menuItem.getDescription());
    }

    /**
     * 메뉴 리스트 출력
     */
    private void printMenu() {
        System.out.println("[ SHAKESHACK MENU ]");
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println(i + 1 + ". " + menuItems.get(i));
        }
        System.out.printf("0. %-11s | %s%n", "종료", "종료");
    }
}
