import javax.swing.*;

public class RunChess { 
	public static void main (String[] args) {
	GraphicalDisplay chessBoard = new GraphicalDisplay();
	chessBoard.Board();
	chessBoard.setLocationRelativeTo(null);  
	chessBoard.setVisible(true);
	chessBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	

	}
}
