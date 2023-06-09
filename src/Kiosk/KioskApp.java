package Kiosk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class KioskApp{

    public static void main(String[] args) {
        // 메인 카테고리 메뉴 HashMap 이용
        HashMap<Integer, String> menuList = new HashMap<Integer, String>();
        menuList.put(1, "1. ESPRESSO   | 에스프레소");
        menuList.put(2, "2. NON COFFEE | 카페인이 없는 주스&티");
        menuList.put(3, "3. DESSERT    | 다양한 디저트");
        menuList.put(4, "4. OREDER     | 장바구니 확인 후 주문합니다.");
        menuList.put(5, "5. CANCEL     | 진행중인 주문을 취소합니다.");


      //  배열 생성
        List espresso = new ArrayList();

      // 배열에 객체 입력(배열 안에 객체를 넣는다.)
        espresso.add(new Commodity("Cafe Espresso" ,"에스프레소, 설탕(설탕이 필요 없는 경우 미리 말씀해주세요.)", 2900)); //0
        espresso.add(new Commodity("Cafe Strapazzato","에스프레소, 설탕, 카카오", 3300)); //1
        espresso.add(new Commodity("Cafe Gege","에스프레소,카카오, 크림", 3800)); //2
        espresso.add(new Commodity("Cafe Romano","에스프레소, 설탕, 레몬",4300)); //3

        List nonCoffee = new ArrayList();

        nonCoffee.add(new Commodity("Orange Juice","100% 오렌지 주스",5000));
        nonCoffee.add(new Commodity("Chocolat Latte","40% 카카오 함량의 초콜릿과 우유",5000));
        nonCoffee.add(new Commodity("Black & Herb Tea","잉글리쉬 블랙퍼스트, 모로칸 미트, 애플앤블랙베리",5000));
        nonCoffee.add(new Commodity("Yuzu Green Tea","유자차와 그린티",5500));
        nonCoffee.add(new Commodity("Cherry Lemonade","파브리 체리, 레몬, 탄산수",5500));

        List dessert = new ArrayList();

        dessert.add(new Commodity("Salted Butter Bread","좋은 질감과 풍미가 가득한 빵",3500));
        dessert.add(new Commodity("Twist Stick","40% 페스츄리 질감의 달콤한 꽈배기 빵",2300));


        List orderList = new ArrayList(); //주문 리스트를 받기 위한 오더 리스트 생성

        Scanner scanner = new Scanner(System.in); // 입력 값
        System.out.println(Order.title);
        Commodity commodity = new Commodity(); // Commodity 인스턴스를 생성


        while (true) { //메인 메뉴판 : 1번화면
            System.out.println(" ========= [CONNECTS MENU] ========= ");
            System.out.println("아래 상품 메뉴판을 보시고, 상품을 골라 입력해주세요.");
            System.out.println();
            System.out.println(menuList.get(1));
            System.out.println(menuList.get(2));
            System.out.println(menuList.get(3));
            System.out.println(menuList.get(4));
            System.out.println(menuList.get(5)); // HashMap 호출
            System.out.println("선택 : ");
            int order = scanner.nextInt(); // 유저가 선택한 번호를 변수 int order에 저장
            // 유저 번호 선택에 따른 메뉴판 출력
            if (order == 1) {
                commodity.output(espresso); //에스프레소 종류가 commodity 메서드 출력
                //에스프레소 선택 시
                Scanner scanner1 = new Scanner(System.in); // 메뉴선택 스캐너
                String input1 = scanner1.nextLine(); // 유저가 입력한 특정 숫자값받기
                int num1 = Integer.parseInt(input1); // 형변환

                Commodity espressoList = (Commodity) espresso.get(num1-1); // 고객이 입력한 내용
                System.out.println(espressoList.name + " | " + espressoList.explanation + " | " + espressoList.price); // 메뉴의 이름, 설명, 가격 가져오기

                System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                System.out.println("1. 확인   2. 취소");
                Scanner scanner2 = new Scanner(System.in); // 확인 또는 취소를 누를 수 있는 스캐너 메서드
                String input2 = scanner2.nextLine();
                int num2 = Integer.parseInt(input2); // 특정 숫자값받기
                if (num2 == 1) {
                    orderList.add(espressoList); // 고객이 선택한 메뉴 장바구니에 저장
                    System.out.println("선택하신 메뉴가 장바구니에 추가되었습니다.");
                } else {
                    // 취소 선택 시 메인 메뉴로 돌아가기
                }
            } else if (order == 2) {
                commodity.output(nonCoffee);
                //주스&티 선택 시
                Scanner scanner1 = new Scanner(System.in);
                String input1 = scanner1.nextLine();
                int num1 = Integer.parseInt(input1); // 특정 숫자값받기
                Commodity nonCoffeeList = (Commodity) nonCoffee.get(num1-1);
                System.out.println(nonCoffeeList.name + " | " + nonCoffeeList.explanation + " | " + nonCoffeeList.price);
                System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                System.out.println("1. 확인   2. 취소");
                Scanner scanner2 = new Scanner(System.in);
                String input2 = scanner2.nextLine();
                int num2 = Integer.parseInt(input2); // 특정 숫자값받기
                if (num2 == 1) {
                    orderList.add(nonCoffeeList);
                    System.out.println("선택하신 메뉴가 장바구니에 추가되었습니다.");
                } else {

                }
            } else if(order == 3) {
                commodity.output(dessert);
                //디저트 선택 시
                Scanner scanner1 = new Scanner(System.in);
                String input1 = scanner1.nextLine();
                int num1 = Integer.parseInt(input1); // 특정 숫자값받기
                Commodity dessertList = (Commodity) dessert.get(num1-1);
                System.out.println(dessertList.name + " | " + dessertList.explanation + " | " + dessertList.price);
                System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                System.out.println("1. 확인   2. 취소");
                Scanner scanner2 = new Scanner(System.in);
                String input2 = scanner2.nextLine();
                int num2 = Integer.parseInt(input2); // 특정 숫자값받기
                if (num2 == 1) {
                    orderList.add(dessertList);
                    System.out.println("선택하신 메뉴가 장바구니에 추가되었습니다.");
                } else {

                }
            } else if(order == 4) {
                System.out.println("주문내역을 확인합니다.");
                System.out.println("[Order]");
                commodity.outputOrder(orderList); // orderList 를 불러오기 위한 메서드 호출
                System.out.println("1. 주문    2. 메뉴판");

                Scanner scanner1 = new Scanner(System.in); // Scanner 객체(입력)
                String input = scanner1.nextLine(); // Scanner의 메서드를 사용 input에 String값 넣음
                int order1 = Integer.parseInt(input); // 받은 S1tring을 Int로 형변환

                if(order1 == 1) {
                    System.out.println("주문이 완료되었습니다!");
                    System.out.println("대기번호는 [ 1 ] 번 입니다."); //아직 구현할 수 없는 영역...
                    System.out.println("(2초 후 메뉴판으로 돌아갑니다.)");
                    // n초 후 메뉴판 돌려야함
                    orderList.clear();
                    Order.stop2Second(); // 2초후에 돌아가는 영역

                } else {
                    System.out.println("메인 메뉴판으로 돌아갑니다.");
                    // 메뉴판으로 돌아가는 영역
                }

            } else if(order == 5) {
                System.out.println("진행하던 주문을 취소하시겠습니까?");
                System.out.println("1.주문초기화     2.메인화면으로 돌아가기");
                Scanner scanner3 = new Scanner(System.in); // Scanner 객체
                String input = scanner3.nextLine(); // Scanner 의 메서드를 사용 input 에 String 값 넣음
                int cancel = Integer.parseInt(input); // 받은 String 을 Int 로 형변환
                if(cancel == 1) {
                    orderList.clear(); // 고객이 주문을 받았던 내역을 초기화
                } else {
                    System.out.println("메인 메뉴판으로 돌아갑니다."); // 초기화 없이 메인 메뉴판으로 돌아가게 해줌
                }
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }

    }
}

