package level4;

import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private final List<Menu> menuList;

    public Kiosk(List<Menu> menuList) {
        this.menuList = menuList;
    }

    // menuList를 반환하는 함수
    public List<Menu> getMenuList() {
        return menuList;
    }

    // 상위 메뉴
    public void start() {
        // 스캐너 선언
        Scanner sc = new Scanner(System.in);
        // 반복문 시작
        while (true) {
            try {
                // List와 Menu 클래스 활용하여 상위 카테고리 메뉴 출력
                printMain();
                // 숫자 입력 받기
                // 입력 받은 숫자가 올바르다면 인덱스로 활용하여 List에 접근하기
                // List<Menu>에 인덱스로 접근하면 Menu만 추출할 수 있겠죠?
                selectMain(sc.next());
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
    private void printMain() {
        System.out.println("[ MAIN MENU ]");
        for (int i = 0; i < menuList.size(); i++) {
            System.out.println(i + 1 + ". " + menuList.get(i).getCategoryName());
        }
        System.out.printf("0. %-7s | %s%n", "종료", "종료");
    }

    // 상위 메뉴 선택 메서드
    private void selectMain(String menuIndex) {
        switch (menuIndex) {
            case "0" -> {
                // 0을 입력하면 프로그램이 '뒤로가기' 되거나 '종료'됩니다.
                System.out.println("프로그램을 종료합니다.");
                System.exit(0);
            }
            case "1" -> selectMenu(menuList.get(0));
            case "2" -> selectMenu(menuList.get(1));
            case "3" -> selectMenu(menuList.get(2));
            default -> throw new IllegalStateException("유효하지 않은 입력입니다. : " + menuIndex);
        }
    }

    // 하위 메뉴
    private void selectMenu(Menu menu) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                // Menu가 가진 List<MenuItem>을 반복문을 활용하여 메뉴 출력
                menu.printSub();
                // 숫자 입력 받기
                // 입력 받은 숫자가 올바르다면 인덱스로 활용해서 Menu가 가지고 있는 List<MenuItem>에 접근하기
                if (menu.selectItem(sc.next())) {
                    return; // 선택 반환값 true: 반복문 종료
                }
            } catch (IllegalStateException e) {
                // 유효하지 않은 입력에 대해 오류메세지를 출력합니다.
                System.out.println("[입력 오류] " + e.getMessage());
            } catch (Exception e) {
                System.out.println("[알 수 없는 오류] " + e.getMessage());
                e.printStackTrace(System.out);
            }
        }
    }
}
