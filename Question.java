import java.util.*;

// Class for each question
class Question {
    String questionText;
    List<String> options;
    int correctOption;

    public Question(String questionText, List<String> options, int correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }

    public boolean checkAnswer(int userAnswer) {
        return userAnswer == correctOption;
    }
}

