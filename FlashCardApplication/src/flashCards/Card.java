package flashCards;

import java.time.LocalDate;
import java.util.UUID;

public abstract class Card implements Comparable<Card>, Viewable {
    // Generates a UUID
    // Note: uniqueID is a possible redundant variable
    protected final UUID cardID = UUID.randomUUID();
    protected Difficulty difficulty = Difficulty.HARD;
    protected LocalDate lastSeen = LocalDate.now();
    protected LocalDate dueDate = LocalDate.now().plusDays(1);
    protected String front;
    protected String back;


    /*
     * Getter functions
     */
    public UUID getCardID() {
        return cardID;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public LocalDate getLastSeen() {
        return lastSeen;
    }
    public LocalDate getDueDate() { return dueDate; }

    /*
     * Setter functions
     */
    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public void setFront(String front) {
        this.front = front;
    }

    public void setBack(String back) {
        this.back = back;
    }

    // Make sure the setDifficulty function is implemented before this gets executed...!!!
    public void setLastSeenToToday() {
        lastSeen = LocalDate.now();
        dueDate = lastSeen.plusDays((long) Math.pow(2, quantifyDifficulty()));
    }

    /* CONSTRUCTOR:
     * When a new card is created only the front and back will be supplied.
     * The UUID class deals with generating and formatting Universally Unique IDs.
     * The initial difficulty should be set to AGAIN and then subsequently change the difficulty
     * according to user.
     */
    public Card(String front, String back) {
        this.front = front;
        this.back = back;
    }

    /*
     * User can edit front, back or the difficulty of the card.
     * NOTE: What if user wants to change the card type (say, from basic to two-sided)?
     */
    public void edit(String newFront, String newBack, Difficulty newDifficulty) {
        setFront(newFront);
        setBack(newBack);
        setDifficulty(newDifficulty);
    }

    public int compareTo(Card card) {
        return -this.dueDate.compareTo(card.getDueDate());
    }

    protected int quantifyDifficulty() {
        switch (this.difficulty) {
            case EASY: return 0;
            case MODERATE: return 1;
            case HARD: return 2;
            case AGAIN: return 3;
            default: return -1;
        }
    }

}
