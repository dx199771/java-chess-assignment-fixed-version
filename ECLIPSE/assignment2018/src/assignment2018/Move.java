package assignment2018;
import assignment2018.codeprovided.Piece;
import assignment2018.codeprovided.Pieces;
/**
* Move Class 
* @author Xu Dong
* @version 1.0 09/05/2018
*/
public class Move {
	
	private Piece piece;
	private int oldX;
	private int oldY;
	private int newX;
	private int newY;
	private boolean flag;

	// constructor
	/**
	 * Constructor.
	 * @param p current piece
	 * @param x	old x
	 * @param y	old y
	 * @param nx new x
	 * @param ny new y
	 * @param f flag for if target move is opponent piece
	 */
	public Move(Piece p,int x,int y, int nx, int ny, boolean f){
		piece = p;
		oldX = x;
		oldY = y;
		newX = nx;
		newY = ny;
		flag = f;					
	}
	/**
	 * check whther move is available
	 * @return 1 if move is available
	 */
	public int available(Piece p,Move m){
		int flag = 0;
		if(p!= null && piece.availableMoves()==null){
			flag = 2;
			return flag;
		}
		//check if all parameters are equal to available move in
		//each piece classes
		if(p != null && piece.availableMoves()!=null){
			for(int i = 0 ; i <piece.availableMoves().size(); i++) {
				if(p.availableMoves().get(i).getOldX() == m.getOldX() 
					&& p.availableMoves().get(i).getOldY() == m.getOldY() 
				&& p.availableMoves().get(i).getNewX() == m.getNewX() 
				&& p.availableMoves().get(i).getNewY() == m.getNewY()
				&& p.availableMoves().get(i).getOpponent() == m.getOpponent())
					flag = 1;
			}
	
		return flag;
		}
		else{
			flag = 2;
			return flag;
			
		}
	}	
	/**
	 * @return p1 if next move pieces is white
	 * @return p2 if next move pieces is black
	 */
	public Pieces getNextMovePieces (Pieces p1, Pieces p2){
		if(this.getPiece().getColour() == 1)
			return p1;
		else
			return p2;
		
	}	
	/**
	 * @return old X coordinate
	 */
	public int getOldX(){
		return(oldX);
	}	
	/**
	 * @return old Y coordinate
	 */
	public int getOldY(){
		return(oldY);
	}
	
	/**
	 * @return current piece
	 */
	public Piece getPiece(){
		return piece;
		
	}
	
	/**
	 * @return new X coordinate
	 */
	public int getNewX(){
		return newX;
		
	}
	
	/**
	 * @return new Y coordinate
	 */
	public int getNewY(){
		return newY;
		
	}
	
	/**
	 * @return true if target piece is opponent piece
	 */
	public boolean getOpponent(){
		return flag;
	}
}
	 
 