package dao;

import javax.swing.plaf.PanelUI;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Locale.filter;


public class Words {
    public static List<String> words = new ArrayList<>();

    public String word;

    public String maskedWord;

    public char[] maskedWordChar;
    public int mistakes = 0;


    public Words() throws IOException {
        setWords();
    }

    public void setWord( ) {
        Random r = new Random();
        this.word = words.get(r.nextInt(words.size() - 1));
        setMaskedWord();
    }


    public void setMaskedWord() {
        maskedWord = word.replaceAll(".", "-");
        maskedWordChar = maskedWord.toCharArray();
    }

    void setWords() throws IOException {
        Stream<String> lines = Files.lines(Paths.get("src/main/resources/words.txt"));
        words = lines.filter(e -> e.length() > 5).collect(Collectors.toList());
    }

    public boolean checkWord(String guessWord) {
        return Objects.equals(guessWord, word);
    }

    public void checkCharInWord(char guesschar) {
        boolean flag=false;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guesschar){ maskedWordChar[i] = guesschar;
            replaceCharInString();
            flag=true;
            }

        }
        if(!flag){mistakes++;
        }
    }

    public void replaceCharInString() {
        maskedWord = String.valueOf(maskedWordChar);
    }

    public boolean wordValidation() {
        return Objects.equals(maskedWord, this.word);
    }
    public boolean mistakesValidation(){

        if (mistakes < this.word.length()) return true;
        else return false;
    }
}