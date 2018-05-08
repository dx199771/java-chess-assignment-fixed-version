

import java.util.*;

public class Move {
	
	private Piece piece;
	private int oldX;
	private int oldY;
	private int newX;
	private int newY;
	private boolean flag;


	
	public Move(Piece p,int x,int y, int nx, int ny, boolean f){
		piece = p;
		oldX = x;
		oldY = y;
		newX = nx;
		newY = ny;
		flag = f;					
	}
	
	public int available(Piece p,Move m){
		int flag = 0;
		if(p!= null && piece.availableMoves()==null){
			flag = 2;
			return flag;
		}
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
	public Pieces getNextMovePieces (Pieces p1, Pieces p2){
		if(this.getPiece().getColour() == 1)
			return p1;
		else
			return p2;
		
	}	
	public int getOldX(){
		return(oldX);
	}
	public int getOldY(){
		return(oldY);
	}
	
	public Piece getPiece(){
		return piece;
		
	}

	public int getNewX(){
		return newX;
		
	}
	public int getNewY(){
		return newY;
		
	}
	public boolean getOpponent(){
		return flag;
	}
}
	 
 