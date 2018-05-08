import java.util.*;


public class Queen extends Piece {
	
	public Queen(int ix, int iy, int c, Board b){
		super(PieceCode.QUEEN, ix, iy, c, b);
	}
	
    public ArrayList<Move> availableMoves() {
        if (getColour() == PieceCode.WHITE)
            return whiteQueen();
        else
            return blackQueen();
    }
	private ArrayList<Move> whiteQueen() {
        // obtain current co-ordinates
        int x = this.getX();
        int y = this.getY();

        // otherwise create a new vector to store legal whiteMoves
        ArrayList<Move> whiteMoves = new ArrayList<Move>();

        // set up m to refer to a Move object
        Move theMove = null;
		
		
		for(int i=1;i<=7;i++){
		boolean flag = true;			
			if (queenMove(x + i, y + i)) {
				for(int j=1; j<i; j++){
					if(getBoard().occupied(x+j,y+j)){flag = false;}
				}
				if(flag == true){
				theMove = new Move(this, x, y, x + i, y + i, false);
				whiteMoves.add(theMove);
				}
			}
		flag = true;	
			if (occupiedByOpponent(x + i, y + i)) {
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
			if (queenMove(x + i, y - i)) {
				for(int j=1; j<i; j++){
					if(getBoard().occupied(x+j,y-j)){flag = false;}
				}
				if(flag == true){
				theMove = new Move(this, x, y, x + i, y - i, false);
				whiteMoves.add(theMove);
				}
			}
		flag = true;	
			if (occupiedByOpponent(x + i, y - i)) {		
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
			if (queenMove(x - i, y + i)) {	
				for(int j=1; j<i; j++){
					if(getBoard().occupied(x-j,y+j)){flag = false;}
				}
				if(flag == true){
				theMove = new Move(this, x, y, x - i, y + i, false);
				whiteMoves.add(theMove);
				}
			}
		flag = true;
			if (occupiedByOpponent(x - i, y + i)) {
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
			if (queenMove(x - i, y - i)) {
				for(int j=1; j<i; j++){
					if(getBoard().occupied(x-j,y-j)){flag = false;}
				}
				if(flag == true){
				theMove = new Move(this, x, y, x - i, y - i, false);
				whiteMoves.add(theMove);
				}
			}
		flag = true;
			if (occupiedByOpponent(x - i, y - i)) {
				for(int j=1; j<i; j++){
					if(getBoard().occupied(x-j,y-j)){flag = false;}
				}
				if(flag == true){
				theMove = new Move(this, x, y, x - i, y - i, true);
				whiteMoves.add(theMove);
				}
			}				
		}
		
        for(int i=1;i<=7;i++){
		boolean flag = true;		
			if (queenMove(x + i, y)) {
				for(int j=1; j<i; j++){
					if(getBoard().occupied(x+j,y)){flag = false;}
				}
				if(flag == true){
				theMove = new Move(this, x, y, x + i, y, false);
				whiteMoves.add(theMove);
				}
			}
		flag = true;
			if (occupiedByOpponent(x + i, y)) {
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
			if (queenMove(x - i, y)) {
				for(int j=1; j<i; j++){
					if(getBoard().occupied(x-j,y)){flag = false;}
				}
				if(flag == true){
				theMove = new Move(this, x, y, x - i, y, false);
				whiteMoves.add(theMove);
				}
			}
		flag = true;
			if (occupiedByOpponent(x - i, y)) {
				for(int j=1; j<i; j++){
					if(getBoard().occupied(x-j,y)){flag = false;}
				}
				if(flag == true){
				theMove = new Move(this, x, y, x - i, y, true);
				whiteMoves.add(theMove);
				}
			}			
		}
        for(int i=1;i<=7;i++){
		boolean flag = true;		
			if (queenMove(x, y - i)) {
				for(int j=1; j<i; j++){
					if(getBoard().occupied(x,y-j)){flag = false;}
				}
				if(flag == true){
				theMove = new Move(this, x, y, x, y - i, false);
				whiteMoves.add(theMove);
				}
			}
		flag = true;
			if (occupiedByOpponent(x, y - i)) {
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
			if (queenMove(x, y + i)) {
				for(int j=1; j<i; j++){
					if(getBoard().occupied(x,y+j)){flag = false;}
				}
				if(flag == true){
				theMove = new Move(this, x, y, x, y + i, false);
				whiteMoves.add(theMove);
				}
			}
		flag = true;
			if (occupiedByOpponent(x, y + i)) {
				for(int j=1; j<i; j++){
					if(getBoard().occupied(x,y+j)){flag = false;}
				}
				if(flag == true){
				theMove = new Move(this, x, y, x, y + i, true);
				whiteMoves.add(theMove);
				}
			}			
		}
        if (whiteMoves.isEmpty())
            return null;
        return whiteMoves;
    }

    // method to return Vector of legal moves for a black pawn
    private ArrayList<Move> blackQueen() {
        int x = this.getX();
        int y = this.getY();

        // return null if the pawn is at the edge of the board, or if the
        // next move takes it out of range

        ArrayList<Move> blackMoves = new ArrayList<Move>();

        // set up m to refer to a Move object
        Move theMove = null;

		for(int i=1;i<=7;i++){
		boolean flag = true;			
			if (queenMove(x + i, y + i)) {
				for(int j=1; j<i; j++){
					if(getBoard().occupied(x+j,y+j)){flag = false;}
				}
				if(flag == true){
				theMove = new Move(this, x, y, x + i, y + i, false);
				blackMoves.add(theMove);
				}
			}
		flag = true;	
			if (occupiedByOpponent(x + i, y + i)) {
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
			if (queenMove(x + i, y - i)) {
				for(int j=1; j<i; j++){
					if(getBoard().occupied(x+j,y-j)){flag = false;}
				}
				if(flag == true){
				theMove = new Move(this, x, y, x + i, y - i, false);
				blackMoves.add(theMove);
				}
			}
		flag = true;	
			if (occupiedByOpponent(x + i, y - i)) {		
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
			if (queenMove(x - i, y + i)) {	
				for(int j=1; j<i; j++){
					if(getBoard().occupied(x-j,y+j)){flag = false;}
				}
				if(flag == true){
				theMove = new Move(this, x, y, x - i, y + i, false);
				blackMoves.add(theMove);
				}
			}
		flag = true;
			if (occupiedByOpponent(x - i, y + i)) {
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
			if (queenMove(x - i, y - i)) {
				for(int j=1; j<i; j++){
					if(getBoard().occupied(x-j,y-j)){flag = false;}
				}
				if(flag == true){
				theMove = new Move(this, x, y, x - i, y - i, false);
				blackMoves.add(theMove);
				}
			}
		flag = true;
			if (occupiedByOpponent(x - i, y - i)) {
				for(int j=1; j<i; j++){
					if(getBoard().occupied(x-j,y-j)){flag = false;}
				}
				if(flag == true){
				theMove = new Move(this, x, y, x - i, y - i, true);
				blackMoves.add(theMove);
				}
			}				
		}
		
        for(int i=1;i<=7;i++){
		boolean flag = true;		
			if (queenMove(x + i, y)) {
				for(int j=1; j<i; j++){
					if(getBoard().occupied(x+j,y)){flag = false;}
				}
				if(flag == true){
				theMove = new Move(this, x, y, x + i, y, false);
				blackMoves.add(theMove);
				}
			}
		flag = true;
			if (occupiedByOpponent(x + i, y)) {
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
			if (queenMove(x - i, y)) {
				for(int j=1; j<i; j++){
					if(getBoard().occupied(x-j,y)){flag = false;}
				}
				if(flag == true){
				theMove = new Move(this, x, y, x - i, y, false);
				blackMoves.add(theMove);
				}
			}
		flag = true;
			if (occupiedByOpponent(x - i, y)) {
				for(int j=1; j<i; j++){
					if(getBoard().occupied(x-j,y)){flag = false;}
				}
				if(flag == true){
				theMove = new Move(this, x, y, x - i, y, true);
				blackMoves.add(theMove);
				}
			}			
		}
        for(int i=1;i<=7;i++){
		boolean flag = true;		
			if (queenMove(x, y - i)) {
				for(int j=1; j<i; j++){
					if(getBoard().occupied(x,y-j)){flag = false;}
				}
				if(flag == true){
				theMove = new Move(this, x, y, x, y - i, false);
				blackMoves.add(theMove);
				}
			}
		flag = true;
			if (occupiedByOpponent(x, y - i)) {
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
			if (queenMove(x, y + i)) {
				for(int j=1; j<i; j++){
					if(getBoard().occupied(x,y+j)){flag = false;}
				}
				if(flag == true){
				theMove = new Move(this, x, y, x, y + i, false);
				blackMoves.add(theMove);
				}
			}
		flag = true;
			if (occupiedByOpponent(x, y + i)) {
				for(int j=1; j<i; j++){
					if(getBoard().occupied(x,y+j)){flag = false;}
				}
				if(flag == true){
				theMove = new Move(this, x, y, x, y + i, true);
				blackMoves.add(theMove);
				}
			}			
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
	
	private boolean queenMove(int newX, int newY){
	    if (!getBoard().outOfRange(newX, newY) && !getBoard().occupied(newX, newY))
			return true;
		else if (!getBoard().outOfRange(newX, newY) && getBoard().occupied(newX, newY) 
				&& (getBoard().getPiece(newX, newY).getColour() != this.getColour()))
			return true;
		else
			return false;		
	}
}
