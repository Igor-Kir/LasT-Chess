public abstract class ChessPiece {
    String color;
    boolean check = true;

    public ChessPiece(String color) {
        this.color = color;
    }

    public abstract String getColor();
    public abstract boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);
    public abstract String getSymbol();
    public abstract boolean  isAttackOrEmptyField(ChessBoard chessBoard, int toLine, int toColumn);
    public abstract boolean isEmptyLine(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);
}