package chess;

import boardgame.Position;

public class ChessPosition {
    private int row;
    private int column;

    public ChessPosition(char column, int row){
        if (column < 'a' || column > 'h' || row < 1 || row > 8){
            throw new ChessException("Error instantiating Chess Position");
        }
        this.column = column;
        this.row = row;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

   protected Position toPosition(){
   return new Position(8 - row, column - 'a');
   }

   protected static ChessPosition toChessPosition(Position position){
    //1, 1 transformar em 7, b chessPos = 8 - posMatrix = 7; 0 = 'a' - 97; 'a' -'b'
    return  new ChessPosition((char) ('a' - position.getColumn()) , position.getRow() - 8);
   }

   @Override
   public String toString(){
    return "" + getRow() + getColumn();
   }
    
}
