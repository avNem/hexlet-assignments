package exercise;

// BEGIN
public class ReversedSequence implements CharSequence{
    private String string;

    public ReversedSequence(String string) {
        this.string = string;
    }

    @Override
    public int length() {
        return string.length();
    }

    @Override
    public char charAt(int index) {
        return string.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return string.subSequence(start, end);
    }

    @Override
    public String toString() {
        return new StringBuilder(string).reverse().toString();
    }
}
// END
