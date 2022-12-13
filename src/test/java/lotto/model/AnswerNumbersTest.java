package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AnswerNumbersTest {
    @DisplayName("정답 번호 입력이 예외로 주어졌을떄")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,5","1","1,2,3,4,5,6,7,8","1,-1,2,3,4,5","1,2,3,4,5,890"})
    void overLapNumber(String input){
        assertThatThrownBy(() -> new AnswerNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
    @DisplayName("담청번호가 예외로 주어졌을 떄")
    @ParameterizedTest
    @ValueSource(strings = {"-1","3000","6"})
    void bonusNumber(String input){
        AnswerNumbers answerNumbers = new AnswerNumbers("1,2,3,4,5,6");
        assertThatThrownBy(() -> answerNumbers.addBonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }


}