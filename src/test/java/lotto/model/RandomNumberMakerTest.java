package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberMakerTest {
    @DisplayName("로또 번호가 적절하게 잘 만들어 지는가")
    @Test
    void LOTTO_NUMBERS(){
        RandomNumberMaker random = new RandomNumberMaker();
        List<Integer> numbers = random.RandomNumberMaker();
        System.out.println(numbers.toString());
        assertThat(numbers.size()).isEqualTo(6);
        assertThat(numbers.size() == numbers.stream()
                                                  .distinct()
                                                  .collect(Collectors.toList())
                                                  .size()).isEqualTo(true);
    }

}