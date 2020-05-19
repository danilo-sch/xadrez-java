package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import boardGame.Board;
import boardGame.Position;
import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ChessMatch cm = new ChessMatch();
		
		while(true) {
			try{
				UI.printBoard(cm.getPieces());
				System.out.println();
				System.out.println("Soruce: ");
				ChessPosition source = UI.readChessPosition(sc);
				
				boolean[][] possibleMoves = cm.possibleMoves(source);
				UI.printBoard(cm.getPieces(), possibleMoves);
			
				System.out.println();
				System.out.println("Target: ");
				ChessPosition target = UI.readChessPosition(sc);
			
				ChessPiece capturedPiece = cm.performChessMove(source, target);
		} catch(ChessException e){
			System.out.println(e.getMessage());
			sc.nextLine();
		}
		  catch(InputMismatchException e){
			 System.out.println(e.getMessage());
			 sc.nextLine();
			}
	  }
	}

}
