package assignment2018;
import assignment2018.codeprovided.Piece;
import assignment2018.codeprovided.Pieces;
import assignment2018.codeprovided.Player;
import sheffield.*; 
/**
* RandomPlayer Class
* Random AI player that
* move in random
* @author Xu Dong
* @version 1.0 09/05/2018
*/
public class RandomPlayer extends Player{
	static EasyReader keyboard = new EasyReader(); 
	
	// constructor
	/**
	 * Constructor.
	 * @param n name of randomPlayer
	 * @param p	pieces of random player
	 * @param b	board which display the pieces
	 * @param o opponent player
	 */
	public RandomPlayer(String n, Pieces p, Board b, Player o){
		super(n,p,b,o);
	}
	
	//did not use this method
    public boolean makeMove(){
		return true;
	}	
    
	//ask a move in text display
	public void askMoveText(Player p1,Player p2,Pieces ps1, Pieces ps2,TextDisplay d,Board b){
	//gameover variable to determine whether game has ended
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
			//if is random AI turn
			//generate a AI move
			else if(movingPlayer==p2){
				genetateTextMove(b,d);
				movingPlayer =p1;

			}
		//check if the game has ended
		gameOver = TextDisplay.gameOver(b);	
		}
	}
	//generate a move in Text display for random AI player
	public void genetateTextMove(Board board,TextDisplay d){
		//generate two random numbers
		int ox = (int)(Math.random()*8);
		int oy = (int)(Math.random()*8);
		//if the ox and oy are available
		//otherwise create a new ox and oy
		while(board.getPiece(ox,oy)== null 
		|| (board.getPiece(ox,oy)!= null && (board.getPiece(ox,oy).getColour() == 1))
		|| (board.getPiece(ox,oy)!= null && (board.getPiece(ox,oy).getColour() == 0 
		&& board.getPiece(ox,oy).availableMoves()==null ))){
		ox = (int)(Math.random()*8);
		oy = (int)(Math.random()*8);		
		}
		//select a random move from available moves
		int mnum = (int)(Math.random()*(board.getPiece(ox,oy).availableMoves().size()-1));
		Move move = board.getPiece(ox,oy).availableMoves().get(mnum);
		
		//update piece and board for AI player
		d.updatePiece(board.getPiece(ox,oy),move.getNewX(),move.getNewY());
		d.updateBoard(board,move,board.getPiece(ox,oy));	
		d.displayBoard(null);

	}
	//generate a move in Graphical display for random AI
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
		
		GraphicalDisplay.updatePiece(move.getPiece(),move.getNewX(),move.getNewY());
		GraphicalDisplay.updateBoard(board,move,move.getPiece());

	}
	
}