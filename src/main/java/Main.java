import ai.GameController;
import model.Player;
import model.Word;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {
        Player player = new Player();
        Word word = new Word();
        Scanner in = new Scanner(System.in);
        System.out.println(" WELCOME TO HANGMAN GAME \n");
        do {
            GameController.playerMenu();
            if (GameController.chose==1){
                GameController.playTheGame(GameController.chose, player, word);
            }
            System.out.println("Do you want to start playing like another user? press 1 or 0 to exit");
            try {
                GameController.chose=in.nextInt();
            }
            catch (InputMismatchException e){
               GameController.errorInputMessage();
               GameController.playerMenu();
            }
        } while (GameController.chose != 0);

    }

}
