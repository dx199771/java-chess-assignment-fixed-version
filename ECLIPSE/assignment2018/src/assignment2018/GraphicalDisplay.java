package assignment2018;
import assignment2018.codeprovided.Display;
import assignment2018.codeprovided.Piece;
import assignment2018.codeprovided.Pieces;
import assignment2018.codeprovided.Player;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
* GraphicalDisplay Class
* Graphically display the board
* with three different players
* @author Xu Dong
* @version 1.0 09/05/2018
*/ 
public class GraphicalDisplay extends JFrame implements Display {
	//variable
	private static final long serialVersionUID = 1L;
	public static final int DEFAULT_WIDTH = 1175;
	public static final int DEFAULT_HEIGHT = 900;
	public static final int DEFAULT_GRID = 100;
	public static Board board = new Board();
	public static int counter = 1;
	public static Player movingPlayer;
	public static int currentGame;
	public static GraphicalDisplay chessBoard = new GraphicalDisplay();
	
	//displayBoard method 
	public void displayBoard(Pieces myPieces){}		
	
	//display board on Graphical display
	public void displayBoard(){
	setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);	
	setTitle("A Chess GraphicalDisplay");
    setResizable(false);
	//create a panel
	JPanel jp=new JPanel();  
	//display menu
	menu(jp);
	add(jp, BorderLayout.CENTER);	
	}
	
	/**
	 * display menu
	 * @param Jpanel
	 */
	public static void menu(JPanel jp){

		jp.setLayout(null);  
		JLabel userLabel = new JLabel("Xu's chess game");
		userLabel.setBounds(10,20,120,25);
		jp.add(userLabel);
		 
		JButton vsPlayer = new JButton("Player vs Player");
		

		vsPlayer.setBounds(100,100,200,50);
		
		//player vs player
		vsPlayer.addActionListener(new ActionListener() {
		@Override        
			public void actionPerformed(ActionEvent e) {
			//get players' name
			String name1 = (String) JOptionPane.showInputDialog(null, "Player1's name:\n", "Player1's name", JOptionPane.PLAIN_MESSAGE, null, null,
	                "Player1");
			String name2 = (String) JOptionPane.showInputDialog(null, "Player2's name:\n", "Player2's name", JOptionPane.PLAIN_MESSAGE, null, null,
	                "Player2");
				if(name1 != null && name2 != null){
				jp.removeAll();
				jp.updateUI();
				Pieces piecesOne = new Pieces(board,1);	
				Pieces piecesTwo = new Pieces(board,0);
				
				//generate two players
				HumanPlayer player1 = new HumanPlayer(name1,piecesOne,board,null);
				HumanPlayer player2 = new HumanPlayer(name2,piecesTwo,board,null);	
				player1.setOpponent(player2);
				player2.setOpponent(player1);
				board(jp,player1,player2,piecesOne,piecesTwo);
				}//if name invalid
				else{
					JOptionPane.showMessageDialog(null, "You need to type your name.", "Your name",JOptionPane.WARNING_MESSAGE);  			
					menu(jp);
		        }
		currentGame=1;
			}
		});
		jp.add(vsPlayer);
		
		//player vs random AI
		JButton vsStandardAI = new JButton("Player vs Standard AI");
		vsStandardAI.setBounds(100,200,200,50);
		vsStandardAI.addActionListener(new ActionListener() {
		@Override        
			public void actionPerformed(ActionEvent e) {
			//get player's name
			String name = (String) JOptionPane.showInputDialog(null, "Player's name:\n", "Player's name", JOptionPane.PLAIN_MESSAGE, null, null,
	                "Player1");
	
				if(name != null){
				jp.removeAll();
				jp.updateUI();
				Pieces piecesOne = new Pieces(board,1);	
				Pieces piecesTwo = new Pieces(board,0);
				
				//generate two players
				HumanPlayer player1 = new HumanPlayer(name,piecesOne,board,null);
				RandomPlayer player2 = new RandomPlayer("RandomAI",piecesTwo,board,player1);	
				player1.setOpponent(player2);
				board(jp,player1,player2,piecesOne,piecesTwo);
				}//if name invalid
				else{
					JOptionPane.showMessageDialog(null, "You need to type your name.", "Your name",JOptionPane.WARNING_MESSAGE);  			
					menu(jp);
		        }
				currentGame=2;
			}
		});
		jp.add(vsStandardAI);		
		
		//player vs aggressive AI
		JButton vsAggressivePlayer = new JButton("Player vs Aggressive AI");
		vsAggressivePlayer.setBounds(100,300,200,50);
		
		vsAggressivePlayer.addActionListener(new ActionListener() {
		@Override        
			public void actionPerformed(ActionEvent e) {
			//get player's name
			String name = (String) JOptionPane.showInputDialog(null, "Player's name:\n", "Player's name", JOptionPane.PLAIN_MESSAGE, null, null,
	                "Player1");
				if(name != null){
				jp.removeAll();
				jp.updateUI();
				Pieces piecesOne = new Pieces(board,1);	
				Pieces piecesTwo = new Pieces(board,0);
				
				//generate two players
				HumanPlayer player1 = new HumanPlayer(name,piecesOne,board,null);
				AggressivePlayer player2 = new AggressivePlayer("AggressiveAI",piecesTwo,board,player1);	
				player1.setOpponent(player2);
				board(jp,player1,player2,piecesOne,piecesTwo);
				}//if name invalid
				else{
					JOptionPane.showMessageDialog(null, "You need to type your name.", "Your name",JOptionPane.WARNING_MESSAGE);  			
					menu(jp);
		        }
			currentGame=3;
			}
		});
		jp.add(vsAggressivePlayer);	
		
		//background images
		JLabel bg =new JLabel();	
		bg.setIcon(new ImageIcon("images/bg.jpg"));	
		bg.setBounds(0,0,1175,900);
		jp.add(bg);	

	}	 
	/**
	 * display board
	 * @param jp JPanel
	 * @param p1 player1
	 * @param p2 player2
	 * @param ps1 pieces1
	 * @param ps2 pieces2
	 */
	public static void board(JPanel jp,Player p1,Player p2, Pieces ps1, Pieces ps2){
	//counter for next move player
	if(counter%2==0)
		movingPlayer = p2;
	else
		movingPlayer = p1;
	
	//display pieces	
	displayPieces(jp, board);
	
	//display board
	for(int i=0;i<8;i++)  { 
        for(int j=0;j<8;j++)  {
		    Color color=new Color(Integer.decode("#663300"));;  
		    JLabel label2=new JLabel();
            label2.setSize(DEFAULT_GRID, DEFAULT_GRID);
			label2.setLocation(75+i*DEFAULT_GRID, j*DEFAULT_GRID);
			if((i+j)%2==0)
				color=new Color(Integer.decode("#ffd9b3"));
			label2.setOpaque(true); 
			label2.setBackground(color); 
			jp.add(label2);				
				
        }  
	}
		
    JLabel label3 = new JLabel();
	//display moving player	
	JLabel nextMove = new JLabel("Next move is:");
	nextMove.setFont(new Font("Dialog",1,25));	
	nextMove.setForeground(Color.white);	
	nextMove.setBounds(850+75,50,200,25);
	jp.add(nextMove);
	JLabel playerName = new JLabel(""+movingPlayer);

	playerName.setFont(new Font("Dialog",1,25));	
	playerName.setForeground(Color.white);	
	playerName.setBounds(850+75,100,200,25);	
	jp.add(playerName,BorderLayout.CENTER);
	//display move from
	JLabel fromMove = new JLabel("Your move from: (format: 'X,X')");
	fromMove.setFont(new Font("Dialog",1,17));	
	fromMove.setForeground(Color.white);
	fromMove.setBounds(900,200,270,25);
	jp.add(fromMove);
	

	JTextField fromTf =new JTextField();
	fromTf.setBounds(975,300,95,35);	
	jp.add(fromTf);

	//get move display
	JLabel toMove = new JLabel("Your move to: (format: 'X,X')");
	toMove.setFont(new Font("Dialog",1,17));	
	toMove.setForeground(Color.white);
	toMove.setBounds(900,400,270,25);
	jp.add(toMove);
	
	JTextField toTf =new JTextField();
	toTf.setBounds(975,500,95,35);
	jp.add(toTf);
	
	//confirm button
    JButton confirm=new JButton("Confirm");	
	confirm.setBounds(975,600,95,35);
	jp.add(confirm);

	//confirm button listener
	confirm.addActionListener(new ActionListener() {
	@Override        
		public void actionPerformed(ActionEvent e) {
		//if current player is human player
		if(currentGame==1){
		jp.removeAll();
		jp.updateUI();
		//get move from text field
	    String from=fromTf.getText();
		String fromX = from.substring(0,1);
		int fromY = Integer.parseInt(from.substring(2,3));
		
		String to=toTf.getText();	
		String toX = to.substring(0,1);
		int toY = Integer.parseInt(to.substring(2,3));	
		//create new move
		Move move = new Move(board.getPiece(intoInt(fromX),8-fromY),intoInt(fromX),8-fromY,intoInt(toX),8-toY,getOpp(board,toX,toY));
			
		Piece piece = board.getPiece(intoInt(fromX),8-fromY);
		//check whether move is available 
		if(move.available(piece,move)==1 && (movingPlayer.getPieces() == move.getNextMovePieces(ps1,ps2))){
			updatePiece(piece,move.getNewX(),move.getNewY());
			updateBoard(board,move,piece);
			board(jp,p1,p2,ps1,ps2);
			//if piece successfully update
			//counter plus one
			counter++;		
		}
		else if(movingPlayer.getPieces() != move.getNextMovePieces(ps1,ps2))
			JOptionPane.showMessageDialog(null, "Invalid input. It is "+movingPlayer+" moving.");    	
		else 
			JOptionPane.showMessageDialog(null, "Invalid move.");    	
	
		jp.removeAll();
		jp.updateUI();
		//game over method to check if king has been taken
		gameOver(board,jp);
		board(jp,p1,p2,ps1,ps2);
		
		}
		
		else if(currentGame==2){
		jp.removeAll();
		jp.updateUI();
			
		String from=fromTf.getText();
		String fromX = from.substring(0,1);
		int fromY = Integer.parseInt(from.substring(2,3));
		
		
		String to=toTf.getText();	
		String toX = to.substring(0,1);
		int toY = Integer.parseInt(to.substring(2,3));	
		
		Move move = new Move(board.getPiece(intoInt(fromX),8-fromY),intoInt(fromX),8-fromY,intoInt(toX),8-toY,getOpp(board,toX,toY));
			
		Piece piece = board.getPiece(intoInt(fromX),8-fromY);
			if(move.available(piece,move)==1 && (movingPlayer.getPieces() == move.getNextMovePieces(ps1,ps2))){
				updatePiece(piece,move.getNewX(),move.getNewY());
				updateBoard(board,move,piece);
				board(jp,p1,p2,ps1,ps2);
				counter++;
				jp.removeAll();
				jp.updateUI();
				RandomPlayer player2 = new RandomPlayer("RandomAI",ps2,board,p1);
				//game over method to check if king has been taken
				gameOver(board,jp);
				player2.generateGraphicalMove(board,chessBoard);
				
				//if piece successfully update
				//counter plus one
				counter++;				
			}
			//if move different color piece
			else
				JOptionPane.showMessageDialog(null, "Invalid input. It is "+movingPlayer+" moving.");    	
				
		jp.removeAll();
		jp.updateUI();
		
		//game over method to check if king has been taken
		gameOver(board,jp);
		board(jp,p1,p2,ps1,ps2);
		}
		else if(currentGame==3){
		jp.removeAll();
		jp.updateUI();
			
		String from=fromTf.getText();
		String fromX = from.substring(0,1);
		int fromY = Integer.parseInt(from.substring(2,3));
		
		
		String to=toTf.getText();	
		String toX = to.substring(0,1);
		int toY = Integer.parseInt(to.substring(2,3));	
		
	
		Move move = new Move(board.getPiece(intoInt(fromX),8-fromY),intoInt(fromX),8-fromY,intoInt(toX),8-toY,getOpp(board,toX,toY));
			
		Piece piece = board.getPiece(intoInt(fromX),8-fromY);
			if(move.available(piece,move)==1 && (movingPlayer.getPieces() == move.getNextMovePieces(ps1,ps2))){
				
				updatePiece(piece,move.getNewX(),move.getNewY());
				updateBoard(board,move,piece);
				board(jp,p1,p2,ps1,ps2);
				counter++;
				jp.removeAll();
				jp.updateUI();
				AggressivePlayer player2 = new AggressivePlayer("AggressiveAI",ps2,board,p1);	
				gameOver(board,jp);
				player2.generateGraphicalMove(board,chessBoard);
			
				counter++;				
			}
			else
				JOptionPane.showMessageDialog(null, "Invalid input. It is "+movingPlayer+" moving.");    	
		jp.removeAll();
		jp.updateUI();
		//game over method to check if king has been taken
		gameOver(board,jp);
		board(jp,p1,p2,ps1,ps2);
		}
		}
	});	

	Color color2=new Color(Integer.decode("#1a0d00"));
    label3.setSize(285, DEFAULT_GRID*8+65);
	label3.setLocation(875, 0);
	label3.setOpaque(true); 
	label3.setBackground(color2); 
	jp.add(label3);	
	
	//display y-axis from 1-8
	for(int i=0; i<8; i++){
		String corStr = ""+(8-i);
		JLabel corText=new JLabel(corStr);
		corText.setSize(75, 100);
		corText.setLocation(30, i*100);
		corText.setFont(new Font("Dialog",1,27));	
		corText.setForeground(Color.white);	
		jp.add(corText);
	}
	
	//display x-axis from A-H
	for(int i=0; i<8; i++){
		String corStr = String.valueOf((char)(65 + i));
		JLabel corText=new JLabel(corStr);
		corText.setSize(100, 65);
		corText.setLocation(120+i*100, 800);
		corText.setFont(new Font("Dialog",1,27));	
		corText.setForeground(Color.white);	
		jp.add(corText);
	}	
	
	//axis background display
	JLabel cor=new JLabel();
	Color corColor=new Color(Integer.decode("#1a0d00")); 	
    cor.setSize(900, 900);
	cor.setLocation(0, 0);
	cor.setOpaque(true); 
	cor.setBackground(corColor); 	
	jp.add(cor);
	
	}


	/**
	 * display pieces on board
	 * @param jp JPanel
	 * @param b Board
	 */
	public static void displayPieces(JPanel jp, Board b){		
		for(int i=0; i<8; i++){
			for(int j=0; j<8; j++){
				if(b.getPiece(j,i)!=null){						
				JLabel label=new JLabel();			
				intoImage(b.getPiece(j,i).getChar(),label);				
				label.setBounds(95+DEFAULT_GRID*j,20+DEFAULT_GRID*i,60,60);
				jp.add(label);		
				}
			}
		}				
	}
	/**
	 * 
	 * @param b Board
	 * @param tX target x-axis
	 * @param tY target y-axis
	 * @return if target piece is opponent
	 */
	public static boolean getOpp(Board b, String tX, int tY){
	boolean opp;
	//if piece is not null
	if(b.getPiece(intoInt(tX),8-tY)==null){
		opp=false;
	}
	//if piece as a opponent
	else if(board.getPiece(intoInt(tX),8-tY).getColour()==0)
		opp=true;
	else
		opp=false;
		
		return opp;
	}
	/**
	 * update piece on the board
	 * @param p current piece
	 * @param x new x
	 * @param y new y
	 */
	public static void updatePiece(Piece p, int x, int y){
		p.setPosition(x,y);	
	}	
	/**
	 * update board
	 * by set and delete a piece
	 * @param b Board
	 * @param m created move
	 * @param p current piece
	 */
	public static void updateBoard(Board b, Move m, Piece p){
		b.setPosition(m.getNewX(),m.getNewY(),p);
		b.deletePosition(m.getOldX(),m.getOldY(),p);			
	}
	
	/**
	 * 	import chess pieces images
	 * @param i piece char
	 * @param label JLabel
	 */
	public static void intoImage(char i,JLabel label){
		switch (i) {
		//white pieces
		case 'p':
			Icon icon=new ImageIcon("images/Chess_plt60.png"); 
			label.setIcon(icon);			
		break;
		case 'r':
			Icon icon2=new ImageIcon("images/Chess_rlt60.png"); 
			label.setIcon(icon2);			 
		break;			
		case 'n':
			Icon icon3=new ImageIcon("images/Chess_nlt60.png");  
			label.setIcon(icon3);			
		break;
		case 'b':
			Icon icon4=new ImageIcon("images/Chess_blt60.png");  
			label.setIcon(icon4);			
		break;
		case 'q':
			Icon icon5=new ImageIcon("images/Chess_qlt60.png"); 
			label.setIcon(icon5);			 
		break;
		case 'k':
			Icon icon7=new ImageIcon("images/Chess_klt60.png"); 
			label.setIcon(icon7);			 
		break;
		//black pieces
		case 'P':
			Icon icon8=new ImageIcon("images/Chess_pdt60.png"); 
			label.setIcon(icon8);			
		break;
		case 'R':
			Icon icon9=new ImageIcon("images/Chess_rdt60.png"); 
			label.setIcon(icon9);			 
		break;			
		case 'N':
			Icon icon10=new ImageIcon("images/Chess_ndt60.png");  
			label.setIcon(icon10);			
		break;
		case 'B':
			Icon icon11=new ImageIcon("images/Chess_bdt60.png");  
			label.setIcon(icon11);			
		break;
		case 'Q':
			Icon icon12=new ImageIcon("images/Chess_qdt60.png"); 
			label.setIcon(icon12);			 
		break;
		case 'K':
			Icon icon13=new ImageIcon("images/Chess_kdt60.png"); 
			label.setIcon(icon13);			 
		break;		
		}
	}
	
	/**
	 * convert board coordinate from string to integer
	 * @param i coordinate of X-axis on board
	 * @return integer of X-axis coordinate
	 */
	public static int intoInt(String i){
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
	
	/**
	 * method to check if king has been taken
	 * @param board Board
	 * @param jp Jpanel
	 */
	public static void gameOver(Board board,JPanel jp){
		int checkWinFlag1 = 0;
		int checkWinFlag2 = 0;		
		//iterating the whole board
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				//if found K
				if(board.getPiece(i,j)!=null&&board.getPiece(i,j).getChar()=='K')
					checkWinFlag1 = 1;
				//if found k
				if(board.getPiece(i,j)!=null&&board.getPiece(i,j).getChar()=='k')
					checkWinFlag2 = 1;
			}
		}
		//if not found k
		//player 2 win the game
		if(checkWinFlag1==1 && checkWinFlag2 ==0){		
			JOptionPane.showMessageDialog(null, "Player2 win", "Congratulations",JOptionPane.WARNING_MESSAGE); 
			//exit graphical display
			System.exit(0);	
		}
		//if not found K
		//player 1 win the game
		else if (checkWinFlag1==0 && checkWinFlag2 ==1){
			JOptionPane.showMessageDialog(null, "Player1 win", "Congratulations",JOptionPane.WARNING_MESSAGE);  			
			//exit graphical display
			System.exit(0);
		}
	}	

}