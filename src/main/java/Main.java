import cdn.Collors;
import model.Player;
import model.Word;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    static int chose;
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        Word word;
        Player player;
        word = new Word("src/main/resources/words.txt");

        char charChose = 'n';
        System.out.println(" WELCOME TO HANGMAN GAME \n");
        do {
            playerMenu();
            chose = in.nextInt();
            switch (chose) {
                case 1:
                    player = new Player();
                    wordReset(word);
                    System.out.println("Set a name : ");
                    player.setName();
                    do {
                        while (chose != 0) {
                            player.playerStatus(word);
                            menuWord();
                            switch (chose) {
                                case 1:
                                    wordReset(word);
                                    break;
                                case 2:
                                    player.guessChar(word);
                                    player.playerStatus(word);
                                    System.out.println("Do you want to type another letter ?y/n Y/N");
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
                                        System.out.println("Do you want to guess another letter ?y/n Y/N");
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
                                    System.out.println("Do you want to guess another word ?y/n Y/N");
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
                                        System.out.println("Do you want to type another letter ?y/n Y/N");
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

            System.out.println("Do you want to start playing like another user? press 1 or 0 to exit");
            chose = in.nextInt();
        } while (chose != 0);

    }

    public static void playerMenu() {
        System.out.println("PRESS :\n 1->Start Game \n 0->GET OUT OF  THE PROGRAM");
    }

    public static void menuWord() {
        System.out.println(Collors.TEXT_BRIGHT_GREEN + "PRESS :\n1->CHOSE TO Another  WORD \n2->GUESS A CHAR  \n3->GUESS A WORD  \n0->GET OUT OF THE PROGRAM");
        chose = in.nextInt();
    }

    public static void wordReset(Word word) {
        word.attemptsNrRemain = 11;
        word.mistakes = 0;
        word.setWord();
    }

}
