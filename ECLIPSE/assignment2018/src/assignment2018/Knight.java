package assignment2018;
import assignment2018.codeprovided.Piece;
import assignment2018.codeprovided.PieceCode;
import java.util.*;


public class Knight extends Piece {
	
	public Knight(int ix, int iy, int c, Board b){
		super(PieceCode.KNIGHT, ix, iy, c, b);
	}
	
    public ArrayList<Move> availableMoves() {
        if (getColour() == PieceCode.WHITE)
            return whiteKnight();
        else
            return blackKnight();
    }
	private ArrayList<Move> whiteKnight() {
        // obtain current co-ordinates
        int x = this.getX();
        int y = this.getY();

        // otherwise create a new vector to store legal whiteMoves
        ArrayList<Move> whiteMoves = new ArrayList<Move>();

        // set up m to refer to a Move object
        Move theMove = null;
		

        if (knightMove(x + 1, y + 2)) {
            theMove = new Move(this, x, y, x + 1, y + 2, false);
            whiteMoves.add(theMove);
        }
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

    // method to return Vector of legal moves for a black pawn
    private ArrayList<Move> blackKnight() {
        int x = this.getX();
        int y = this.getY();

        ArrayList<Move> blackMoves = new ArrayList<Move>();

        // set up m to refer to a Move object
        Move theMove = null;

        if (knightMove(x + 1, y + 2)) {
            theMove = new Move(this, x, y, x + 1, y + 2, false);
            blackMoves.add(theMove);
        }
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
	private boolean occupiedByOpponent(int newX, int newY){
        if (!getBoard().outOfRange(newX, newY) && getBoard().occupied(newX, newY)
                && (getBoard().getPiece(newX, newY).getColour() != this.getColour()))
			return true;
		else
			return false;
	}	
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
