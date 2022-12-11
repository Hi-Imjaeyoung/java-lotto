package lotto.model;

public enum Rank {
    FIRST("1",2_000_000_000), SECOND("2",30_000_000), THIRD("3",1_500_00),FOUTH("4",50_000),
    FIFTH("5",5_00), FAIL("-1",0);
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
}
