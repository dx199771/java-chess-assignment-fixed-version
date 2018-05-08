import java.util.*;
import sheffield.*; 


public class TextDisplay implements Display {
	
	
	static EasyReader keyboard = new EasyReader(); 
	public static Board board = new Board();
	
	
	
	
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
	/*
	//ask player for a move
	public void askMove(Player p1,Player p2,Pieces ps1, Pieces ps2){
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

			Move move = new Move(board.getPiece(intoInt(fromX),8-fromY),intoInt(fromX),8-fromY,intoInt(toX),8-toY,
			opponent(intoInt(fromX),8-fromY,intoInt(toX),8-toY));
			Piece piece = board.getPiece(intoInt(fromX),8-fromY);
			
			if(move.available(piece,move) == 1 && (movingPlayer.getPieces() == move.getNextMovePieces(ps1,ps2))){
				
				updatePiece(piece,move.getNewX(),move.getNewY());
				updateBoard(board,move,piece);	
				displayBoard(null);
				movingPlayer = movingPlayer.getOpponent();
			}
			else if (move.available(piece,move) == 0)
				System.out.println("Invalid input. Please input correct piece.");
			
			else 
				System.out.println("Invalid from. Please input correct piece.");
		
			}		
			
	}
	*/
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
	public static void main(String args []){
		
		TextDisplay textDisplay = new TextDisplay();
		Pieces piecesOne = new Pieces(board,1);
		Pieces piecesTwo = new Pieces(board,0);
		System.out.println("Which player you want to play with?");
		System.out.println("1.play with human player");
		System.out.println("2.play with random AI player");
		System.out.println("3.play with aggressive AI player");

		int player = keyboard.readInt("Your choice (type the number): ");
		
		if(player == 1){
			String name1 = keyboard.readString("Player1's name:");
			String name2 = keyboard.readString("Player2's name:");
			
			HumanPlayer player1 = new HumanPlayer(name1,piecesOne,board,null);
			HumanPlayer player2 = new HumanPlayer(name2,piecesTwo,board,null);
			player1.setOpponent(player2);
			player2.setOpponent(player1);
			
			textDisplay.displayBoard(piecesOne);
			
			player2.askMoveText(player1, player2, piecesOne, piecesTwo,textDisplay,board);
		}
		if(player == 2){
			String name1 = keyboard.readString("Player1's name:");
			HumanPlayer player1 = new HumanPlayer(name1,piecesOne,board,null);
			RandomPlayer player2 = new RandomPlayer("Random Player",piecesTwo,board,null);
			player1.setOpponent(player2);
			player2.setOpponent(player1);
			
			textDisplay.displayBoard(piecesOne);
			player2.askMoveText(player1, player2, piecesOne, piecesTwo,textDisplay,board);
		}
		if(player==3){
			String name1 = keyboard.readString("Player1's name:");
			HumanPlayer player1 = new HumanPlayer(name1,piecesOne,board,null);
			AggressivePlayer player2 = new AggressivePlayer("Aggressive Player",piecesTwo,board,null);
			player1.setOpponent(player2);
			player2.setOpponent(player1);
			
			textDisplay.displayBoard(piecesOne);
			player2.askMoveText(player1, player2, piecesOne, piecesTwo,textDisplay,board);
		}
		
	
	
	
		

	}
}