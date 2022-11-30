package flashCards;

import java.util.Random;

public class TwoSided extends Card {

    private boolean reverse;

    public TwoSided(String front, String back) {
        super(front, back);
    }

    @Override
    public String getQuestion() {
        cardRandomizer();
        if (reverse) return back;
        else return front;
    }

    @Override
    public String getAnswer() {
        if (reverse) return front;
        else return back;
    }

    private void cardRandomizer() {
        Random randomizer = new Random();
        int random = randomizer.nextInt(2); // Randomly chooses between 1 and 0
        if (random == 0) reverse = true;
        else reverse = false;
    }

}
