package exercise;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class ReversedSequenceTest {
    CharSequence text1 = new ReversedSequence("abcdef");
    CharSequence text2 = new ReversedSequence("fedcba");
    @Test
    public void testReversedSequence() {
        assertThat(text1.toString()).isEqualTo("fedcba");
        assertThat(text2.charAt(1)).isEqualTo('e');
        assertThat(text2.length()).isEqualTo(6);
        assertThat(text2.subSequence(1, 4).toString()).isEqualTo("edc");
    }
}
