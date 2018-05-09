package assignment2018;
import assignment2018.codeprovided.Piece;
import assignment2018.codeprovided.PieceCode;
import java.util.*;

/**
* Knight Class
* Knight piece that stored 
* available moves of Knight
* @author Xu Dong
* @version 1.0 09/05/2018
*/
public class Knight extends Piece {
	// constructor
	/**
	 * Constructor.
	 * @param ix old x-axis
	 * @param iy old y-axis
	 * @param c piece color 
	 * @param b	board which display the pieces
	 */
	public Knight(int ix, int iy, int c, Board b){
		super(PieceCode.KNIGHT, ix, iy, c, b);
	}
	
	/**
	 * available moves of Knight
	 * @return array of Knight available moves
	 */
    public ArrayList<Move> availableMoves() {
        if (getColour() == PieceCode.WHITE)
            return whiteKnight();
        else
            return blackKnight();
    }
    
	/**
	 * white Knight available moves
	 * @return array of white Knight available moves
	 */
	private ArrayList<Move> whiteKnight() {
        // obtain current co-ordinates
        int x = this.getX();
        int y = this.getY();

        // otherwise create a new vector to store legal whiteMoves
        ArrayList<Move> whiteMoves = new ArrayList<Move>();

        // set up m to refer to a Move object
        Move theMove = null;
		
		//not occupied by opponent available move
        if (knightMove(x + 1, y + 2)) {
            theMove = new Move(this, x, y, x + 1, y + 2, false);
            whiteMoves.add(theMove);
        }
		//occupied by opponent available move
        if (occupiedByOpponent(x + 1, y + 2)) {
            theMove = new Move(this, x, y, x + 1, y + 2, true);
            whiteMoves.add(theMove);
        }		
        if (knightMove(x - 1, y + 2)) {
            theMove = new Move(this, x, y, x - 1, y + 2, false);
            whiteMoves.add(theMove);
        }
        if (occupiedByOpponent(x - 1, y + 2)){
            theMove = new Move(this, x, y, x - 1, y + 2, true);
            whiteMoves.add(theMove);
        }	
        if (knightMove(x + 1, y - 2)) {
            theMove = new Move(this, x, y, x + 1, y - 2, false);
            whiteMoves.add(theMove);
        }
        if (occupiedByOpponent(x + 1, y - 2)) {
            theMove = new Move(this, x, y, x + 1, y - 2, true);
            whiteMoves.add(theMove);
        }	
        if (knightMove(x - 1, y - 2)) {
            theMove = new Move(this, x, y, x - 1, y - 2, false);
            whiteMoves.add(theMove);
        }
        if (occupiedByOpponent(x - 1, y - 2)) {
            theMove = new Move(this, x, y, x - 1, y - 2, true);
            whiteMoves.add(theMove);
        }		
		if (knightMove(x - 2, y - 1)) {
            theMove = new Move(this, x, y, x - 2, y - 1, false);
            whiteMoves.add(theMove);
        }
        if (occupiedByOpponent(x - 2, y - 1)) {
            theMove = new Move(this, x, y, x - 2, y - 1, true);
            whiteMoves.add(theMove);
        }		
		if (knightMove(x - 2, y + 1)) {
			theMove = new Move(this, x, y, x - 2, y + 1, false);
            whiteMoves.add(theMove);
        }
        if (occupiedByOpponent(x - 2, y + 1)) {
            theMove = new Move(this, x, y, x - 2, y + 1, true);
            whiteMoves.add(theMove);
        }		
		if (knightMove(x + 2, y - 1)) {
			theMove = new Move(this, x, y, x + 2, y - 1, false);
            whiteMoves.add(theMove);
        }
        if (occupiedByOpponent(x + 2, y - 1)) {
            theMove = new Move(this, x, y, x + 2, y - 1, true);
            whiteMoves.add(theMove);
        }
		if (knightMove(x + 2, y + 1)) {
			theMove = new Move(this, x, y, x + 2, y + 1, false);
            whiteMoves.add(theMove);
        }	
        if (occupiedByOpponent(x + 2, y + 1)) {
            theMove = new Move(this, x, y, x + 2, y + 1, true);
            whiteMoves.add(theMove);
        }		
        if (whiteMoves.isEmpty())
            return null;
        return whiteMoves;
    }

