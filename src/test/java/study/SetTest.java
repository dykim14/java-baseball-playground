package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    // 요구사항 1
    @Test
    @DisplayName("Collection.size()의 단위 테스트")
    public void size() {
        assertThat(numbers.size()).isEqualTo(4);
    }

    // 요구사항 2
    @DisplayName("Collection.contains()의 단위 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    // 요구사항 3
    @DisplayName("Collection.containsWithBoundaryTest()의 단위 테스트")
    @ParameterizedTest
    @CsvSource(value = { "1,true", "2,true", "3,true", "4,false", "5,false"})
    void containsWithBoundaryTest(int number, boolean expected) {
        assertThat(numbers.contains(number)).isEqualTo(expected);
    }
}
