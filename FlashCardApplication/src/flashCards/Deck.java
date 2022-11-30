package flashCards;

import java.time.LocalDate;
import java.util.UUID;
import java.util.Collections;
import java.util.ArrayList;

public class Deck implements Sharable {
    private boolean isPrivate;
    private final UUID deckID = UUID.randomUUID();
    private String deckName;
    private ArrayList<Card> cardList = new ArrayList<>();

    public Deck(String deckName, boolean isPrivate) {
        this.deckName = deckName;
        this.isPrivate = isPrivate;
    }

    public void addCard(Card newCard) throws CardAlreadyAddedException {
        for(Card card: cardList)
            if(card.getQuestion().equals(newCard.getQuestion()))
                throw new CardAlreadyAddedException("There exists another card with the same question!");
        cardList.add(0, newCard);
    }

    public void deleteCard(Card card) {
        cardList.remove(card);
    }

    public void sortDeck() { Collections.sort(cardList); }

    public ArrayList<Card> getRevisionCards(LocalDate today) throws NoCardsToReviewException {
        ArrayList<Card> revisionCards = new ArrayList<>();
        sortDeck();
        for(Card card: cardList) {
            if (today.isEqual(card.getDueDate()) || today.isAfter(card.getDueDate())) revisionCards.add(card);
            if (today.isBefore(card.getDueDate())) break;
        }
        if (revisionCards.isEmpty())
            throw new NoCardsToReviewException("No cards to review from this deck! Enjoy your holiday!");
        return revisionCards;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public UUID getDeckID() {
        return deckID;
    }
}
