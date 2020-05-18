package application;

import java.util.Scanner;

import boardGame.Board;
import boardGame.Position;
import chess.ChessMatch;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ChessMatch cm = new ChessMatch();
		
		while(true) {
		UI.printBoard(cm.getPieces());
		System.out.println();
		System.out.println("Soruce: ");
		ChessPosition source = UI.readChessPosition(sc);
		}
	}

}
