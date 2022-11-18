package flashCards;

import java.time.*;
import java.util.UUID;

public abstract class Card {
    protected final UUID uniqueID;
    protected Difficulty difficulty;
    protected LocalDateTime lastSeen;
    protected String front;
    protected String back;


    /*
     * Getter functions
     */
    public UUID getUniqueID() {
        return uniqueID;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public LocalDateTime getLastSeen() {
        return lastSeen;
    }

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

    /* CONSTRUCTOR:
     * When a new card is created only the front and back will be supplied.
     * The UUID class deals with generating and formatting Universally Unique IDs.
     * The initial difficulty should be set to AGAIN and then subsequently change the difficulty
     * according to user.
     */
    public Card(String front, String back) {
        this.front = front;
        this.back = back;
        uniqueID = UUID.randomUUID(); // Generates a UUID
        difficulty = Difficulty.AGAIN;
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

    // While learning event occurs, return the question and then the answer
    // In case of two-sided, use a randomizer to determine if the question should be front or back
    public abstract String getQuestion();
    public abstract String getAnswer();
}
