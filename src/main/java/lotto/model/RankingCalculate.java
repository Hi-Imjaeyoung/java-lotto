package lotto.model;

import lotto.Constant.LottoInformation;
import lotto.Constant.Rank;

import java.util.List;

public class RankingCalculate {
    private int[] rank;
    private int inputMoney;
    public RankingCalculate(List<Lotto> lottos, AnswerNumbers answerNumbers){
        this.rank = new int[6];
        this.inputMoney =lottos.size()* LottoInformation.PRICE.getValue();
        for(Lotto nowLotto:lottos){
            int ranking = rankingCalculate(nowLotto.findNumber(answerNumbers),nowLotto.findBonusNumber(answerNumbers));
            if(ranking<6 && ranking >0){
                rank[ranking] ++;
            }
        }
    }
    public int rankingCalculate(int sameNumberCount, boolean bonusNumber){
        //TODO : 좀더 좋은 방법 없을까
        if(sameNumberCount==6)
            return Rank.FIRST.getRanking();
        if(sameNumberCount==5){
            if(bonusNumber)
                return Rank.FIRST.getRanking();
            return Rank.THIRD.getRanking();
        }
        if(sameNumberCount==4){
            if(bonusNumber)
                return Rank.SECOND.getRanking();
            return Rank.FOURTH.getRanking();
        }
        if(sameNumberCount==3)
            return Rank.FIFTH.getRanking();
        return Rank.FAIL.getRanking();
    }
    public String getProfit(){
        int price =0;
        for(int i=1 ;i<=5;i++){
            price += rank[i]*Rank.findRanking(String.valueOf(i)).getMoney();
        }
        double profitPercent = ((double)price/(double)inputMoney)*(double)(100);
        String profit = String.format("%.1f",profitPercent);
        return profit;
    }
    public String getRankings(){
        String rankings ="";
        for(int i=1; i<=5;i++){
            rankings += String.valueOf(rank[i]);
        }
        return rankings;
    }
}
