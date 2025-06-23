package boardgame;

public class Board {
    private Integer rows;
    private Integer columns;
    private Piece[][] pieces;

    public Board(Integer rows, Integer columns){
        if(rows < 1 || columns < 1){
            throw new BoardException("Error Creating Board: there must be at least 1 row and 1 column");
        } 

        this.columns = columns;
        this.rows = rows;
        this.pieces = new Piece[rows][columns];
    }

    public Integer getRows() {
        return rows;
    }

 
    public Integer getColumns() {
        return columns;
    }

    

    public Piece[][] getPieces() {
        return pieces;
    }

    public Piece piece(int row, int column){ 
        if (!positionExists(row, column)) {
            throw new BoardException("Position not on board");
        }
        return pieces[row][column];
    }
    public Piece piece(Position position){ // pega uma possivel peça a partir do Position
        if (!positionExists(position)) {
            throw new BoardException("Position not on board");
        }
        return pieces[position.getRow()][position.getColumn()];

    }
    public void placePiece (Piece piece, Position position){
        if (thereIsPiece(position)) {
            throw new BoardException("piece already exists on position "+ position);
        }

        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
        
    }

    public boolean positionExists(int row, int column){
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    public boolean positionExists(Position position){
          return position.getRow() >= 0 && position.getRow() < rows && position.getColumn() >= 0 && position.getColumn() < columns;
    }

    public boolean thereIsPiece(Position position){
        if (!positionExists(position)) {
            throw new BoardException("position not on the board");
        }
        return piece(position) != null;
    }

    
}
