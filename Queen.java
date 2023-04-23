public class Queen extends ChessPiece {
    public Queen(String color) {
        super(color);
    }
    @Override
    public String getColor() {
        return this.color;
    }
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if ((toLine < 8 && toLine >= 0) && (toColumn < 8 && toColumn >= 0)) {
            if (!(line == toLine && column == toColumn)) {
                if (column == toColumn) {
                }
                if ((Math.abs(toLine - line) == Math.abs(toColumn - column)) || (line == toLine || column == toColumn)) {
                    return true;
                } else return false;
            } else return false;
        } else return false;
    }
    @Override
    public boolean isAttackOrEmptyField(ChessBoard chessBoard, int toLine, int toColumn) {
        if (chessBoard.board[toLine][toColumn] == null) {
            return true;
        } else return !(chessBoard.board[toLine][toColumn].getColor().equals(getColor()));
    }
    @Override
    public boolean isEmptyLine(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        boolean isEmpty = true;
        int dirX = Integer.compare(toLine, line);
        int dirY = Integer.compare(toColumn, column);
        int lineLength;
        if (dirY == 0) {
            lineLength = Math.abs(toLine - line);
        } else if (dirX == 0) {
            lineLength = Math.abs(toColumn - column);
        } else lineLength = Math.abs(toColumn - column);
        for (int i = 1; i < lineLength; i++) {
            if (chessBoard.board[line + i * dirX][column + i * dirY] != null) {
                isEmpty = false;
                break;
            }
        }
        return isEmpty;
    }
    @Override
    public String getSymbol () {
        return "Q";
    }
}