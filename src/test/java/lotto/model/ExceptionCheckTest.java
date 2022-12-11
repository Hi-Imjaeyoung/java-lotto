package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ExceptionCheckTest {
    @DisplayName("당첨번호 예외 체크")
    @Test
    void answerNumberCheck(){
        assertThatThrownBy(() -> ExceptionCheck.inputAnswerNumberCheck("1,2,3.4"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
        assertThatThrownBy(() -> ExceptionCheck.inputAnswerNumberCheck("a,2,3,4"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
        assertThatThrownBy(() -> ExceptionCheck.inputAnswerNumberCheck("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
        assertThatThrownBy(() -> ExceptionCheck.inputAnswerNumberCheck("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}