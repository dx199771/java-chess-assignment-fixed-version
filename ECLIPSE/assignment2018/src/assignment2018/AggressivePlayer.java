package assignment2018;
import assignment2018.codeprovided.Piece;
import assignment2018.codeprovided.Pieces;
import assignment2018.codeprovided.Player;
import assignment2018.codeprovided.PieceCode;
import java.util.*;
import sheffield.*;
public class AggressivePlayer extends Player{
	private Pieces pieces;
	static EasyReader keyboard = new EasyReader(); 

	public AggressivePlayer(String n, Pieces p, Board b, Player o){
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
				String from = keyboard.readString("From:\n");
				String fromX = from.substring(0,1);
				int fromY = Integer.parseInt(from.substring(2,3));
				
				String to = keyboard.readString("To:\n");
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
		Move newMove = generateAggressiveMove(board);
		int ox = newMove.getOldX();
		int oy = newMove.getOldY();
		d.updatePiece(board.getPiece(ox,oy),newMove.getNewX(),newMove.getNewY());
		d.updateBoard(board,newMove,board.getPiece(ox,oy));	
		d.displayBoard(null);

	}
	
	public void generateGraphicalMove(Board board,GraphicalDisplay gd){
	Move newMove = generateAggressiveMove(board);
	
	gd.updatePiece(newMove.getPiece(),
	newMove.getNewX(),newMove.getNewY());
	gd.updateBoard(board,newMove,newMove.getPiece());
	}
	
	public Move generateAggressiveMove(Board board){
		ArrayList<Move> avaMoves = new ArrayList<Move>();
		Move theMove = null;
		for(int i=0; i<8; i++){
			for(int j=0; j<8; j++){
				if(board.getPiece(i,j)!=null && board.getPiece(i,j).getColour()==0){
					if(board.getPiece(i,j).availableMoves()!=null){
						Piece p = board.getPiece(i,j);
						for(int k=0;k<p.availableMoves().size();k++){
						int moveNewX= p.availableMoves().get(k).getNewX();
						int moveNewY= p.availableMoves().get(k).getNewY();

							if(board.getPiece(moveNewX,moveNewY)!=null
							&&board.getPiece(moveNewX,moveNewY).getColour()==1){
								theMove = p.availableMoves().get(k);
								avaMoves.add(theMove);
							}
						}
					}
				}
			}
		}
	int pieceValue=0;
	Move newMove = null;
		if(avaMoves.size() != 0){
			for(int l=0; l<avaMoves.size();l++){
				int moveNewX= avaMoves.get(l).getNewX();
				int moveNewY= avaMoves.get(l).getNewY();
				int p = PieceCode.charToInt(board.getPiece(moveNewX,moveNewY).getChar());
				if(pieceValue<=p){
				p = pieceValue;
				newMove = avaMoves.get(l);
				}
			}
		}
		else{
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

		newMove = board.getPiece(ox,oy).availableMoves().get(mnum);	
		}
		return newMove;
	}
}