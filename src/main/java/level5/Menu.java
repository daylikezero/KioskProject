package level5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * MenuItem 클래스를 관리하는 클래스
 * <p>예를 들어, 버거 메뉴, 음료 메뉴 등 각 카테고리 내에 여러 MenuItem을 포함합니다.</p>
 */
public class Menu {
    // MenuItem 클래스를 List로 관리
    private final List<MenuItem> menuItems = new ArrayList<>();
    private final String categoryName; // 카테고리 이름

    public Menu(String categoryName) {
        this.categoryName = categoryName;
    }

    // menuItems 에 MenuItem 값 할당
    public void setMenuItems(MenuItem... menuItem) {
        this.menuItems.addAll(Arrays.asList(menuItem));
    }

    // 메뉴 카테고리 이름을 반환하는 메서드
    public String getCategoryName() {
        return categoryName;
    }

    // 하위 메뉴 출력 메서드
    public void printSub() {
        System.out.println("[ " + categoryName.toUpperCase() + " MENU ]");
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println(i + 1 + ". " + menuItems.get(i));
        }
        System.out.printf("0. %s%n", "뒤로가기");
    }

    // menuItem 선택 메서드
    public boolean selectItem(String itemIndex) {
        if ("0".equals(itemIndex)) {
            return true; // 뒤로가기
        }
        try {
            for (int i = 0; i < menuItems.size(); i++) {
                if (i == Integer.parseInt(itemIndex) - 1) {
                    // menu.getMenuItems().get(i); 같은 형식으로 하나씩 들어가서 얻어와야 합니다.
                    System.out.println("선택한 메뉴: " + menuItems.get(i));
                    return false;
                }
            }
        } catch (NumberFormatException e) {
            throw new IllegalStateException("유효하지 않은 입력입니다. : " + itemIndex);
        }
        throw new IllegalStateException("유효하지 않은 메뉴 번호입니다. : " + itemIndex);
    }
}
