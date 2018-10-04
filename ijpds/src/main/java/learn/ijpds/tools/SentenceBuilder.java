package learn.ijpds.tools;

/**
 * Helps to build sentences containing words separated with spaces.
 */
public class SentenceBuilder {
    private StringBuilder sb = new StringBuilder();

    /**
     * Appends the specified string to the sentence.
     * @param s appended string
     */
    public void append(String s) {
        sb.append(s);
        sb.append(" ");
    }

    /**
     * Appends the specified object's string representation to the sentence.
     * @param obj appended object
     */
    public void append(Object obj) {
        sb.append(obj.toString());
        sb.append(" ");
    }

    @Override
    public String toString() {
        int last = sb.length() - 1;
        if (sb.charAt(last) == ' ') {
            sb.deleteCharAt(last);
        }
        return sb.toString();
    }
}
