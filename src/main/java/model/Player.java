package model;

import java.util.Scanner;

public class Player {
    Scanner in = new Scanner(System.in);

    public String name;
    public int score = 0;

    public void setName() {
        name = in.nextLine();
    }


    public void guessChar(Word word) {
        System.out.println("Guess a letter : ");
        char charGuessed = in.next().charAt(0);
        word.checkCharInWord(charGuessed);
    }

    public void guessWord(Word word) {
        System.out.println("Guess a word : ");
        String wordGuessed = in.next();
        if (word.checkWord(wordGuessed)) {
            word.maskedWordChar = wordGuessed.toCharArray();
            word.replaceCharInString();
            System.out.println("congrats you won");
            score++;
        } else word.mistakes++;
    }

    public void playerStatus(Word word) {
        if (word.mistakesValidation()) {
            setScore(word);
            System.out.println("\t\t Player Status : name -> " + name.toUpperCase() + "\n\n  Score :" + score + " \t\t\t Mistakes : " + word.mistakes + "\n\n" +
                    "\tWord : " + word.word + "  " + "\tMasked Word : " + word.maskedWord + " \n\n\n");
        } else {
            System.out.println("You lose \nThe word to be found was : " + word.word);
            word.setWord();
        }


    }

    public void setScore(Word word) {
        if (word.wordValidation()) {
            score++;
        }
    }

}
