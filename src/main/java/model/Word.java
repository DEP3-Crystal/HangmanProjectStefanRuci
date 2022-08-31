package model;

import dao.Words;

import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class Word extends Words {
    public String word;

    public String maskedWord;

    public char[] maskedWordChar;
    public int mistakes = 0;

    public Word() throws IOException {
        super();
    }

    public void setWord() {
        Random r = new Random();
        this.word = words.get(r.nextInt(words.size() - 1));
        setMaskedWord();
    }


    public void setMaskedWord() {
        maskedWord = word.replaceAll(".", "-");
        maskedWordChar = maskedWord.toCharArray();
    }

    public boolean checkWord(String guessWord) {
        return Objects.equals(guessWord, word);
    }

    public void checkCharInWord(char guesschar) {
        boolean flag = false;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guesschar) {
                maskedWordChar[i] = guesschar;
                replaceCharInString();
                flag = true;
            }

        }
        if (!flag) {
            mistakes++;
        }
    }

    public void replaceCharInString() {
        maskedWord = String.valueOf(maskedWordChar);
    }

    public boolean wordValidation() {
        return Objects.equals(maskedWord, this.word);
    }

    public boolean mistakesValidation() {

        return mistakes <= this.word.length();
    }
}
