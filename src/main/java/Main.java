import ai.GameController;
import model.Player;
import model.Word;

import java.io.IOException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {
        Player player = new Player();
        Word word = new Word();
        Scanner in = new Scanner(System.in);
        int chose;
        System.out.println(" WELCOME TO HANGMAN GAME \n");
        do {
            GameController.playerMenu();
            chose = in.nextInt();
            GameController.playTheGame(chose, player, word);
            System.out.println("Do you want to start playing like another user? press 1 or 0 to exit");
            chose = in.nextInt();
        } while (chose != 0);

    }

}
