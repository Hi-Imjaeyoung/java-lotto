package lotto.view;

public class OutputView {
    public static void printPurchaseMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }
    public static void printSuccessPurchase(int number){
        System.out.println(number+"개를 구매했습니다");
    }
    public static void printDetailNumbers(String numbers){
        System.out.println(numbers);
    }
}
