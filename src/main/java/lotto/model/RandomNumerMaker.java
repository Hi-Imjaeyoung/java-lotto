package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RandomNumerMaker {
    public List<Integer> RandomNumberMaker(){
        List<Integer> numbers = Collections.emptyList();
        while(true){
            numbers= Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
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
