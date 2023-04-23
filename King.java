public class King extends ChessPiece {

    public King(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if ((toLine < 8 && toLine >= 0) && (toColumn < 8 && toColumn >= 0)) {
            if (!(line == toLine && column == toColumn)) {
                if ((Math.abs(toLine - line) == 1 && Math.abs(toColumn - column) == 1)
                        || ((Math.abs(toLine - line) == 1 && Math.abs(toColumn - column) == 0)
                        || (Math.abs(toLine - line) == 0 && Math.abs(toColumn - column) == 1))) {
                    return true;
                } else return false;
            } else return false;
        } else return false;
    }

    @Override
    public String getSymbol () {
        return "K";
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
    public boolean isUnderAttack(ChessBoard  chessBoard, int line, int column){
        boolean isUnderAttack = false;
        for (int i = 0; i < 8; i++) {
            for (int y = 0; y < 8; y++) {
                if (  chessBoard.board[ i][y] !=null){
                    if (!chessBoard.board[i][y].getColor().equals(color)) {
                        if (chessBoard.board[i][y].canMoveToPosition(chessBoard, i, y, line, column)) {
                            isUnderAttack = true;
                        }
                    }
                }
            }
        }
        return isUnderAttack;
    }
}