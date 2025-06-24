package chess;

import boardgame.Board;
import boardgame.BoardException;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch { //regras do jogo
    private Board board;

    public ChessMatch() {
        this.board = new Board(8, 8); //define as dimensões do tabuleiro.
        initialSetup();
    }

    public ChessPiece[][] getPieces() {
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];

        for (int i = 0; i < board.getRows(); i++){
            for(int j = 0; j < board.getColumns();j++){
                mat[i][j] = (ChessPiece) board.piece(i, j);
            }
        }

        return mat;
    }

    public void placeNewPiece(char column, int row,Piece piece){
        board.placePiece(piece, new ChessPosition(column, row).toPosition());
        
    }

    public void initialSetup(){
        placeNewPiece('a', 8, new Rook(board, Color.WHITE));
        placeNewPiece('h', 8    , new Rook(board, Color.WHITE));
        placeNewPiece('e', 8, new King(board, Color.BLACK));
            placeNewPiece('e', 1, new King(board, Color.WHITE));
    }

    public ChessPiece performChessPosition(ChessPosition sourceChessPosition, ChessPosition targetChessPosition){
        Position source = sourceChessPosition.toPosition();
        Position target = targetChessPosition.toPosition();
        validateSourcePosition(source);
        Piece capturedPiece = makeMove(source, target);
        
         return (ChessPiece) capturedPiece;
    }

    private Piece makeMove(Position source, Position target){
    Piece p = board.removePiece(source);
    Piece capturedPiece = board.removePiece(target);
    board.placePiece(p, target);
    return capturedPiece;
    }

    private void validateSourcePosition(Position position) {
       if (!board.thereIsPiece(position)) {
        throw new BoardException("There in no on source position");
       }
    }

}
