package flashCards;

public class FillInTheBlank extends Card {

    /*
     * DISCLAIMER: The implementation of this class limits the functionality to only one blank in the question.
     * The user can't add more blanks in it. If need be, we shall add the functionality for that in the future
     * when the rest of the program is working
     */

    private String question;
    private String answer;

    public FillInTheBlank(String front) throws InsufficientUnderscoresException, MoreThanOneBlankException {
        super(front, "");
        formatFillInTheBlank();
    }

    // Throws the exception if user has not entered sufficient number of underscores
    private void formatFillInTheBlank() throws InsufficientUnderscoresException, MoreThanOneBlankException {
        String[] splitStr = front.split("_");
        if (splitStr.length < 3) throw new InsufficientUnderscoresException("You haven't added any blanks!");
        if (splitStr.length > 3) throw new MoreThanOneBlankException("Multiple blanks are not currently supported!");
        question = splitStr[0] + "_____" + splitStr[2];
        answer = splitStr[1];
    }

    @Override
    public String getQuestion() {
        return question;
    }

    @Override
    public String getAnswer() {
        return answer;
    }
}
