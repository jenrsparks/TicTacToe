import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Random;

public class TicTacToe {
	public static void main(String[] args) {

		// variables
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		int board[][] = new int[3][3];
		String input = "";
		int x = 0, y = 0;
		int player = 0;
		Random rand = new Random();

		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				board[i][j] = rand.nextInt();		// denotes empty space
			} // j
		} // i

		// title
		System.out.println("Welcome to Tic Tac Toe! Play against your friends and see who's the best!");
		System.out.println("");

		while( gameOver(board) != 1 ) {

			// change player
			if(player == 1) {
				player++;
			} else {
				player = 1;
			}

			// draw board
			showBoard(board);

			// display turn
			showTurn(player);

			while(true) {
				try {
					// prompt for choice in x/y coordinates
					System.out.print("\tWhat row would you like to place your piece in? ");
					input = console.readLine();
					x = Integer.parseInt(input) - 1;
					System.out.print("\tWhat column would you like to place your piece in? ");
					input = console.readLine();
					y = Integer.parseInt(input) - 1;
				} catch(Exception e) {
					System.out.println("Position out of bounds.");
				}
				if(board[x][y] != 1 && board[x][y] != 2) {
					board = placePiece(player, x, y, board);
					break;
				} else {
					System.out.println("Error: That position is already full. Please choose another position.");
				}
			} // while

		} // while

		showBoard(board);
		System.out.println("Player " + player + " wins.");
	} // psvm

	static int[][] placePiece(int player, int x, int y, int board[][]) {
		board[x][y] = player;
		return board;
	}

	static void showBoard(int board[][]) {

		System.out.println("   1   2   3");
		System.out.println("");
		for(int i = 0; i < 3; i++) {
			System.out.print(i+1);
			System.out.print(" ");
			for(int j = 0; j < 3; j++) {
				if(board[i][j] == 1) {
					System.out.print( " x ");
				} else if(board[i][j] == 2) {
					System.out.print( " o " );
				} else {
					System.out.print( "   " );
				} // print piece
				if( j < 2) {
					System.out.print( "|" );
				} // divider
			} // j
			if(i < 2) {
				System.out.println("");
				System.out.println( "   -----------" );
			}
		} // i
		System.out.println("");
	} // showBoard

	static void showTurn(int player) {
		System.out.println("");
		if(player == 1) {
			System.out.println("Player 1:");
		} else {
			System.out.println("Player 2:");
		}
	}

	static int gameOver(int board[][]) {
		if(board[0][0] == board[0][1] && board[0][0] == board[0][2]) {				// '-'
			return 1;
		} else if( board[1][0] == board[1][1] && board[1][1] == board[1][2] ) {		// '-'
			return 1;
		} else if( board[2][0] == board[2][1] && board[2][1] == board[2][2] ) {		// '-'
			return 1;
		} else if( board[0][0] == board[1][0] && board[1][0] == board[2][0] ) {		// '|'
			return 1;
		} else if( board[0][1] == board[1][1] && board[1][1] == board[2][1] ) {		// '|'
			return 1;
		} else if( board[0][2] == board[1][2] && board[1][2] == board[2][2] ) {		// '|'
			return 1;
		} else if( board[0][0] == board[1][1] && board[1][1] == board[2][2] ) {		// '\'
			return 1;
		} else if( board[2][0] == board[1][1] && board[1][1] == board[0][2] ) {		// '/'
			return 1;
		} else {																	// not done
			return 0;
		}
	} // gameOver

} // public class test