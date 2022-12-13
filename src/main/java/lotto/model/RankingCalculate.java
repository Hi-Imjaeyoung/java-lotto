package lotto.model;

import lotto.Constant.LottoInformation;
import lotto.Constant.Rank;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.List;

public class RankingCalculate {
    private int inputMoney;
    private Map<Rank,Integer> rankings;
    public RankingCalculate(List<Lotto> lottos, AnswerNumbers answerNumbers){
        this.inputMoney =lottos.size()* LottoInformation.PRICE.getValue();
        rankings = new EnumMap<Rank, Integer>(Rank.class);
        Arrays.stream(Rank.values()).forEach(rank -> rankings.put(rank,0));
        for(Lotto nowLotto:lottos){
            Rank nowRank = nowLotto.compare(answerNumbers);
            rankings.put(nowRank,rankings.getOrDefault(nowRank,0)+1);
        }
    }
    public String getProfit(){
        int price =0;
        for(Map.Entry<Rank,Integer> set: rankings.entrySet()){
            if(set.getValue()!=0){
                price += set.getKey().getMoney()* set.getValue();
            }
        }
        double profitPercent = ((double)price/(double)inputMoney)*(double)(100);
        String profit = String.format("%.1f",profitPercent);
        return profit;
    }
    public String getRankings(){
        String rankings ="";
        for(Map.Entry<Rank,Integer> set: this.rankings.entrySet()){
            rankings+=(String.valueOf(set.getValue()));
        }
        return rankings;
    }
}
