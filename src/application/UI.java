package application;


import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.List;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.Color;

public class UI {
	
	
		public static ChessPosition readChessPosition(Scanner sc) {
			try {
				String s = sc.nextLine();
				char column = s.charAt(0);
				int row = Integer.parseInt(s.substring(1));
				return new ChessPosition(column, row);
			}
			catch (RuntimeException e) {
				throw new InputMismatchException("Erro lendo posicao");
		}
	}

	public static void printBoard(ChessPiece[][] pieces) {
		for (int i = 0; i < pieces.length; i++) {
			System.out.print((8-i)+ " ");
			for (int j = 0; j < pieces.length; j++) {
				printPiece(pieces[i][j], false);
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h");
	}
	
	public static void printBoard(ChessPiece[][] pieces, boolean[][] possibleMoves) {
		for (int i = 0; i < pieces.length; i++) {
			System.out.print((8-i)+ " ");
			for (int j = 0; j < pieces.length; j++) {
				printPiece(pieces[i][j], possibleMoves[i][j]);
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h");
	}
	
	private static void printPiece(ChessPiece piece, boolean background) {
		if(background && piece == null) {
			System.out.print('x');
		}else {
			if(piece == null && !background){
				System.out.print("-");
			}else {
		if(background && piece != null) {
			System.out.print(piece + "x");
		}else {
			if (piece.getColor() == Color.WHITE) {
				System.out.print(piece + "W");
			}
			else {
			System.out.print(piece+"B");
			}
		}}}
		System.out.print(" ");
			
	}
	
	public static void printMatch(ChessMatch chessMatch, List<ChessPiece> captured) {
		printBoard(chessMatch.getPieces());
		System.out.println();
		printCapturedPieces(captured);
		System.out.println();
		System.out.println("Turno: " + chessMatch.getTurn());
		System.out.println("Esperando jogador da cor: " + chessMatch.getCurrentPlayer());
	}
	
	private static void printCapturedPieces(List<ChessPiece> captured) {
		List<ChessPiece> white = captured.stream().filter(x -> x.getColor() == Color.WHITE).collect(Collectors.toList());
		List<ChessPiece> black = captured.stream().filter(x -> x.getColor() == Color.BLACK).collect(Collectors.toList());
		System.out.println("Pecas capturadas");
		System.out.println("Brancas: ");
		System.out.println(Arrays.toString(white.toArray()));
		System.out.println("Pretas: ");
		System.out.println(Arrays.toString(black.toArray()));
	}
}
