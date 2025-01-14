package level6;

import java.util.List;

/**
 * Lv5. 캡슐화 적용하기
 * <p>MenuItem, Menu 그리고 Kiosk 클래스의 필드에 직접 접근하지 못하도록 설정합니다.
 * Getter와 Setter 메서드를 사용해 데이터를 관리합니다.</p>
 * <p>
 */
public class Main {
    public static void main(String[] args) {
        // Menu 객체 생성하면서 카테고리 이름 설정
        Menu menu1 = new Menu("Buggers");
        Menu menu2 = new Menu("Drinks");
        Menu menu3 = new Menu("Desserts");
        // Menu 클래스 내 있는 List<MenuItem> 에 MenuItem 객체 생성하면서 삽입
        menu1.setMenuItems(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"),
                new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"),
                new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"),
                new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));
        menu2.setMenuItems(new MenuItem("Shack-made Lemonade", 3.9, "매장에서 직접 만드는 상큼한 레몬에이드"),
                new MenuItem("Fresh Brewed Iced Tea", 3.4, "직접 유기농 홍차를 우려낸 아이스티"),
                new MenuItem("Fountain Soda", 2.7, "코카콜라, 코카콜라 제로, 스프라이트, 환타 오렌지, 환타 그레이프"),
                new MenuItem("Abita Root Beer", 4.4, "청량감 있는 독특한 미국식 무알콜 탄산음료"),
                new MenuItem("Bottled Water", 1.0, "지리산 암반대수층으로 만든 프리미엄 생수"));
        menu3.setMenuItems(new MenuItem("Shakes", 5.9, "바닐라, 초콜렛, 솔티드 카라멜, 블랙 & 화이트, 스트로베리, 피넛버터, 커피"),
                new MenuItem("Cups & Cones", 4.9, "바닐라, 초콜렛, Flavor of the Week"),
                new MenuItem("Concretes", 5.9, "쉐이크쉑의 쫀득한 커스터드와 다양한 믹스-인의 조합"));
        List<Menu> menuList = List.of(menu1, menu2, menu3);

        // Kiosk 객체 생성
        Kiosk kiosk = new Kiosk(menuList);
        // Kiosk 내 시작하는 함수 호출
        kiosk.start();
    }
}
