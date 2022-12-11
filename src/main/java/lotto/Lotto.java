package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
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

    // TODO: 추가 기능 구현
}
