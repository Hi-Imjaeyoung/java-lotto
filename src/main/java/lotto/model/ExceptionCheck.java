package lotto.model;

public class ExceptionCheck {
    public static void inputMoneyFormatCheck(String input) throws IllegalArgumentException{
        if(input.replaceAll("[^0-9]","").length()!=input.length()){
            throw new IllegalArgumentException(ExceptionMessage.ERROR_NOT_NUMBER.getMessage());
        }
        if(Integer.parseInt(input)%1000 != 0){
            throw new IllegalArgumentException(ExceptionMessage.ERROR_WRONG_NUMBER.getMessage());
        }
    }
}
