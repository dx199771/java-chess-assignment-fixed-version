
import sheffield.*; 

public class HumanPlayer extends Player{
	private Pieces pieces;
	static EasyReader keyboard = new EasyReader(); 

	public HumanPlayer(String n, Pieces p, Board b, Player o){
		super(n,p,b,o);
		pieces = p;
	}
    public boolean makeMove(){
		return true;
	}
	//ask player for a move
	
	public void askMoveText(Player p1,Player p2,Pieces ps1, Pieces ps2,TextDisplay d,Board b){
	boolean gameOver = false;
	Player movingPlayer = p1;
	while (gameOver != true){
			System.out.println(movingPlayer+" is moving");	
		
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
			
	}
	
}