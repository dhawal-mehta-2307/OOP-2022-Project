package client;

import java.util.ArrayList;
import java.util.UUID;
import flashCards.Deck;

public class User implements Comparable<User> {
    private final String userName;
    private final UUID userID = UUID.randomUUID();
    private int decksContributed = 0;
    private ArrayList<Deck> personalDecks = new ArrayList<>();

    public User(String userName) {
        this.userName = userName;
    }

    public void createNewDeck(String deckName, boolean isPrivate) throws EmptyDeckNameException {
        if (deckName.isBlank()) throw new EmptyDeckNameException("Please enter the name of the deck!");
        personalDecks.add(new Deck(deckName, isPrivate));
    }

    public void removeDeck(Deck deck) {
        personalDecks.remove(deck);
    }

    public void shareDeck(Deck deck) {
        deck.setPrivate(false);
        decksContributed++;
    }

    public void viewActivityMap() {

    }

    public void makeDeckPrivate(Deck deck) {
        deck.setPrivate(true);
        decksContributed--;
    }

    public String getUserName() {
        return userName;
    }

    public int getDecksContributed() {
        return decksContributed;
    }

    @Override
    public int compareTo(User o) {
        return this.decksContributed - o.getDecksContributed();
    }
}
