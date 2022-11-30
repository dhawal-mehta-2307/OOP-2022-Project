package flashCards;

public class CardAlreadyAddedException extends Exception {
    public CardAlreadyAddedException(String msg) {
        super(msg);
    }
}
