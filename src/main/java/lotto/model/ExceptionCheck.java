package lotto.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ExceptionCheck {
    public static void inputMoneyFormatCheck(String input) throws IllegalArgumentException{
        if(input.replaceAll("[^0-9]","").length()!=input.length()){
            throw new IllegalArgumentException(ExceptionMessage.ERROR_NOT_NUMBER.getMessage());
        }
        if(Integer.parseInt(input)%1000 != 0){
            throw new IllegalArgumentException(ExceptionMessage.ERROR_WRONG_NUMBER.getMessage());
        }
    }
    public static void inputAnswerNumberCheck(String input) throws IllegalArgumentException{
        answerNumberFormatCheck(input);
        String[] numbers = input.split(",");
        answerNumberLengthCheck(numbers);
        answerNumberOverlapCheck(numbers);
    }
    private static void answerNumberFormatCheck(String input) throws IllegalArgumentException{
        if(input.replaceAll("[^0-9\\,]","").length() != input.length()){
            throw new IllegalArgumentException(ExceptionMessage.ERROR_NOT_ANSWER.getMessage());
        }
    }
    private static void answerNumberLengthCheck(String[] numbers) throws IllegalArgumentException{
        if(numbers.length != 6){
            throw new IllegalArgumentException(ExceptionMessage.ERROR_WRONG_LENGTH.getMessage());
        }
    }
    private static void answerNumberOverlapCheck(String[] numbers) throws IllegalArgumentException{
        if(Arrays.stream(numbers).distinct().count() != numbers.length){
            throw new IllegalArgumentException(ExceptionMessage.ERROR_OVERLAP.getMessage());
        }
    }
}
