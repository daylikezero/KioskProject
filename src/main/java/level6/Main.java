package level6;

import java.util.ArrayList;
import java.util.List;

/**
 * <h3>Lv6-1. 장바구니 및 구매하기 기능을 추가하기</h3>
 * <p>
 * 1. 장바구니 생성 및 관리 기능<br>
 * 사용자가 선택한 메뉴를 장바구니에 추가할 수 있는 기능을 제공합니다.<br>
 * 장바구니는 메뉴명, 수량, 가격 정보를 저장하며, 항목을 동적으로 추가 및 조회할 수 있어야 합니다.<br><br>
 * 2. 장바구니 출력 및 금액 계산<br>
 * 사용자가 결제를 시도하기 전에, 장바구니에 담긴 모든 메뉴와 총 금액을 출력합니다.<br><br>
 * 3. 장바구니 담기 기능<br>
 * 메뉴를 클릭하면 장바구니에 추가할 지 물어보고, 입력값에 따라 “추가”, “취소” 처리합니다.<br><br>
 * 4. 주문 기능<br>
 * 합산하여 총 금액을 계산하고, “주문하기”를 누르면 장바구니를 초기화합니다.
 * </p>
 * <hr>
 * <h3>Lv6-2. Enum, 람다 & 스트림을 활용한 주문 및 장바구니 관리 </h3>
 * <p>
 * 1. Enum을 활용한 사용자 유형별 할인율 관리하기<br>
 * 주문 시, 사용자 유형에 맞는 할인율 적용해 총 금액 계산<br><br>
 * 2. 람다 & 스트림을 활용한 장바구니 조회 기능<br>
 * 기존에 생성한 Menu의 MenuItem을 조회 할 때 스트림을 사용하여 출력하도록 수정<br>
 * - 기존 장바구니에서 특정 메뉴 빼기 기능을 통한 스트림 활용<br>
 * - 예시 : 장바구니에 SmokeShack 가 들어 있다면,
 * stream.filter를 활용하여 특정 메뉴 이름을 가진 메뉴 장바구니에서 제거
 * </p>
 */
public class Main {
    public static void main(String[] args) {
        // Menu 객체 생성을 통해 이름 설정 -> 카테고리 이름 설정
        // Menu 클래스 내 있는 List<MenuItem> 에 MenuItem 객체 생성하면서 삽입
        List<MenuItem> menuItems1 = new ArrayList<>(
                List.of(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"),
                        new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"),
                        new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"),
                        new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거")));
        List<MenuItem> menuItems2 = new ArrayList<>(
                List.of(new MenuItem("Shack-made Lemonade", 3.9, "매장에서 직접 만드는 상큼한 레몬에이드"),
                        new MenuItem("Fresh Brewed Iced Tea", 3.4, "직접 유기농 홍차를 우려낸 아이스티"),
                        new MenuItem("Fountain Soda", 2.7, "코카콜라, 코카콜라 제로, 스프라이트, 환타 오렌지, 환타 그레이프"),
                        new MenuItem("Abita Root Beer", 4.4, "청량감 있는 독특한 미국식 무알콜 탄산음료"),
                        new MenuItem("Bottled Water", 1.0, "지리산 암반대수층으로 만든 프리미엄 생수")));
        List<MenuItem> menuItems3 = new ArrayList<>(
                List.of(new MenuItem("Shakes", 5.9, "바닐라, 초콜렛, 솔티드 카라멜, 블랙 & 화이트, 스트로베리, 피넛버터, 커피"),
                        new MenuItem("Cups & Cones", 4.9, "바닐라, 초콜렛, Flavor of the Week"),
                        new MenuItem("Concretes", 5.9, "쉐이크쉑의 쫀득한 커스터드와 다양한 믹스-인의 조합")));

        List<Menu> menuList = new ArrayList<>(
                List.of(new Menu("Buggers", menuItems1),
                        new Menu("Drinks", menuItems2),
                        new Menu("Desserts", menuItems3)));

        // Kiosk 객체 생성
        Kiosk kiosk = new Kiosk(menuList);
        // Kiosk 내 시작하는 함수 호출
        kiosk.start();
    }
}
