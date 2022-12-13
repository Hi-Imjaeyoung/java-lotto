package lotto.model;

import lotto.Constant.ExceptionMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AnswerNumbers {
    private List<Integer> answerNumbers;
    private int bonusNumber;
    public AnswerNumbers(String answerNumber){
        validateAnswerNumber(answerNumber);
        this.answerNumbers = Arrays.stream(answerNumber.split(","))
                .map(value -> Integer.parseInt(value))
                .collect(Collectors.toList());
    }
    public void addBonusNumber(String bonusNumber){
        validateBonusNumber(bonusNumber);
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }
    public boolean containNumber(int number){
        return answerNumbers.contains(number);
    }
    public int getBonus(){
        return bonusNumber;
    }

    private void validateAnswerNumber(String input) throws IllegalArgumentException{
        answerNumberFormatCheck(input);
        String[] numbers = input.split(",");
        answerNumberLengthCheck(numbers);
        answerNumberOverlapCheck(numbers);
    }
    private void answerNumberFormatCheck(String input) throws IllegalArgumentException{
        if(input.replaceAll("[^0-9\\,]","").length() != input.length()){
            throw new IllegalArgumentException(ExceptionMessage.ERROR_NOT_ANSWER.getMessage());
        }
    }
    private void answerNumberLengthCheck(String[] numbers) throws IllegalArgumentException{
        if(numbers.length != 6){
            throw new IllegalArgumentException(ExceptionMessage.ERROR_WRONG_LENGTH.getMessage());
        }
    }
    private void answerNumberOverlapCheck(String[] numbers) throws IllegalArgumentException{
        if(Arrays.stream(numbers).distinct().count() != numbers.length){
            throw new IllegalArgumentException(ExceptionMessage.ERROR_OVERLAP.getMessage());
        }
    }
    private void validateBonusNumber(String input){
        if(input.replaceAll("[^0-9]","").length()!=input.length()){
            throw new IllegalArgumentException(ExceptionMessage.ERROR_NOT_NUMBER.getMessage());
        }
        int bonusNumber = Integer.parseInt(input);
        if(bonusNumber<1 || bonusNumber>45){
            throw new IllegalArgumentException(ExceptionMessage.ERROR_SCALE.getMessage());
        }
        //TODO : think better method to bonusnumber overlap check in numbers
        if(this.answerNumbers.contains(bonusNumber)){
            throw new IllegalArgumentException(ExceptionMessage.ERROR_OVERLAP.getMessage());
        }
    }
}
