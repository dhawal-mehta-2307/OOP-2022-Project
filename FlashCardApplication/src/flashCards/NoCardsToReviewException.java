package flashCards;

public class NoCardsToReviewException extends Exception {
    public NoCardsToReviewException(String msg) {
        super(msg);
    }
}
