package ai;

import cdn.Collors;
import model.Player;
import model.Word;

import java.util.InputMismatchException;
import java.util.Scanner;
public class GameController {
    public static int chose=0;

    static Scanner in = new Scanner(System.in);
    public static void playTheGame(int chose, Player player, Word word) {
        char charChose;
        GameController.chose =chose;
        switch (GameController.chose) {
            case 1:
                wordReset(word);
                System.out.println("Set a name : ");
                player.setName();
                do {
                    while (GameController.chose != 0) {
                        player.playerStatus(word);
                        menuWord();
                        switch (GameController.chose) {
                            case 1:
                                wordReset(word);
                                break;
                            case 2:
                                player.guessChar(word);
                                player.playerStatus(word);
                                player.typeAgain(" letter ") ;
                                charChose = in.next().charAt(0);
                                while (charChose == 'y' || charChose == 'Y') {
                                    if (!word.testMistakes() || word.wonValidation()) {
                                        wordReset(word);
                                        break;
                                    }
                                    player.guessChar(word);
                                    player.playerStatus(word);
                                    if (!word.testMistakes() || word.wonValidation()) {
                                        break;
                                    }
                                    player.typeAgain(" letter ") ;
                                    charChose = in.next().charAt(0);
                                }
                                break;
                            case 3:
                                if (!word.testMistakes() || word.wonValidation()) {
                                    break;
                                }
                                player.guessWord(word);
                                player.playerStatus(word);
                                if (!word.testMistakes() || word.wonValidation()) {
                                    break;
                                }
                                player.typeAgain(" word ") ;
                                charChose = in.next().charAt(0);
                                while (charChose == 'y' || charChose == 'Y') {
                                    if (!word.testMistakes() || word.wonValidation()) {
                                        break;
                                    }
                                    player.guessWord(word);
                                    player.playerStatus(word);
                                    if (!word.testMistakes() || word.wonValidation()) {
                                        break;
                                    }
                                    player.typeAgain("word") ;
                                    charChose = in.next().charAt(0);
                                }
                                break;
                            default:
                                System.out.println("Enter a valid number :");
                                menuWord();
                                break;
                        }
                        if (!word.testMistakes() || word.wonValidation()) {
                            break;
                        }
                    }
                    System.out.println("Do you want to play again ? press 1 or 0 to exit");
                    try {
                        GameController.chose= in.nextInt();
                    }
                    catch (InputMismatchException e){
                        errorInputMessage();
                        GameController.chose=0;
                    }
                    if (GameController.chose == 1) {
                        wordReset(word);
                    }

                } while (GameController.chose != 0);
                break;


            case 0:
                break;
            default:
                System.out.println("Enter a valid number :");
                playerMenu();
                break;
        }


    }

    public static void playerMenu() {
        System.out.println("PRESS :\n 1->Start Game \n 0->GET OUT OF  THE PROGRAM");
        try {
            chose = in.nextInt();
        } catch (InputMismatchException e) {
            errorInputMessage();
           playerMenu();
        }
    }

    public static void menuWord() {
        System.out.println(Collors.TEXT_BRIGHT_GREEN + "PRESS :\n1->CHOSE TO Another  WORD \n2->GUESS A CHAR  \n3->GUESS A WORD  \n0->GET OUT OF THE PROGRAM");
        try {
            chose = in.nextInt();
        } catch (InputMismatchException e) {
            errorInputMessage();
            menuWord();
        }
    }

    public static void wordReset(Word word) {
        word.attemptsNrRemain = 11;
        word.mistakes = 0;
        word.setWord();
    }




    public static void errorInputMessage(){
        System.out.println("your value is incorrect");
    }
}
