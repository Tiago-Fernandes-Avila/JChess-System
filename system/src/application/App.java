package application;

import java.io.IOException;
import java.util.Scanner;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class App {
    public static void main(String[] args) throws InterruptedException, IOException {
        ChessMatch chessMatch = new ChessMatch();
        Scanner sc = new Scanner(System.in);
        while (true) {
       UI.printBoard(chessMatch.getPieces());
    
        System.out.println();
        System.out.print("source: ");
        ChessPosition source = UI.readChessPosition(sc);

        System.out.println();
        System.out.print("target: ");
        ChessPosition target = UI.readChessPosition(sc);

        ChessPiece capturedChessPiece = chessMatch.performChessPosition(source, target);
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
        
      

    }
}
