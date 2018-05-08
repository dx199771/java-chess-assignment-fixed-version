import java.util.*;
import sheffield.*; 


public class TextDisplay implements Display {
	private Board board;
	
	public TextDisplay(Board b){
		board = b;
	}	
	
	public void displayBoard(Pieces myPieces){
	System.out.println(" |ABCDEFGH");
	System.out.println("----------");
		for(int i=0; i<8; i++){
			System.out.print(8-i+"|");
			for(int j=0; j<8; j++){
				if(board.getPiece(j,i)==null)
					System.out.print('.');
				else
					System.out.print(board.getPiece(j,i).getChar());
			}
			System.out.println("");
		}	
	}
	//update piece
	public void updatePiece(Piece p, int x, int y){
		p.setPosition(x,y);	
	}

	//update board
	public void updateBoard(Board b, Move m, Piece p){
		b.setPosition(m.getNewX(),m.getNewY(),p);
		b.deletePosition(m.getOldX(),m.getOldY(),p);			
	}
	public boolean opponent(int ox, int oy, int nx, int ny){
	if(board.getPiece(nx,ny)!= null){	
		if(board.getPiece(ox,oy).getColourChar() != board.getPiece(nx,ny).getColourChar())
			return true;
		else
			return false;
	}
	else
		return false;
	}
	
	//swap string on the board into int
	public int intoInt(String i){
		int data;
		switch (i) {
		case "A":
			data = 0;
		break;
		case "B":
			data = 1;
		break;			
		case "C":
			data = 2;
		break;
		case "D":
			data = 3;
		break;
		case "E":
			data = 4;
		break;
		case "F":
			data = 5;
		break;
		case "G":
			data = 6;
		break;
		case "H":
			data = 7;
		break;
		default:
            data = 0;			
		}
		return data;
	}
	
	public static boolean gameOver(Board board){
		int checkWinFlag1 = 0;
		int checkWinFlag2 = 0;		
		boolean gameOver = false;
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				if(board.getPiece(i,j)!=null&&board.getPiece(i,j).getChar()=='K')
					checkWinFlag1 = 1;
				if(board.getPiece(i,j)!=null&&board.getPiece(i,j).getChar()=='k')
					checkWinFlag2 = 1;
			}
		}
		
		if(checkWinFlag1==1 && checkWinFlag2 ==0){	
			gameOver = true;
			System.out.println("player2 win");		
		}
		else if (checkWinFlag1==0 && checkWinFlag2 ==1){
			gameOver = true;
			System.out.println("player1 win");
		}
		return gameOver;
	}	

}