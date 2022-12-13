package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String inputMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        String money = Console.readLine();
        return money;
    }
    public static String inputAnswerNumbers(){
        System.out.println("당첨 번호를 입력해 주세요");
        String answerNumbers = Console.readLine();
        return answerNumbers;
    }
    public static String inputBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
        return bonusNumber;
    }
}
