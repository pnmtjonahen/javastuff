package nl.tjonahen.jaavastuff.java8stuff;

/**
 *
 * @author Philippe Tjon-A-Hen philippe@tjonahen.nl
 */
public class Word {

    private final String text;
    private final int count;

    /**
     * 
     * @param text -
     * @param count -
     */
    public Word(final String text, final int count) {
        this.text = text;
        this.count = count;
    }

    public String getText() {
        return text;
    }

    public int getCount() {
        return count;
    }
}
