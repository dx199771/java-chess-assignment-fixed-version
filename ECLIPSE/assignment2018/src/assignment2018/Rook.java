package assignment2018;
import assignment2018.codeprovided.Piece;
import assignment2018.codeprovided.PieceCode;
import java.util.*;

/**
* Rook Class
* Rook piece that stored 
* available moves of Rook
* @author Xu Dong
* @version 1.0 09/05/2018
*/
public class Rook extends Piece {
	// constructor
	/**
	 * Constructor.
	 * @param ix old x-axis
	 * @param iy old y-axis
	 * @param c piece color 
	 * @param b	board which display the pieces
	 */
	public Rook(int ix, int iy, int c, Board b){
		super(PieceCode.ROOK, ix, iy, c, b);
	}
	
	/**
	 * available moves of Rook
	 * @return array of Rook available moves
	 */
    public ArrayList<Move> availableMoves() {
        if (getColour() == PieceCode.WHITE)
            return whiteRook();
        else
            return blackRook();
    }
    
	/**
	 * white Rook available moves
	 * @return array of white Rook available moves
	 */
	private ArrayList<Move> whiteRook() {
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
			if ((!getBoard().occupied(x, y + i)) && (!getBoard().outOfRange(x, y + i))) {
				for(int j=1; j<i; j++){
					//check if there are pieces in front
					if(getBoard().occupied(x,y+j)){flag = false;}
				}
				if(flag == true){				
				theMove = new Move(this, x, y, x, y + i, false);
				whiteMoves.add(theMove);
				}
			}
			flag = true;
			//occupied by opponent available move
			if(occupiedByOpponent(x, y + i)){
				for(int j=1; j<i; j++){
					if(getBoard().occupied(x,y+j)){flag = false;}
				}
				if(flag == true){
				theMove = new Move(this, x, y, x, y + i, true);
				whiteMoves.add(theMove);
				}
			}	
		}

		for(int i=1;i<=7;i++){
			boolean flag = true;
			if ((!getBoard().occupied(x, y - i)) && (!getBoard().outOfRange(x, y - i))) {
				for(int j=1; j<i; j++){
					if(getBoard().occupied(x,y-j)){flag = false;}
				}
				if(flag == true){
					theMove = new Move(this, x, y, x, y - i, false);
					whiteMoves.add(theMove);
				}					
			}
			flag = true;
			if(occupiedByOpponent(x, y - i)){
				for(int j=1; j<i; j++){
					if(getBoard().occupied(x,y-j)){flag = false;}
				}
				if(flag == true){
				theMove = new Move(this, x, y, x, y - i, true);
				whiteMoves.add(theMove);
				}
			}	
		}

		for(int i=1;i<=7;i++){
			boolean flag = true;
			if ((!getBoard().occupied(x + i, y)) && (!getBoard().outOfRange(x + i, y))) {
				for(int j=1; j<i; j++){
					if(getBoard().occupied(x+j,y)){flag = false;}
				}
				if(flag == true){
					theMove = new Move(this, x, y, x + i, y, false);
					whiteMoves.add(theMove);	
				}	
			}
			flag = true;
			
			if(occupiedByOpponent(x + i, y)){
				for(int j=1; j<i; j++){
					if(getBoard().occupied(x+j,y)){flag = false;}
				}
				if(flag == true){
					theMove = new Move(this, x, y, x + i, y, true);
					whiteMoves.add(theMove);
					
				}
			}
		}

        for(int i=1;i<=7;i++){
			boolean flag = true;
			if ((!getBoard().occupied(x - i, y)) && (!getBoard().outOfRange(x - i, y))) {
				for(int j=1; j<i; j++){
					if(getBoard().occupied(x-j,y)){flag = false;}
				}
				if(flag == true){
					theMove = new Move(this, x, y, x - i, y, false);
					whiteMoves.add(theMove);
				}	
			}
			flag = true;
			if(occupiedByOpponent(x - i, y)){
				for(int j=1; j<i; j++){
					if(getBoard().occupied(x-j,y)){flag = false;}
				}
				if(flag == true){		
					theMove = new Move(this, x, y, x - i, y, true);
					whiteMoves.add(theMove);
				}	
			}
		}

        if (whiteMoves.isEmpty())
            return null;
        return whiteMoves;
    }

    // method to return Vector of legal moves for a black Rook
	/**
	 * black Rook available moves
	 * @return array of black Rook available moves
	 */
    private ArrayList<Move> blackRook() {
        int x = this.getX();
        int y = this.getY();


        ArrayList<Move> blackMoves = new ArrayList<Move>();

        // set up m to refer to a Move object
        Move theMove = null;

        for(int i=1;i<=7;i++){
		boolean flag = true;
			//not occupied by opponent available move
			if ((!getBoard().occupied(x, y + i)) && (!getBoard().outOfRange(x, y + i))) {
				for(int j=1; j<i; j++){
					//check if there are pieces in front
					if(getBoard().occupied(x,y+j)){flag = false;}
				}
				if(flag == true){				
				theMove = new Move(this, x, y, x, y + i, false);
				blackMoves.add(theMove);
				}
			}	
			flag = true;	
			//occupied by opponent available move
			if(occupiedByOpponent(x, y + i)){
				for(int j=1; j<i; j++){
					if(getBoard().occupied(x,y+j)){flag = false;}
				}
				if(flag == true){						
				theMove = new Move(this, x, y, x, y + i, true);
				blackMoves.add(theMove);
				}
			}	
		}

		for(int i=1;i<=7;i++){
			boolean flag = true;
			if ((!getBoard().occupied(x, y - i)) && (!getBoard().outOfRange(x, y - i))) {
				for(int j=1; j<i; j++){
					if(getBoard().occupied(x,y-j)){flag = false;}
				}
				if(flag == true){
					theMove = new Move(this, x, y, x, y - i, false);
					blackMoves.add(theMove);
				}					
			}	
			flag = true;
			if(occupiedByOpponent(x, y - i)){
				for(int j=1; j<i; j++){
					if(getBoard().occupied(x,y-j)){flag = false;}
				}
				if(flag == true){
				theMove = new Move(this, x, y, x, y - i, true);
				blackMoves.add(theMove);
				}
			}	
		}

		for(int i=1;i<=7;i++){
			boolean flag = true;
			if ((!getBoard().occupied(x + i, y)) && (!getBoard().outOfRange(x + i, y))) {
				for(int j=1; j<i; j++){
					if(getBoard().occupied(x+j,y)){flag = false;}
				}
				if(flag == true){
					theMove = new Move(this, x, y, x + i, y, false);
					blackMoves.add(theMove);	
				}	
			}	
			flag = true;	
			if(occupiedByOpponent(x + i, y)){
				for(int j=1; j<i; j++){
					if(getBoard().occupied(x+j,y)){flag = false;}
				}
				if(flag == true){
					theMove = new Move(this, x, y, x + i, y, true);
					blackMoves.add(theMove);
					
				}
			}
		}

        for(int i=1;i<=7;i++){
			boolean flag = true;
			if ((!getBoard().occupied(x - i, y)) && (!getBoard().outOfRange(x - i, y))) {
				for(int j=1; j<i; j++){
					if(getBoard().occupied(x-j,y)){flag = false;}
				}
				if(flag == true){
					theMove = new Move(this, x, y, x - i, y, false);
					blackMoves.add(theMove);
				}	
			}	
			flag = true;
			if(occupiedByOpponent(x - i, y)){
				for(int j=1; j<i; j++){
					if(getBoard().occupied(x-j,y)){flag = false;}
				}
				if(flag == true){		
					theMove = new Move(this, x, y, x - i, y, true);
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
}