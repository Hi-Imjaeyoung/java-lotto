package lotto.Constant;

public enum LottoInformation {
    SIZE(6),PRICE(1000),MINIMUM_NUMBER(1),MAXIMUM_NUMBER(45);
    int value;
    LottoInformation(int value){
        this.value =value;
    }
    public int getValue(){
        return value;
    }
}
