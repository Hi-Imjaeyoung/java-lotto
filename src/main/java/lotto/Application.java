package lotto;

import lotto.model.ExceptionCheck;
import lotto.model.RandomNumberMaker;
import lotto.model.RankingCalculate;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application { ;
    static private RandomNumberMaker randomNumberMaker =new RandomNumberMaker();
    public static void main(String[] args) {
        int inputMoney;
        try {
            inputMoney = checkInputMoney();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return;
        }
        List<Lotto> lottos = makeLottos(inputMoney);
        for(Lotto lotto :lottos){
            OutputView.printDetailNumbers(lotto.toString());
        }
        OutputView.printSuccessPurchase(inputMoney/1000);
        List<Integer> answerNumbers;
        int bonusNumber;
        try{
            answerNumbers = checkAnswerNumber();
            bonusNumber = checkBonusNumber(answerNumbers);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return;
        }
        RankingCalculate rankingCalculate = new RankingCalculate(lottos,answerNumbers,bonusNumber);
        OutputView.printResult(rankingCalculate.getRankings(),rankingCalculate.getProfit());
    }
    private static int checkInputMoney() throws IllegalArgumentException{
        OutputView.printPurchaseRequest();
        String inputMoney = InputView.inputMoney();
        ExceptionCheck.inputMoneyFormatCheck(inputMoney);
        return Integer.parseInt(inputMoney);
    }
    private static List<Lotto> makeLottos(int inputMoney){
        List<Lotto> lottos = new ArrayList<>();
        for(int i=0;i<inputMoney/1000;i++){
            lottos.add(new Lotto(randomNumberMaker.RandomNumberMaker()));
        }
        return lottos;
    }
    private static List<Integer> checkAnswerNumber(){
        OutputView.printAnswerNumberRequest();
        String answerNumber = InputView.inputAnswerNumbers();
        ExceptionCheck.inputAnswerNumberCheck(answerNumber);
        return Arrays.stream(answerNumber.split(","))
                .map(value -> Integer.parseInt(value))
                .collect(Collectors.toList());
    }
    private static int checkBonusNumber(List<Integer> answerNumbers){
        OutputView.printBonusNumberRequest();
        String bonusNumber = InputView.inputBonusNumber();
        ExceptionCheck.bonusNumberCheck(bonusNumber,answerNumbers);
        return Integer.parseInt(bonusNumber);
    }
}
