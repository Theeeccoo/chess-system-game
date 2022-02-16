package boardgame;

public abstract class Piece {

    protected Position position;
    private Board board;

    public Piece(Board board) {
        position = null;
        this.board = board;
    }

    protected Board getBoard() {
        return board;
    }

    public abstract boolean[][] possibleMoves();

    public boolean possibleMove(Position position){
        return possibleMoves()[position.getRow()][position.getColumn()];
    }

    public boolean isThereAnyPossibleMove(){
        boolean[][] m = possibleMoves();
        boolean resp = false;

        for (int i = 0; i < m.length; i++){
            for (int j = 0; j < m.length; j++){
                if (m[i][j]){
                    resp = true;
                    i = j = m.length;
                }
            }
        }
        return resp;
    }
}
