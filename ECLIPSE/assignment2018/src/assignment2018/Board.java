package assignment2018;
import assignment2018.codeprovided.Piece;
/**
* Board Class
* class for create board
* and set delete piece from board
* @author Xu Dong
* @version 1.0 09/05/2018
*/
public class Board {
	private final int x = 8;
	private final int y = 8;
	private Piece[][] board;
	// constructor
	/**
	 * Constructor.
	 * create a two dimension array
	 * to store all pieces
	 */
	public Board(){
	board = new Piece[x][y];
	}
	//set piece to board
	public void setPosition(int i, int j, Piece p) {
		board[i][j] = p;
	}
	//delete piece from board
	public void deletePosition(int i, int j, Piece p){
		board[i][j] = null;

	}
	/**
	 * check if piece is out of range
	 * @param x x axis
	 * @param y y axis
	 * @return if it out of range
	 */
	public boolean outOfRange(int x, int y) {
		if(x>7||y>7||x<0||y<0)
			return true;
		else
		return false;
		
	}
	/**
	 * check if point on the board occupied by another piece
	 * @param x x axis
	 * @param y y axis
	 * @return if point on the board occupied by another piece
	 */
	public boolean occupied(int x, int y) {
		if (x<0 || y<0 || x>7 || y>7)
			return false;
		if(board[x][y]!= null)
			return true;
		else
			return false;
	}
	/**
	 * get current piece
	 * @param x x axis
	 * @param y y axis
	 * @return piece at board[x][y]
	 */
	public Piece getPiece(int x, int y) {
		return board[x][y];
		
	}
	/**
	 * remove current point
	 * @param x x axis
	 * @param y y axis
	 * @return new board[x][y]
	 */
	public Piece removePosition(int x, int y){
		board[x][y] = null;
		return board[x][y];		
	}
	/**
	 * get char of piece
	 * @param x x axis
	 * @param y y axis
	 * @return char of the piece
	 */
	public char getPieceChar(int x, int y){
		return board[x][y].getChar();
	}
	

	
}