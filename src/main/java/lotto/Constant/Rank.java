package lotto.Constant;

import java.util.Arrays;

public enum Rank {
    FIRST("1",2_000_000_000), SECOND("2",30_000_000),
    THIRD("3",1_500_00),FOURTH("4",50_000),
    FIFTH("5",5_000), FAIL("-1",0);

    String ranking;
    int money;
    Rank(String ranking, int money){
        this.ranking = ranking;
        this.money = money;
    }
    public int getRanking(){
        return Integer.parseInt(ranking);
    }
    public int getMoney(){
        return money;
    }

    public static Rank findRanking(String rank){
        return Arrays.stream(Rank.values())
                .filter(ranking -> ranking.ranking.equals(rank))
                .findAny()
                .orElse(FAIL);
    }
}
