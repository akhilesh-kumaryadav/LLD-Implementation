package Chess.Pieces;

import Chess.Board;
import Chess.Cell;
import Chess.Position;
import Chess.Enums.PieceColour;
import Chess.Enums.PieceType;

public abstract class Piece {
    private PieceColour pieceColour;
    private boolean isCaptured;
    private PieceType pieceType;

    public Piece(PieceColour pieceColour, PieceType pieceType) {
        this.pieceColour = pieceColour;
        this.isCaptured = false;
        this.pieceType = pieceType;
    }

    public PieceColour getColour() {
        return pieceColour;
    }

    public void setColour(PieceColour colour) {
        this.pieceColour = colour;
    }

    public boolean isCaptured() {
        return isCaptured;
    }

    public void setCaptured(boolean captured) {
        this.isCaptured = captured;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    public void setPieceType(PieceType pieceType) {
        this.pieceType = pieceType;
    }

    boolean isPathClear(Board board, Cell start, Cell end) {
        int rowDir = Integer.compare(end.getPosition().getRow() - start.getPosition().getRow(), 0);
        int colDir = Integer.compare(end.getPosition().getCol() - start.getPosition().getCol(), 0);

        int currentRow = start.getPosition().getRow() + rowDir;
        int currentCol = start.getPosition().getCol() + colDir;

        while (currentRow != end.getPosition().getRow() || currentCol != end.getPosition().getCol()) {
            if (board.getCell(new Position(currentRow, currentCol)).getPiece() != null) {
                return false;
            }

            currentRow += rowDir;
            currentCol += colDir;
        }

        return true;
    }

    public abstract boolean isValidMove(Board board, Cell start, Cell end);

    @Override
    public String toString() {
        String symbol = switch (this.pieceType) {
            case KING -> "K";
            case QUEEN -> "Q";
            case BISHOP -> "B";
            case ROOK -> "R";
            case KNIGHT -> "N";
            case PAWN -> "P";
        };

        return this.pieceColour == PieceColour.WHITE ? symbol : symbol.toLowerCase();
    }
}