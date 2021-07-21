package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleCalculatorTest {
    List<Character> opList = new ArrayList<>();
    List<Character> numList  = new ArrayList<>();
    SimpleCalculator sc = new SimpleCalculator();

    @BeforeEach
    void setUp() {
        opList = new ArrayList<>();
        opList.addAll(Arrays.asList('+', '-', '*', '/'));

        numList = new ArrayList<>();
        numList.addAll(Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9'));
    }

    @Test
    @DisplayName("입력 문자열의 숫자와 사칙 연산 사이에는 반드시 빈 공백 문자열여부를 테스트")
    void shouldExistSpaceBetweenEachChar() {
        String input = "2 + 3 * 4 / 2";
        String badInput = "2+ 3 *4 /2";

        for (int i = 0 ; i < input.length() - 1 ; i++) {
            char currChar = input.charAt(i);
            char nextChar = input.charAt(i+1);

            if (numList.contains(currChar)) {
                assertThat(opList.contains(nextChar)).isFalse();
                assertThat(nextChar).isEqualTo(' ');
            }

            if (opList.contains(currChar)) {
                assertThat(numList.contains(nextChar)).isFalse();
                assertThat(nextChar).isEqualTo(' ');
            }
        }
    }
}
