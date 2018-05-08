import java.util.*;
import sheffield.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Chess extends JFrame{
	static EasyReader keyboard = new EasyReader(); 
	private Pieces pieces;

	public static void main(String args []){
	System.out.println("1.Text display");
	System.out.println("2.Graphical display?");
	
	int display = keyboard.readInt("Your choice (type the number): ");
		if(display == 1){
			Board board = new Board();
			TextDisplay textDisplay = new TextDisplay(board);
			Pieces piecesOne = new Pieces(board,1);
			Pieces piecesTwo = new Pieces(board,0);
			System.out.println("Which player you want to play with?");
			System.out.println("1.play with human player");
			System.out.println("2.play with random AI player");
			System.out.println("3.play with aggressive AI player");

			int player = keyboard.readInt("Your choice (type the number): ");
			
			if(player == 1){

				String name1 = keyboard.readString("Player1's name:");
				String name2 = keyboard.readString("Player2's name:");
				
				HumanPlayer player1 = new HumanPlayer(name1,piecesOne,board,null);
				HumanPlayer player2 = new HumanPlayer(name2,piecesTwo,board,null);
				player1.setOpponent(player2);
				player2.setOpponent(player1);
				
				textDisplay.displayBoard(piecesOne);
				
				player2.askMoveText(player1, player2, piecesOne, piecesTwo,textDisplay,board);
			}
			if(player == 2){
				String name1 = keyboard.readString("Player1's name:");
				HumanPlayer player1 = new HumanPlayer(name1,piecesOne,board,null);
				RandomPlayer player2 = new RandomPlayer("Random Player",piecesTwo,board,null);
				player1.setOpponent(player2);
				player2.setOpponent(player1);
				
				textDisplay.displayBoard(piecesOne);
				player2.askMoveText(player1, player2, piecesOne, piecesTwo,textDisplay,board);
			}
			if(player==3){
				String name1 = keyboard.readString("Player1's name:");
				HumanPlayer player1 = new HumanPlayer(name1,piecesOne,board,null);
				AggressivePlayer player2 = new AggressivePlayer("Aggressive Player",piecesTwo,board,null);
				player1.setOpponent(player2);
				player2.setOpponent(player1);
				
				textDisplay.displayBoard(piecesOne);
				player2.askMoveText(player1, player2, piecesOne, piecesTwo,textDisplay,board);
			}
		}
		else if(display==2){
		GraphicalDisplay chessBoard = new GraphicalDisplay();
		chessBoard.displayBoard();
		chessBoard.setLocationRelativeTo(null);  
		chessBoard.setVisible(true);
		chessBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		}
	}
}