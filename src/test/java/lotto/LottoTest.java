package lotto;

import lotto.model.AnswerNumbers;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("로또 내 번호들을 출력한다")
    @Test
    void numbersToString(){
        assertThat(new Lotto(List.of(1,2,3,4,5,6)).toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
    @DisplayName("정답 번호가 주어졌을때, 같은 숫자 갯수를 구한다")
    @Test
    void sameNumberFind(){
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        assertThat(lotto.findNumber(new AnswerNumbers("1,2,3,4,5,6"))).isEqualTo(6);
        assertThat(lotto.findNumber(new AnswerNumbers("1,2,3,4,5,7"))).isEqualTo(5);
        assertThat(lotto.findNumber(new AnswerNumbers("1,2,3,4,8,7"))).isEqualTo(4);
        assertThat(lotto.findNumber(new AnswerNumbers("1,2,3,9,8,7"))).isEqualTo(3);
    }
    @Test
    void bonusNumberFind(){
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        AnswerNumbers answerNumbers = new AnswerNumbers("7,8,9,10,11,12");
        answerNumbers.addBonusNumber("2");
        assertThat(lotto.findBonusNumber(answerNumbers)).isEqualTo(true);
        answerNumbers.addBonusNumber("10");
        assertThat(lotto.findBonusNumber(answerNumbers)).isEqualTo(false);
    }
}
