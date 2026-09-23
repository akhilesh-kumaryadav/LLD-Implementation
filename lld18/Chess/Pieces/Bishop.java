package Chess.Pieces;

import Chess.Board;
import Chess.Cell;
import Chess.Enums.PieceColour;
import Chess.Enums.PieceType;

public class Bishop extends Piece {
    public Bishop(PieceColour colour) {
        super(colour, PieceType.BISHOP);
    }

    @Override
    public boolean isValidMove(Board board, Cell start, Cell end) {
        if (start.equals(end)) {
            return false;
        }

        // If the target cell has piece of the same colour, then its invalid move
        if (end.getPiece() != null && end.getPiece().getColour() == start.getPiece().getColour()) {
            return false;
        }

        // If the target cell is not diagonal to the start cell, then it is invalid move
        int rowDiff = Math.abs(end.getPosition().getRow() - start.getPosition().getRow());
        int colDiff = Math.abs(end.getPosition().getCol() - start.getPosition().getCol());

        if (rowDiff == colDiff && isPathClear(board, start, end)) {
            Piece targetPiece = board.getCell(end.getPosition()).getPiece();

            return targetPiece == null || targetPiece.getColour() != start.getPiece().getColour();
        }

        return false;
    }
}