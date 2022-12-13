package lotto.model;

import lotto.Constant.ExceptionMessage;
import lotto.Constant.LottoInformation;

public class PurchaseMoney {
    private int Money;
    public PurchaseMoney(String inputValue){
        validate(inputValue);
        this.Money = Integer.parseInt(inputValue);
    }
    public int getMoney(){
        return Money;
    }
    private static void validate(String input) throws IllegalArgumentException{
        if(input.replaceAll("[^0-9]","").length()!=input.length()){
            throw new IllegalArgumentException(ExceptionMessage.ERROR_NOT_NUMBER.getMessage());
        }
        if(Integer.parseInt(input)% LottoInformation.PRICE.getValue() != 0){
            throw new IllegalArgumentException(ExceptionMessage.ERROR_WRONG_NUMBER.getMessage());
        }
    }
}
