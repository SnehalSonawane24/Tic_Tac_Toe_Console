package tictactoe;

import java.util.Scanner;
public class TicTacToe {
	private player player1, player2;
	private Board board;
	private int numPlayers;
	
	public static void main(String[] args) {
		TicTacToe t = new TicTacToe();
		t.startGame();
	}
	public void startGame() {
		Scanner s = new Scanner(System.in);
		// Take players input 
		//numPlayers++;
		player1 = takePlayerInput(++numPlayers);
		player2 = takePlayerInput(++numPlayers);
		while(player1.getSymbol() == player2.getSymbol()) {
			System.out.println("Symbol is alredy taken!! please enter the symbol again ");
			player2.setSymbol(s.next().charAt(0));
		}
		// Create a board
		board = new Board(player1.getSymbol(), player2.getSymbol());
		// Play the game
		boolean player1Turn = true;
		int status = Board.INCOMPLETE;
		while(status==Board.INCOMPLETE || status == Board.INVALIDMOVE ) {
			if(player1Turn) {
				System.out.println("Player 1 - " + player1.getName() + "s turn");
				System.out.println("Enter x: ");
				int x = s.nextInt();
				System.out.println("Enter y : ");
				int y = s.nextInt();
				
				status = board.move(player1.getSymbol(), x, y);
				if(status == Board.INVALIDMOVE) {
					System.out.println("Invalid move!! please try again!!");
					continue;
				}
				
				//move function decides to make a move and tell us the status as well
				// it return int (int can take multiple values)
				// 1 means player1 win
				// 2 means player2 win
				// 3 means draw
				// 4 means game is incomplete 
				// 5 means invalid move
			}else {
				System.out.println("Player 2 - " + player2.getName() + "s turn");
				System.out.println("Enter x: ");
				int x = s.nextInt();
				System.out.println("Enter y : ");
				int y = s.nextInt();
				
				status = board.move(player2.getSymbol(), x, y);
				if(status == Board.INVALIDMOVE) {
					System.out.println("Invalid move!! please try again!!");
					continue;
				}
			}
				player1Turn = !player1Turn;
				board.print();
		}
		if(status == Board.PLAYER1WINS) {
			System.out.println("Player 1 -" + player1.getName()+ "wins !!");
		}else if(status == Board.PLAYER2WINS){
			System.out.println("Player 2 -" + player2.getName()+ "wins !!");
		}else {
			System.out.println("Draw!!");
		}
	}
	private player takePlayerInput(int num) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Player " +num+ " name: ");
		String name = s.nextLine();
		System.out.println("Enter Player " +num+ " symbol:");
		char symbol = s.next().charAt(0);
		player p =new player(name, symbol);
		return p;
		
	}
}
