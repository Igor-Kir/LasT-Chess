public class Pawn extends ChessPiece {
    public Pawn(String color) {
        super(color);
        int direction;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        int dir;
        int startPos;
        if (getColor().equals("White")) {
            dir = 1;
            startPos = 1;
        } else if (getColor().equals("Black")) {
            dir = -1;
            startPos = 6;
        } else return false;
        if ((toLine < 8 && toLine >= 0) && (toColumn < 8 && toColumn >= 0)) {
            if (!(line == toLine && column == toColumn)) {
                if (column == toColumn) {
                    if (line + 2 * dir == toLine && line == startPos) {
                        return true;
                    } else {
                        return line + dir == toLine;
                    }
                } else return false;
            } else return false;
        } else return false;
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
    public boolean isAttackOrEmptyField(ChessBoard chessBoard, int toLine, int toColumn) {
        if (chessBoard.board[toLine][toColumn] == null) {
            return true;
        } else return !(chessBoard.board[toLine][toColumn].getColor().equals(getColor()));
    }

    @Override
    public String getSymbol () {
        return "P";
    }
}
