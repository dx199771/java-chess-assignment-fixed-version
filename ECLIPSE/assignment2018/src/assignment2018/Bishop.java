package assignment2018;


import assignment2018.codeprovided.Piece;
import assignment2018.codeprovided.PieceCode;
import java.util.*;

/**
* Bishop Class
* Bishop piece that stored 
* available moves of Bishop
* @author Xu Dong
* @version 1.0 09/05/2018
*/
public class Bishop extends Piece {
	// constructor
	/**
	 * Constructor.
	 * @param ix old x-axis
	 * @param iy old y-axis
	 * @param c piece color 
	 * @param b	board which display the pieces
	 */
	public Bishop(int ix, int iy, int c, Board b){
		super(PieceCode.BISHOP, ix, iy, c, b);
	}
	
	/**
	 * available moves of bishop
	 * @return array of bishop available moves
	 */
    public ArrayList<Move> availableMoves() {
        if (getColour() == PieceCode.WHITE)
            return whiteBishop();
        else
            return blackBishop();
    }
    
	/**
	 * white bishop available moves
	 * @return array of white bishop available moves
	 */
	private ArrayList<Move> whiteBishop() {
        // obtain current co-ordinates
        int x = this.getX();
        int y = this.getY();

        // otherwise create a new vector to store legal whiteMoves
        ArrayList<Move> whiteMoves = new ArrayList<Move>();

        // set up m to refer to a Move object
        Move theMove = null;
		
		
		for(int i=1;i<=7;i++){
			boolean flag = true;
			//not occupied by opponent available move
			if (bishopMove(x + i, y + i)) {
				for(int j=1; j<i; j++){
					//check if there are pieces in front
					if(getBoard().occupied(x+j,y+j)){flag = false;}
				}
				if(flag == true){
				theMove = new Move(this, x, y, x + i, y + i, false);
				whiteMoves.add(theMove);
				}
			}
			flag = true;
			//occupied by opponent available move
			if(occupiedByOpponent(x + i, y + i)){
				for(int j=1; j<i; j++){
					if(getBoard().occupied(x+j,y+j)){flag = false;}
				}
				if(flag == true){
				theMove = new Move(this, x, y, x + i, y + i, true);
				whiteMoves.add(theMove);
				}				
			}
		}

		for(int i=1;i<=7;i++){
			boolean flag = true;
			if (bishopMove(x + i, y - i)) {
				for(int j=1; j<i; j++){
					if(getBoard().occupied(x+j,y-j)){flag = false;}
				}
				if(flag == true){
				theMove = new Move(this, x, y, x + i, y - i, false);
				whiteMoves.add(theMove);
				}
			}
			flag = true;
			if(occupiedByOpponent(x + i, y - i)){
				for(int j=1; j<i; j++){
					if(getBoard().occupied(x+j,y-j)){flag = false;}
				}
				if(flag == true){
				theMove = new Move(this, x, y, x + i, y - i, true);
				whiteMoves.add(theMove);
				}				
			}
		}

		for(int i=1;i<=7;i++){
			boolean flag = true;
			if (bishopMove(x - i, y + i)) {
				for(int j=1; j<i; j++){
					if(getBoard().occupied(x-j,y+j)){flag = false;}
				}
				if(flag == true){
				theMove = new Move(this, x, y, x - i, y + i, false);
				whiteMoves.add(theMove);
				}
			}	
			flag = true;
			if(occupiedByOpponent(x - i, y + i)){
				for(int j=1; j<i; j++){
					if(getBoard().occupied(x-j,y+j)){flag = false;}
				}
				if(flag == true){
				theMove = new Move(this, x, y, x - i, y + i, true);
				whiteMoves.add(theMove);
				}				
			}			
		}

        for(int i=1;i<=7;i++){
			boolean flag = true;			
			if (bishopMove(x - i, y - i)) {
				for(int j=1; j<i; j++){
					if(getBoard().occupied(x-j,y-j)){flag = false;}
				}
				if(flag == true){
				theMove = new Move(this, x, y, x - i, y - i, false);
				whiteMoves.add(theMove);
				}
			}
			flag = true;
			if(occupiedByOpponent(x - i, y - i)){
				for(int j=1; j<i; j++){
					if(getBoard().occupied(x-j,y-j)){flag = false;}
				}
				if(flag == true){
				theMove = new Move(this, x, y, x - i, y - i, true);
				whiteMoves.add(theMove);
				}				
			}			
		}
		
        if (whiteMoves.isEmpty())
            return null;
        return whiteMoves;
    }

