import dao.Words;
import model.Player;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    static int chose;
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        Words word;
        Player player;
//        System.out.println(Words.words);
        System.out.println(" WELCOME TO HANGMAN GAME \n");
        do {
            playerMenu();
            chose = in.nextInt();
            switch (chose) {
                case 1:
                    player = new Player();
                    word = new Words();
                    word.setWord();
                    System.out.println("Set a name : ");
                    player.setName();
                    while (chose != 0) {
                        player.playerStatus(word);
                        menuWord();
                        if (chose == 1) {
                            word.setWord();
                        } else if (chose == 2) {
                            player.guessChar(word);
                        } else if (chose == 3) {
                            player.guessWord(word);
                        } else {
                            System.out.println("Enter a valid number :");
                        }
                    }
                case 0:
                    break;
                default:
                    System.out.println("Enter a valid number :");

            }
            System.out.println("Do you want to play again ? press 1 or 0 to exit");
            chose = in.nextInt();
        } while (chose != 0);

    }

    public static void playerMenu() {
        System.out.println("PRESS :\n 1->Start Game \n 0->GET OUT OF  THE PROGRAM");
    }

    public static void menuWord() {
        System.out.println("PRESS :\n1->CHOSE TO Another  WORD \n2->GUESS A CHAR  \n3->GUESS A WORD  \n0->GET OUT OF THE PROGRAM");
        chose= in.nextInt();

    }

}
