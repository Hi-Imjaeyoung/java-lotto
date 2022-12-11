package lotto.model;

import lotto.Lotto;
import java.util.List;

public class RankingCalculate {
    private int[] rank;
    private int price;
    public RankingCalculate(List<Lotto> lottos, List<Integer> answerNumber, int bonusNumber){
        rank = new int[6];
        for(Lotto nowLotto:lottos){
            int ranking = rankingCalculate(nowLotto.findNumber(answerNumber),nowLotto.findBonusNumber(bonusNumber));
            if(ranking<6 || ranking >0){
                rank[ranking] ++;
            }
        }
    }
    public int rankingCalculate(int sameNumberCount, boolean bonusNumber){
        if(sameNumberCount==5){
            if(bonusNumber)
                return Rank.FIRST.getRanking();
            return Rank.THIRD.getRanking();
        }
        if(sameNumberCount==4){
            if(bonusNumber)
                return Rank.SECOND.getRanking();
            return Rank.FOUTH.getRanking();
        }
        if(sameNumberCount==3)
            return Rank.FIFTH.getRanking();
        return Rank.FAIL.getRanking();
    }
    public String profitCalculate(int inputMoney){
        int price =0;
        for(int i=1 ;i<=5;i++){
            price += rank[i]*Rank.valueOf(String.valueOf(i)).getMoney();
        }
        double porfirPercent = ((double)price/(double)inputMoney)*(double)(100);
        String porfit = String.format("%.2f",porfirPercent);
        return porfit;
    }
}