    // method to return Vector of legal moves for a black Bishop
	/**
	 * black bishop available moves
	 * @return array of black bishop available moves
	 */
    private ArrayList<Move> blackBishop() {
        int x = this.getX();
        int y = this.getY();


        ArrayList<Move> blackMoves = new ArrayList<Move>();

        // set up m to refer to a Move object
        Move theMove = null;

		for(int i=1;i<=7;i++){
			boolean flag = true;
			//not occupied by opponent available move
			if (bishopMove(x + i, y + i)) {
				for(int j=1; j<i; j++){
					//check if there are pieces in front
					if(getBoard().occupied(x+j,y+j)){flag = false;}
				}
				if(flag == true){
				theMove = new Move(this, x, y, x + i, y + i, false);
				blackMoves.add(theMove);
				}
			}	
			flag = true;
			//occupied by opponent available move
			if(occupiedByOpponent(x + i, y + i)){
				for(int j=1; j<i; j++){
					if(getBoard().occupied(x+j,y+j)){flag = false;}
				}
				if(flag == true){
				theMove = new Move(this, x, y, x + i, y + i, true);
				blackMoves.add(theMove);
				}				
			}
		}

		for(int i=1;i<=7;i++){
		boolean flag = true;
			if (bishopMove(x + i, y - i)) {
				for(int j=1; j<i; j++){
					if(getBoard().occupied(x+j,y-j)){flag = false;}
				}
				if(flag == true){
				theMove = new Move(this, x, y, x + i, y - i, false);
				blackMoves.add(theMove);
				}
			}	
			flag = true;
			if(occupiedByOpponent(x + i, y - i)){
				for(int j=1; j<i; j++){
					if(getBoard().occupied(x+j,y-j)){flag = false;}
				}
				if(flag == true){
				theMove = new Move(this, x, y, x + i, y - i, true);
				blackMoves.add(theMove);
				}				
			}
		}

		for(int i=1;i<=7;i++){
			boolean flag = true;			
			if (bishopMove(x - i, y + i)) {
				for(int j=1; j<i; j++){
					if(getBoard().occupied(x-j,y+j)){flag = false;}
				}
				if(flag == true){
				theMove = new Move(this, x, y, x - i, y + i, false);
				blackMoves.add(theMove);
				}
			}
			flag = true;
			if(occupiedByOpponent(x - i, y + i)){
				for(int j=1; j<i; j++){
					if(getBoard().occupied(x-j,y+j)){flag = false;}
				}
				if(flag == true){
				theMove = new Move(this, x, y, x - i, y + i, true);
				blackMoves.add(theMove);
				}				
			}			
		}

        for(int i=1;i<=7;i++){
			boolean flag = true;		
			if (bishopMove(x - i, y - i)) {
				for(int j=1; j<i; j++){
					if(getBoard().occupied(x-j,y-j)){flag = false;}
				}
				if(flag == true){
				theMove = new Move(this, x, y, x - i, y - i, false);
				blackMoves.add(theMove);
				}
			}	
			flag = true;
			if(occupiedByOpponent(x - i, y - i)){
				for(int j=1; j<i; j++){
					if(getBoard().occupied(x-j,y-j)){flag = false;}
				}
				if(flag == true){
				theMove = new Move(this, x, y, x - i, y - i, true);
				blackMoves.add(theMove);
				}				
			}			
		}
        if (blackMoves.isEmpty())
            return null;
        return blackMoves;
    }
    
	/**
	 * check if board occupied by opponent
	 * @return true if occupied by opponent
	 * @return false if not occupied by opponent
	 */
	private boolean occupiedByOpponent(int newX, int newY){
        if (!getBoard().outOfRange(newX, newY) && getBoard().occupied(newX, newY)
                && (getBoard().getPiece(newX, newY).getColour() != this.getColour()))
			return true;
		else
			return false;
	}
	
	/**
	 * check if move available
	 * not out of range
	 * not occupied by another piece
	 * or occupied by opponent piece
	 * @return true if available
	 * @return false if not available
	 */
	private boolean bishopMove(int newX, int newY){
	    if (!getBoard().outOfRange(newX, newY) && !getBoard().occupied(newX, newY))
			return true;
		else if (!getBoard().outOfRange(newX, newY) && getBoard().occupied(newX, newY) 
				&& (getBoard().getPiece(newX, newY).getColour() != this.getColour()))
			return true;
		else
			return false;		
	}
}
