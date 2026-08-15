package TicTacTao;

import TicTacTao.Modal.*;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TicTacTaoGame {
    Deque<Player> players;
    Board gameBoard;
    Player winner;

    public void initializeGame() {
        players = new LinkedList<>();
        PlayingPieceX xPiece = new PlayingPieceX();
        Player playerX = new Player("PlayerX", xPiece);

        PlayingPieceO oPiece = new PlayingPieceO();
        Player playerO = new Player("PlayerO", oPiece);

        players.add(playerX);
        players.add(playerO);

        gameBoard = new Board(3);
    }

    public GameStatus startGame() {
        boolean noWinner = true;

        while (noWinner) {
            Player currentPlayer = players.removeFirst();

            gameBoard.printBoard();

            List<Map.Entry<Integer, Integer>> freeSpaces = gameBoard.getFreeCells();
            if (freeSpaces.isEmpty()) {
                noWinner = false;
                continue;
            }

            System.out.println("Player: " + currentPlayer.name + " - Please enter [row, column]: ");
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            int inputRow = Integer.valueOf(values[0].trim());
            int inputColumn = Integer.valueOf(values[1].trim());

            boolean validMove = gameBoard.addPiece(inputRow, inputColumn, currentPlayer.playingPiece);
            if (!validMove) {
                System.out.println("Incorrect position chosen, try again!");
                players.addFirst(currentPlayer);
                continue;
            }

            players.addLast(currentPlayer);

            boolean isWinner = checkForWinner(inputRow, inputColumn, currentPlayer.playingPiece.pieceType);
            if (isWinner) {
                gameBoard.printBoard();
                winner = currentPlayer;
                return GameStatus.WIN;
            }
        }

        return GameStatus.DRAW;
    }

    public boolean checkForWinner(int row, int column, PieceType pieceType) {
        row--;
        column--;
        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        for (int i = 0; i < gameBoard.size; i++) {
            if (gameBoard.board[i][column] == null || gameBoard.board[i][column].pieceType != pieceType) {
                rowMatch = false;
                break;
            }
        }

        for (int i = 0; i < gameBoard.size; i++) {
            if (gameBoard.board[row][i] == null || gameBoard.board[row][i].pieceType != pieceType) {
                columnMatch = false;
                break;
            }
        }

        for (int i = 0, j = 0; i < gameBoard.size; i++, j++) {
            if (gameBoard.board[i][j] == null || gameBoard.board[i][j].pieceType != pieceType) {
                diagonalMatch = false;
                break;
            }
        }

        for (int i = 0, j = 0; i < gameBoard.size; i++, j++) {
            if (gameBoard.board[i][j] == null || gameBoard.board[i][j].pieceType != pieceType) {
                antiDiagonalMatch = false;
                break;
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }
}