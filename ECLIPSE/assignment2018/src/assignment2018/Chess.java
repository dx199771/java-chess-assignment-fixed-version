package assignment2018;
import sheffield.*;
import javax.swing.*;
import assignment2018.codeprovided.Pieces;

/**
* Chess Class
* Use to initialize the chess game.
* @author Xu Dong
* @version 1.0 09/05/2018
*/
public class Chess extends JFrame{
	static EasyReader keyboard = new EasyReader(); 
	private Pieces pieces;

	public static void main(String args []){
	System.out.println("1.Text display");
	System.out.println("2.Graphical display?");
	
	int display = keyboard.readInt("Your choice (type the number):\n");
	//get display type
		if(display == 1){
			//create a new board
			Board board = new Board();
			//create a new text display
			TextDisplay textDisplay = new TextDisplay(board);
			//create two pieces
			Pieces piecesOne = new Pieces(board,1);
			Pieces piecesTwo = new Pieces(board,0);
			System.out.println("-------------------------------------");
			System.out.println("Which player you want to play with?");
			System.out.println("1.play with human player");
			System.out.println("2.play with random AI player");
			System.out.println("3.p1lay with aggressive AI player");
			System.out.println("-------------------------------------");
			//get player type
			int player = keyboard.readInt("Your choice (type the number):\n");
			
			if(player == 1){
				//get players' names
				String name1 = keyboard.readString("Player1's name:\n");
				String name2 = keyboard.readString("Player2's name:\n");
				//create new human player
				HumanPlayer player1 = new HumanPlayer(name1,piecesOne,board,null);
				HumanPlayer player2 = new HumanPlayer(name2,piecesTwo,board,null);
				player1.setOpponent(player2);
				player2.setOpponent(player1);
				//display board
				textDisplay.displayBoard(piecesOne);
				//ask a move from player
				player2.askMoveText(player1, player2, piecesOne, piecesTwo,textDisplay,board);
			}
			if(player == 2){
				//get player's name
				String name1 = keyboard.readString("Player1's name:\n");
				//create a human player and 
				//a random AI player
				HumanPlayer player1 = new HumanPlayer(name1,piecesOne,board,null);
				RandomPlayer player2 = new RandomPlayer("Random Player",piecesTwo,board,null);
				player1.setOpponent(player2);
				player2.setOpponent(player1);
				//display board
				textDisplay.displayBoard(piecesOne);
				//ask human player a move
				player2.askMoveText(player1, player2, piecesOne, piecesTwo,textDisplay,board);
			}
			if(player==3){
				//get player's name
				String name1 = keyboard.readString("Player1's name:\n");
				//create a human player and 
				//a Aggressive AI player
				HumanPlayer player1 = new HumanPlayer(name1,piecesOne,board,null);
				AggressivePlayer player2 = new AggressivePlayer("Aggressive Player",piecesTwo,board,null);
				player1.setOpponent(player2);
				player2.setOpponent(player1);
				//display board
				textDisplay.displayBoard(piecesOne);
				//ask human player a move
				player2.askMoveText(player1, player2, piecesOne, piecesTwo,textDisplay,board);
			}
		}
		//get display type
		else if(display==2){
		//create a graphical display
		GraphicalDisplay chessBoard = new GraphicalDisplay();
		//display board
		chessBoard.displayBoard();
		chessBoard.setLocationRelativeTo(null);  
		chessBoard.setVisible(true);
		chessBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		}
	}
}