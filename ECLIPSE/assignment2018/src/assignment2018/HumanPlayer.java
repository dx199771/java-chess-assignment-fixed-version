package assignment2018;
import assignment2018.codeprovided.Piece;
import assignment2018.codeprovided.Pieces;
import assignment2018.codeprovided.Player;
import sheffield.*; 
/**
* HumanPlayer Class
* Human player
* @author Xu Dong
* @version 1.0 09/05/2018
*/ 
public class HumanPlayer extends Player{
	static EasyReader keyboard = new EasyReader(); 
	// constructor
	/**
	 * Constructor.
	 * @param n human player's name
	 * @param p	pieces of human player
	 * @param b	board which display the pieces
	 * @param o opponent player
	 */
	public HumanPlayer(String n, Pieces p, Board b, Player o){
		super(n,p,b,o);
	}
	
	//did not use this method
    public boolean makeMove(){
		return true;
	}
	//ask player for a move in text display
	public void askMoveText(Player p1,Player p2,Pieces ps1, Pieces ps2,TextDisplay d,Board b){
	//gameover variable to determine whether game has ended

	boolean gameOver = false;
	Player movingPlayer = p1;
	//loop back when game not end
	while (gameOver != true){
		System.out.println(movingPlayer+" is moving");	
		
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
			//update piece
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
			
	}
	
}