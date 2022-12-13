package lotto.view;

public class OutputView {

    public static void printSuccessPurchase(int number){
        System.out.println(number+"개를 구매했습니다.");
    }
    public static void printDetailNumbers(String numbers){
        System.out.println(numbers);
    }
    public static void printResult(String rankings , String profit){
        StringBuilder resultLog = new StringBuilder();
        resultLog.append("당첨 통계"+"\n"+"---"+"\n");
        resultLog.append("3개 일치 (5,000원) - "+rankings.charAt(4)+"개"+"\n");
        resultLog.append("4개 일치 (50,000원) - "+rankings.charAt(3)+"개"+"\n");
        resultLog.append("5개 일치 (1,500,000원) - "+rankings.charAt(2)+"개"+"\n");
        resultLog.append("5개 일치, 보너스 볼 일치 (30,000,000원) - "+rankings.charAt(1)+"개"+"\n");
        resultLog.append("6개 일치 (2,000,000,000원) - "+rankings.charAt(0)+"개"+"\n");
        resultLog.append("총 수익률은 "+profit+"%입니다."+"\n");
        System.out.println(resultLog);
    }
}
