package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    @DisplayName("String.split()의 단위 테스트")
    void split() {
        // 요구사항 1
        String[] actual = "1,2".split(",");
        assertThat(actual[0]).isEqualTo("1");
        assertThat(actual[1]).isEqualTo("2");
    }

    @Test
    @DisplayName("String.substring()의 단위 테스트")
    void substring() {
        // 요구사항 2
        String subs = "{1,2}".substring(1, 4);
        assertThat(subs).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String.charAt()의 단위 테스트")
    private void charAt() {
        // 요구사항 3
        char c = "abc".charAt(0);
        assertThat(c).isEqualTo('a');
        c = "abc".charAt(1);
        assertThat(c).isEqualTo('b');
        c = "abc".charAt(2);
        assertThat(c).isEqualTo('c');
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> "abc".charAt(3))
                .withMessageMatching("String index out of range: \\d+");
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> "abc".charAt(-1))
                .withMessageMatching("String index out of range: -\\d+");
    }
}
