package model;

import cdn.Collors;

import java.util.Objects;
import java.util.Scanner;

public class Player {
    String hangmanMistakes[] =
            {"    "
                    , "\n\n\n======", " \n" +
                    "  |          \n" +
                    "  |         \n" +
                    "  |        \n" +
                    "  |         \n" +
                    "  |        \n" +
                    "======"
                    , "  __________\n" +
                    "  |          \n" +
                    "  |         \n" +
                    "  |        \n" +
                    "  |         \n" +
                    "  |        \n" +
                    "======"
                    , "  __________\n" +
                    "  |          \n" +
                    "  |         O\n" +
                    "  |        \n" +
                    "  |         \n" +
                    "  |        \n" +
                    "======"
                    , "  __________\n" +
                    "  |          \n" +
                    "  |         O\n" +
                    "  |        /\n" +
                    "  |         \n" +
                    "  |        \n" +
                    "======",
                    "  __________\n" +
                            "  |          \n" +
                            "  |         O\n" +
                            "  |        / \\\n" +
                            "  |         \n" +
                            "  |        \n" +
                            "======", "  __________\n" +
                    "  |          \n" +
                    "  |         O\n" +
                    "  |        /|\\\n" +
                    "  |         \n" +
                    "  |        \n" +
                    "======", "  __________\n" +
                    "  |          \n" +
                    "  |         O\n" +
                    "  |        /|\\\n" +
                    "  |         O\n" +
                    "  |        \n" +
                    "======"
                    , "  __________\n" +
                    "  |          \n" +
                    "  |         O\n" +
                    "  |        /|\\\n" +
                    "  |         O\n" +
                    "  |        / \n" +
                    "======", "  __________\n" +
                    "  |          \n" +
                    "  |         O\n" +
                    "  |        /|\\\n" +
                    "  |         O\n" +
                    "  |        / \\\n" +
                    "======"
                    , "  __________\n" +
                    "  |         | \n" +
                    "  |         O\n" +
                    "  |        /|\\\n" +
                    "  |         O\n" +
                    "  |        / \\\n" +
                    "======"
            };
    Scanner in = new Scanner(System.in);

    public String name;
    public int score = 0;

    public void setName() {
        this.name = in.nextLine();
    }


    public void guessChar(Word word) {
        System.out.println("Guess a letter : ");
        char charGuessed = in.next().charAt(0);
        word.checkCharInWord(charGuessed);
        if (word.wonValidation()) {
            System.out.println("congrats you won");
            score++;
        }
    }

    public void guessWord(Word word) {
        System.out.println("Guess a word : ");
        String wordGuessed = in.next();
        if (Objects.equals(wordGuessed, word.word)) {
            word.maskedWordChar = wordGuessed.toCharArray();
            word.replaceCharInString();
            System.out.println("congrats you won");
            score++;
        } else {
            word.mistakes++;
            word.attemptsNrRemain--;
        }
    }

    public void typeAgain(String thing) {
        System.out.println("Do you want to type another " + thing +
                " ?y/n Y/N");
    }

    public void playerStatus(Word word) {
        if (word.testMistakes()) {
            System.out.println(Collors.TEXT_YELLOW + "\t\tPlayer Status : name -> " + name.toUpperCase() + " | \t Number of attempts left for this word: " + word.attemptsNrRemain + Collors.TEXT_GREEN + "\n\n\tScore :" + score + Collors.TEXT_RED + " \t\t\t Mistakes : " + word.mistakes + "\n\n" +
                    Collors.TEXT_BRIGHT_WHITE + "\tWord : " + word.word + "  " + "\tMasked Word : " + word.maskedWord + Collors.TEXT_RESET + " \n\n\n");
            System.out.println(hangmanMistakes[word.mistakes]);
        } else {
            System.out.println(Collors.TEXT_RED + "You lose \n" +hangmanMistakes[11]+
                    Collors.TEXT_GREEN + "\n The word to be found was : " + word.word);
            word.setWord();
        }


    }


}
