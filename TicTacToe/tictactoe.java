import Game;
import Player;
import java.util.*;

public class TicTacToe {
    public static void main(String[] args) {
        Game game = new Game();
        Scanner input = new Scanner(System.in);

        while (true) {
            game.printBoard();
            System.out.println("Current Player is: " + game.getCurrentPlayer());
            System.out.print("Enter row [0-2]: ");
            int row = input.nextInt();
            System.out.print("Enter column [0-2]: ");
            int col = input.nextInt();

            if (game.makeMove(row, col)) {
                if (game.checkWin()) {
                    game.printBoard();
                    System.out.println("Player " + game.getCurrentPlayer() + " wins!")
                    break;
                }
                if (game.isBoardFull()) {
                    game.printBoard();
                    System.out.println("The game is a tie!");
                    break;
                }
                game.switchPlayer();
            }
            else {
                System.out.println("Invalid Move. Try again.");
            }
        }
    }
}