    // method to return Vector of legal moves for a black Knight
	/**
	 * black Knight available moves
	 * @return array of black Knight available moves
	 */
    private ArrayList<Move> blackKnight() {
        int x = this.getX();
        int y = this.getY();

        ArrayList<Move> blackMoves = new ArrayList<Move>();

        // set up m to refer to a Move object
        Move theMove = null;
		//not occupied by opponent available move
        if (knightMove(x + 1, y + 2)) {
            theMove = new Move(this, x, y, x + 1, y + 2, false);
            blackMoves.add(theMove);
        }
		//occupied by opponent available move
        if (occupiedByOpponent(x + 1, y + 2)) {
            theMove = new Move(this, x, y, x + 1, y + 2, true);
            blackMoves.add(theMove);
        }
        if (knightMove(x - 1, y + 2)) {
            theMove = new Move(this, x, y, x - 1, y + 2, false);
            blackMoves.add(theMove);
        }
        if (occupiedByOpponent(x - 1, y + 2)) {
            theMove = new Move(this, x, y, x - 1, y + 2, true);
            blackMoves.add(theMove);
        }
        if (knightMove(x + 1, y - 2)) {
            theMove = new Move(this, x, y, x + 1, y - 2, false);
            blackMoves.add(theMove);
        }
        if (occupiedByOpponent(x + 1, y - 2)) {
            theMove = new Move(this, x, y, x + 1, y - 2, true);
            blackMoves.add(theMove);
        }
        if (knightMove(x - 1, y - 2)) {
            theMove = new Move(this, x, y, x - 1, y - 2, false);
            blackMoves.add(theMove);
        }
        if (occupiedByOpponent(x - 1, y - 2)) {
            theMove = new Move(this, x, y, x - 1, y - 2, true);
            blackMoves.add(theMove);
        }		
		if (knightMove(x - 2, y - 1)) {
            theMove = new Move(this, x, y, x - 2, y - 1, false);
            blackMoves.add(theMove);
        }
        if (occupiedByOpponent(x - 2, y - 1)) {
            theMove = new Move(this, x, y, x - 2, y - 1, true);
            blackMoves.add(theMove);
        }			
		if (knightMove(x - 2, y + 1)) {
			theMove = new Move(this, x, y, x - 2, y + 1, false);
            blackMoves.add(theMove);
        }
        if (occupiedByOpponent(x - 2, y + 1)) {
            theMove = new Move(this, x, y, x - 2, y + 1, true);
            blackMoves.add(theMove);
        }			
		if (knightMove(x + 2, y - 1)) {
			theMove = new Move(this, x, y, x + 2, y - 1, false);
            blackMoves.add(theMove);
        }
        if (occupiedByOpponent(x + 2, y - 1)) {
            theMove = new Move(this, x, y, x + 2, y - 1, true);
            blackMoves.add(theMove);
        }	
		if (knightMove(x + 2, y + 1)) {
			theMove = new Move(this, x, y, x + 2, y + 1, false);
            blackMoves.add(theMove);
        }	
        if (occupiedByOpponent(x + 2, y + 1)) {
            theMove = new Move(this, x, y, x + 2, y + 1, true);
            blackMoves.add(theMove);
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
	private boolean knightMove(int newX, int newY){
	    if (!getBoard().outOfRange(newX, newY) && !getBoard().occupied(newX, newY))
			return true;
		else if (!getBoard().outOfRange(newX, newY) && getBoard().occupied(newX, newY) 
				&& (getBoard().getPiece(newX, newY).getColour() != this.getColour()))
			return true;
		else
			return false;				
	}
}
