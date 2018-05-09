package assignment2018;
import assignment2018.codeprovided.Piece;
import assignment2018.codeprovided.Pieces;
import assignment2018.codeprovided.Player;
import assignment2018.codeprovided.PieceCode;
import java.util.*;
import sheffield.*;
/**
* AggressivePlayer Class
* aggressive AI player that
* takes highest value of opponent piece
* @author Xu Dong
* @version 1.0 09/05/2018
*/
public class AggressivePlayer extends Player{
	
	static EasyReader keyboard = new EasyReader(); 	
	
	// constructor
	/**
	 * Constructor.
	 * @param n name of AggressivePlayer
	 * @param p	pieces of aggressive player
	 * @param b	board which display the pieces
	 * @param o opponent player
	 */
	public AggressivePlayer(String n, Pieces p, Board b, Player o){
		super(n,p,b,o);
	}
	
	//did not use this method
	public boolean makeMove(){
		return true;
	}
	
	//ask a move in text display
	public void askMoveText(Player p1,Player p2,Pieces ps1, Pieces ps2,TextDisplay d,Board b){
	// gameover variable to determine whether game has ended
	boolean gameOver = false;
	Player movingPlayer = p1;
		//loop back when game not end
		while (gameOver != true){

		System.out.println(movingPlayer+" is moving");	
			if(movingPlayer==p1){
				
				//get from move from keyboard
				String from = keyboard.readString("From:\n");
				String fromX = from.substring(0,1);
				int fromY = Integer.parseInt(from.substring(2,3));
				//get to move from keyboard
				String to = keyboard.readString("To:\n");
				String toX = to.substring(0,1);
				int toY = Integer.parseInt(to.substring(2,3));				
			
				Move move = new Move(b.getPiece(d.intoInt(fromX),8-fromY),d.intoInt(fromX),8-fromY,d.intoInt(toX),8-toY,
				d.opponent(d.intoInt(fromX),8-fromY,d.intoInt(toX),8-toY));
				Piece piece = b.getPiece(d.intoInt(fromX),8-fromY);
				
				//check if the new move is available
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
			//if is Aggressive AI turn
			//generate a AI move
			else if(movingPlayer==p2){
				genetateTextMove(b,d);
				movingPlayer =p1;

			}
		//check if the game has ended
		gameOver = d.gameOver(b);	
		}
		
	}
	//generate a move in Text display for aggressive AI player
	public void genetateTextMove(Board board,TextDisplay d){
		Move newMove = generateAggressiveMove(board);
		int ox = newMove.getOldX();
		int oy = newMove.getOldY();
		//update piece and board for AI player
		d.updatePiece(board.getPiece(ox,oy),newMove.getNewX(),newMove.getNewY());
		d.updateBoard(board,newMove,board.getPiece(ox,oy));	
		d.displayBoard(null);

	}
	
	//generate a move in Graphical display for aggressive AI player
	public void generateGraphicalMove(Board board,GraphicalDisplay gd){
	Move newMove = generateAggressiveMove(board);
	//update piece and board for AI player
	gd.updatePiece(newMove.getPiece(),
	newMove.getNewX(),newMove.getNewY());
	gd.updateBoard(board,newMove,newMove.getPiece());
	}
	
	/**
	 * method to create a new aggressive AI move
	 * @reutrn a aggressive AI move
	 */
	public Move generateAggressiveMove(Board board){
	//create a new ArrayList for storing all available moves
	ArrayList<Move> avaMoves = new ArrayList<Move>();
	Move theMove = null;
	//iterate the board
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
	//variable for value of each piece
	int pieceValue=0;
	Move newMove = null;
	if(avaMoves.size() != 0){
		for(int l=0; l<avaMoves.size();l++){
			int moveNewX= avaMoves.get(l).getNewX();
			int moveNewY= avaMoves.get(l).getNewY();
			int p = PieceCode.charToInt(board.getPiece(moveNewX,moveNewY).getChar());
			//select the highest value of opponent in available moves
			if(pieceValue<=p){
			p = pieceValue;
			newMove = avaMoves.get(l);
			}
		}
	}
	//if no piece can be taken
	//generate a random move
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