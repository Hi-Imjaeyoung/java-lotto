package lotto.model;

import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RankingCalculateTest {
    @DisplayName("lotto의 결과 계산")
    @Test
    void lottoResultCalculate(){
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1,2,3,4,7,8))); //1등
        lottos.add(new Lotto(List.of(1,2,3,4,7,6))); //1등
        lottos.add(new Lotto(List.of(1,2,3,4,5,6))); //2등
        lottos.add(new Lotto(List.of(1,2,3,4,7,10))); //3등
        lottos.add(new Lotto(List.of(1,2,3,4,10,11))); //4등
        lottos.add(new Lotto(List.of(1,2,3,9,10,11))); //5등
        AnswerNumbers answerNumbers = new AnswerNumbers("1,2,3,4,7,8");
        answerNumbers.addBonusNumber("6");
        RankingCalculate rankingCalculate = new RankingCalculate(lottos,answerNumbers);
        assertThat(rankingCalculate.getRankings()).isEqualTo("21111");
    }
    @Test
    void lottoProfitCalculate(){
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1,2,3,9,10,11))); //5등
        AnswerNumbers answerNumbers = new AnswerNumbers("1,2,3,4,7,8");
        answerNumbers.addBonusNumber("6");
        RankingCalculate rankingCalculate = new RankingCalculate(lottos,answerNumbers);
        assertThat(rankingCalculate.getProfit()).isEqualTo("500.0");
    }
}