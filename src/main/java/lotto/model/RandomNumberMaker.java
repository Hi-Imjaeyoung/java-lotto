package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Constant.LottoInformation;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RandomNumberMaker {
    public List<Integer> RandomNumberMaker(){
        List<Integer> numbers = Collections.emptyList();
        while(true){
            numbers= Randoms.pickUniqueNumbersInRange(LottoInformation.MINIMUM_NUMBER.getValue(),
                    LottoInformation.MAXIMUM_NUMBER.getValue(),
                    LottoInformation.SIZE.getValue());
            numbers = numbers.stream().sorted().collect(Collectors.toList());
            if(checkLottoNumber(numbers)){
                break;
            }
        }

        return numbers;
    }
    private boolean checkLottoNumber(List<Integer> numbers){
        if(numbers.size() == numbers.stream()
                                    .distinct()
                                    .collect(Collectors.toList())
                                    .size()){
            return true;
        }
        return false;
    }
}
