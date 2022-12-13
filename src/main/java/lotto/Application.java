package lotto;

import lotto.Constant.LottoInformation;
import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Application { ;
    static private RandomNumberMaker randomNumberMaker =new RandomNumberMaker();
    public static void main(String[] args) {
        try{
            PurchaseMoney purchaseMoney = checkInputMoney();
            List<Lotto> lottos = new ArrayList<>();
            RandomNumberMaker randomNumberMaker = new RandomNumberMaker();
            for(int i=0;i< purchaseMoney.getMoney()/1000;i++){
                lottos.add(new Lotto(randomNumberMaker.RandomNumberMaker()));
            }
            numbersPrint(lottos);
            AnswerNumbers answerNumbers = checkAnswerNumber();
            RankingCalculate rankingCalculate = new RankingCalculate(lottos,answerNumbers);
            OutputView.printResult(rankingCalculate.getRankings(),rankingCalculate.getProfit());
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
    private static PurchaseMoney checkInputMoney() throws IllegalArgumentException{
        PurchaseMoney purchaseMoney = new PurchaseMoney(InputView.inputMoney());
        OutputView.printSuccessPurchase(purchaseMoney.getMoney()/ LottoInformation.PRICE.getValue());
        return purchaseMoney;
    }
    private static AnswerNumbers checkAnswerNumber() throws IllegalArgumentException{
        AnswerNumbers answerNumbers = new AnswerNumbers(InputView.inputAnswerNumbers());
        answerNumbers.addBonusNumber(InputView.inputBonusNumber());
        return answerNumbers;
    }
    private static void numbersPrint(List<Lotto> lottos){
        for(Lotto lotto : lottos){
            OutputView.printDetailNumbers(lotto.toString());
        }
    }
}
