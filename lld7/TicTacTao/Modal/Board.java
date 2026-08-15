package TicTacTao.Modal;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Board {
    public int size;
    public PlayingPiece[][] board;

    public Board(int size) {
        this.size = size;
        this.board = new PlayingPiece[size][size];
    }

    public boolean addPiece(int row, int col, PlayingPiece playingPiece) {
        if (row <= 0 || row > size || col <= 0 || col > size) {
            return false;
        }

        if (board[row - 1][col - 1] != null) {
            return false;
        }

        board[row - 1][col - 1] = playingPiece;
        return true;
    }

    public List<Map.Entry<Integer, Integer>> getFreeCells() {
        List<Map.Entry<Integer, Integer>> freeCells = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == null) {
                    Map.Entry<Integer, Integer> rowCol = new AbstractMap.SimpleEntry<>(i, j);
                    freeCells.add(rowCol);
                }
            }
        }

        return freeCells;
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] != null) {
                    System.out.print(board[i][j].pieceType.name() + "   ");
                } else {
                    System.out.print("    ");
                }

                System.out.print(" | ");
            }
            System.out.println();
        }
    }
}