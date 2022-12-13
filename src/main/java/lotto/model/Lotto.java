package lotto.model;

import lotto.Constant.LottoInformation;
import lotto.Constant.Rank;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoInformation.SIZE.getValue()) {
            throw new IllegalArgumentException();
        }
        if(numbers.size() != numbers.stream()
                .distinct()
                .collect(Collectors.toList())
                .size()){
            throw new IllegalArgumentException();
        }
    }
    public String toString(){
        return numbers.toString();
    }

    public Rank compare(AnswerNumbers answerNumbers){
        int sameNumberCount = findNumber(answerNumbers);
        boolean isBonusSame = findBonusNumber(answerNumbers);
        return Rank.findRanking(sameNumberCount,isBonusSame);
    }
    public int findNumber(AnswerNumbers answerNumbers){
        int sameNumberCount =0;
        for(int number:numbers){
            if(answerNumbers.containNumber(number))
                sameNumberCount++;
        }
        return sameNumberCount;
   }
   public boolean findBonusNumber(AnswerNumbers answerNumbers){
        return numbers.contains(answerNumbers.getBonus());
   }
}
