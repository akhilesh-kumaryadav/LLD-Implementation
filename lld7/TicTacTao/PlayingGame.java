package TicTacTao;

import TicTacTao.Modal.GameStatus;

public class PlayingGame {
    public static void main(String[] args) {
        System.out.println("\n===> Tic Tac Tao Game <===\n");
        TicTacTaoGame game = new TicTacTaoGame();
        game.initializeGame();

        GameStatus status = game.startGame();
        System.out.print("\n ===> Game Over <=== \n");

        switch (status) {
            case WIN:
                System.out.print(game.winner.name + " won the game.");
                break;
            case DRAW:
                System.out.print("Its a Draw!");
                break;
            default:
                System.out.print("Game Ends.");
                break;
        }
    }
}