package ai;

import cdn.Collors;
import model.Player;
import model.Word;

import java.util.Scanner;

public class GameController {
    static Scanner in = new Scanner(System.in);
    public static void playTheGame(int chose, Player player, Word word) {
        char charChose;
        switch (chose) {
            case 1:
                wordReset(word);
                System.out.println("Set a name : ");
                player.setName();
                do {
                    while (chose != 0) {
                        player.playerStatus(word);
                        menuWord();
                        chose = in.nextInt();
                        switch (chose) {
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
                                chose = in.nextInt();
                                break;
                        }
                        if (!word.testMistakes() || word.wonValidation()) {
                            break;
                        }
                    }
                    System.out.println("Do you want to play again ? press 1 or 0 to exit");
                    chose = in.nextInt();
                    if (chose == 1) {
                        wordReset(word);
                    }

                } while (chose != 0);
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
    }

    public static void menuWord() {
        System.out.println(Collors.TEXT_BRIGHT_GREEN + "PRESS :\n1->CHOSE TO Another  WORD \n2->GUESS A CHAR  \n3->GUESS A WORD  \n0->GET OUT OF THE PROGRAM");
    }

    public static void wordReset(Word word) {
        word.attemptsNrRemain = 11;
        word.mistakes = 0;
        word.setWord();
    }
}
