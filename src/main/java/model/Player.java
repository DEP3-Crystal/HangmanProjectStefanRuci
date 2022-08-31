package model;
import  cdn.Collors;
import java.util.Scanner;

public class Player {
    Scanner in = new Scanner(System.in);

     String name;
     int score = 0;

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
        if (word.wonValidation()) {
            word.maskedWordChar = wordGuessed.toCharArray();
            word.replaceCharInString();
            System.out.println("congrats you won");
            score++;
        } else {
            word.mistakes++;
            word.attemptsNrRemain--;
        }
    }

    public void playerStatus(Word word) {
        if (word.testMistakes()) {
            System.out.println(Collors.TEXT_YELLOW+ "\t\tPlayer Status : name -> " + name.toUpperCase() +" | \t Number of attempts left for this word: "+word.attemptsNrRemain+ Collors.TEXT_GREEN + "\n\n\tScore :" + score + Collors.TEXT_RED+" \t\t\t Mistakes : " + word.mistakes + "\n\n" +
                   Collors.TEXT_BRIGHT_WHITE+ "\tWord : " + word.word + "  " + "\tMasked Word : " + word.maskedWord + Collors.TEXT_RESET+" \n\n\n");
        } else {
            System.out.println(Collors.TEXT_RED+"You lose \n" +
                    Collors.TEXT_GREEN+"The word to be found was : " + word.word);
            word.setWord();
        }


    }


}
