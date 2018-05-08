import java.util.*;
import sheffield.*; 
public class RandomPlayer extends Player{
	private Pieces pieces;
	static EasyReader keyboard = new EasyReader(); 

	public RandomPlayer(String n, Pieces p, Board b, Player o){
		super(n,p,b,o);
		pieces = p;
	}
    public boolean makeMove(){
		return true;
	}	

	public void askMoveText(Player p1,Player p2,Pieces ps1, Pieces ps2,TextDisplay d,Board b){
	boolean gameOver = false;
	Player movingPlayer = p1;
		while (gameOver != true){
		System.out.println(movingPlayer+" is moving");	
			if(movingPlayer==p1){
				String from = keyboard.readString("From: ");
				String fromX = from.substring(0,1);
				int fromY = Integer.parseInt(from.substring(2,3));
				
				String to = keyboard.readString("To: ");
				String toX = to.substring(0,1);
				int toY = Integer.parseInt(to.substring(2,3));				
			
				Move move = new Move(b.getPiece(d.intoInt(fromX),8-fromY),d.intoInt(fromX),8-fromY,d.intoInt(toX),8-toY,
				d.opponent(d.intoInt(fromX),8-fromY,d.intoInt(toX),8-toY));
				Piece piece = b.getPiece(d.intoInt(fromX),8-fromY);
				
				if(move.available(piece,move) == 1 && (movingPlayer.getPieces() == move.getNextMovePieces(ps1,ps2))){
					
					d.updatePiece(piece,move.getNewX(),move.getNewY());
					d.updateBoard(b,move,piece);	
					d.displayBoard(null);
					movingPlayer = movingPlayer.getOpponent();
				}
				else if (move.available(piece,move) == 0)
					System.out.println("Invalid input. Please input correct piece.");
				
				else 
					System.out.println("Invalid from. Please input correct piece.");
			
				}
			else if(movingPlayer==p2){
				genetateTextMove(b,d);
				movingPlayer =p1;

			}
		gameOver = d.gameOver(b);	
		}
	}
	
	public void genetateTextMove(Board board,TextDisplay d){
		//generate two random numbers
		int ox = (int)(Math.random()*8);
		int oy = (int)(Math.random()*8);

		while(board.getPiece(ox,oy)== null 
		|| (board.getPiece(ox,oy)!= null && (board.getPiece(ox,oy).getColour() == 1))
		|| (board.getPiece(ox,oy)!= null && (board.getPiece(ox,oy).getColour() == 0 
		&& board.getPiece(ox,oy).availableMoves()==null ))){
		ox = (int)(Math.random()*8);
		oy = (int)(Math.random()*8);		
		}
		
		int mnum = (int)(Math.random()*(board.getPiece(ox,oy).availableMoves().size()-1));

		
		Move move = board.getPiece(ox,oy).availableMoves().get(mnum);
		
		d.updatePiece(board.getPiece(ox,oy),move.getNewX(),move.getNewY());
		d.updateBoard(board,move,board.getPiece(ox,oy));	
		d.displayBoard(null);

	}
	
	public void generateGraphicalMove(Board board,GraphicalDisplay gd){
		int ox = (int)(Math.random()*8);
		int oy = (int)(Math.random()*8);
		while(board.getPiece(ox,oy)== null 
		|| (board.getPiece(ox,oy)!= null && (board.getPiece(ox,oy).getColour() == 1))
		|| (board.getPiece(ox,oy)!= null && (board.getPiece(ox,oy).getColour() == 0 && board.getPiece(ox,oy).availableMoves()==null ))){
		ox = (int)(Math.random()*8);
		oy = (int)(Math.random()*8);		
		}
		int mnum = (int)(Math.random()*(board.getPiece(ox,oy).availableMoves().size()-1));
		
		while(board.getPiece(ox,oy).availableMoves().size() == 0){
			mnum = (int)(Math.random()*(board.getPiece(ox,oy).availableMoves().size()-1));
		}
		
		Move move = board.getPiece(ox,oy).availableMoves().get(mnum);
		
		gd.updatePiece(move.getPiece(),move.getNewX(),move.getNewY());
		gd.updateBoard(board,move,move.getPiece());

	}
	
}