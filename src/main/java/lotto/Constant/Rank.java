package lotto.Constant;

import java.util.Arrays;

public enum Rank {
    FIRST(6,false,2_000_000_000), SECOND(5,true,30_000_000),
    THIRD(5,true,1_500_00),FOURTH(4,false,50_000),
    FIFTH(3,false,5_000), FAIL(0,false,0);

    int correctNumber;
    int money;
    boolean correctBonus;
    Rank(int correctNumber,boolean correctBonus ,int money){
        this.correctNumber = correctNumber;
        this.money = money;
        this.correctBonus = correctBonus;
    }

    public int getMoney(){
        return money;
    }

    public static Rank findRanking(int correctNumber, boolean correctBonus){
        return Arrays.stream(Rank.values())
                .filter(ranking -> ranking.correctNumber==correctNumber
                        && ranking.correctBonus == correctBonus)
                .findAny()
                .orElse(FAIL);
    }
}
