package level6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * MenuItem 클래스를 관리하는 클래스
 * <p>예를 들어, 버거 메뉴, 음료 메뉴 등 각 카테고리 내에 여러 MenuItem을 포함합니다.</p>
 */
public class Menu {
    // MenuItem 클래스를 List로 관리
    private final List<MenuItem> menuItems = new ArrayList<>();
    private final String categoryName;

    public Menu(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setMenuItems(MenuItem... menuItem) {
        this.menuItems.addAll(Arrays.asList(menuItem));
    }

    // 메뉴 카테고리 이름을 반환하는 메서드
    public String getCategoryName() {
        return categoryName;
    }

    public void printItem(MenuItem menuItem) {
        System.out.println("선택한 메뉴: " + menuItem);
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
    public Optional<MenuItem> selectItem(String itemIndex) {
        if ("0".equals(itemIndex)) {
            return Optional.empty(); // 뒤로가기
        }
        try {
            for (int i = 0; i < menuItems.size(); i++) {
                if (i == Integer.parseInt(itemIndex) - 1) {
                    printItem(menuItems.get(i));
                    return Optional.of(menuItems.get(i));
                }
            }
        } catch (NumberFormatException e) {
            throw new IllegalStateException("유효하지 않은 입력입니다. : " + itemIndex);
        }
        throw new IllegalStateException("유효하지 않은 메뉴 번호입니다. : " + itemIndex);
    }
}
