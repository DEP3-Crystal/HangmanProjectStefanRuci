package model;

import dao.Words;

import java.io.IOException;
import java.util.Scanner;

public class Player {
    Scanner in = new Scanner(System.in);

    public String name;
    public int score = 0;

    public void setName() {
        name = in.nextLine();
    }


    public void guessChar(Words word ) {
        System.out.println("Guess a letter : ");
        char charGuessed = in.next().charAt(0);
        word.checkCharInWord(charGuessed);
    }

    public void guessWord(Words word ) {
        System.out.println("Guess a word : ");
        String wordGuessed=in.next();
        if (word.checkWord(wordGuessed)) {
            word.maskedWordChar=wordGuessed.toCharArray();
            word.replaceCharInString();
            System.out.println("congrats you won");
            score++;
        } else word.mistakes++;
    }

    public void playerStatus(Words word) {
        if (word.mistakesValidation()) {
            setScore(word);
            System.out.println("\t\t Player Status :" + name + "\n\n  Score :" + score + " \t\t\t Mistakes : " + word.mistakes + "\n\n" +
                    "\t  Word : " + word.word + "  "+"\t Masked Word : " + word.maskedWord + " \n\n\n");
        }
        else{
            System.out.println("You lose ");
        }


    }

    public void setScore(Words word ) {
        if (word.wordValidation()) {
            score++;
        }
    }

}
