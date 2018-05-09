package assignment2018;
import assignment2018.codeprovided.Piece;

public class Board {
	private final int x = 8;
	private final int y = 8;
	private Piece[][] board;
	
	public Board(){
	board = new Piece[x][y];
	}
	
	public void setPosition(int i, int j, Piece p) {
		board[i][j] = p;
	}
	public void deletePosition(int i, int j, Piece p){
		board[i][j] = null;

	}

	public boolean outOfRange(int x, int y) {
		if(x>7||y>7||x<0||y<0)
			return true;
		else
		return false;
		
	}
	
	public boolean occupied(int x, int y) {
		if (x<0 || y<0 || x>7 || y>7)
			return false;
		if(board[x][y]!= null)
			return true;
		else
			return false;
	}
	
	public Piece getPiece(int x, int y) {
		return board[x][y];
		
	}

	public Piece removePosition(int x, int y){
		board[x][y] = null;
		return board[x][y];		
	}
	
	public char getPieceChar(int x, int y){
		return board[x][y].getChar();
	}
	

	
}