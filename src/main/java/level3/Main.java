package level3;

/**
 * Lv3. 객체 지향 설계를 적용해 순서 제어를 클래스로 관리하기
 * <p>객체 지향 개념을 학습하고, 데이터를 구조적으로 관리하며 프로그램을 설계하는 방법을 익힙니다.
 * main 함수에서 관리하던 전체 순서 제어를 Kiosk 클래스를 통해 관리합니다.</p>
 * <p>
 * 1. Kiosk 클래스 생성하기<br>
 * - 설명: 키오스크 프로그램의 메뉴를 관리하고 사용자 입력을 처리하는 클래스입니다.<br>
 * - MenuItem을 관리하는 리스트가 필드로 존재합니다.<br>
 * - main 함수에서 관리하던 입력과 반복문 로직은 이제 start 함수를 만들어 관리합니다.<br>
 * - List<MenuItem> menuItems 는 Kiosk 클래스 생성자를 통해 값을 할당합니다.<br>
 * - Kiosk 객체를 생성하고 사용하는 main 함수에서 객체를 생성할 때 값을 넘겨줍니다.<br><br>
 * 2. 키오스크 프로그램을 시작하는 메서드가 구현되어야 합니다.<br>
 * - 콘솔에 햄버거 메뉴를 출력합니다.<br>
 * - 사용자의 입력을 받아 메뉴를 선택하거나 프로그램을 종료합니다.<br>
 * - 유효하지 않은 입력에 대해 오류 메시지를 출력합니다.<br>
 * - 0을 입력하면 프로그램이 ‘뒤로가기’되거나 ‘종료’됩니다.
 */
public class Main {
    public static void main(String[] args) {
        // Kiosk 객체를 생성하고 사용하는 main 함수에서 객체를 생성할 때 값을 넘겨준다.
        Kiosk kiosk = new Kiosk(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"),
                new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"),
                new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"),
                new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        kiosk.start();
    }
}
