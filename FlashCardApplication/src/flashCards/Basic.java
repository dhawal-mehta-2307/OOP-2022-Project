package flashCards;

public class Basic extends Card {

    public Basic(String front, String back) {
        super(front, back);
    }

    @Override
    public String getQuestion() { return front; }

    @Override
    public String getAnswer() { return back; }

    public static class InsufficientUnderscoresException extends Exception {
        public InsufficientUnderscoresException(String msg) {
            super(msg);
        }
    }
}
