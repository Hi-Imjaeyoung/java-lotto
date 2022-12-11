package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String inputMoney(){
        String money = Console.readLine();
        return money;
    }
    public static String inputAnswerNumbers(){
        String answerNumbers = Console.readLine();
        return answerNumbers;
    }
    public static String inputBonusNumber(){
        String bonusNumber = Console.readLine();
        return bonusNumber;
    }
}
