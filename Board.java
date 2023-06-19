package TicTacToe;

public class Board {
private char board[][];
private int boardsize=3;
private char p1symbol,p2symbol;
public static final int PLAYER1WIN=1;
public static final int PLAYER2WIN=2;
public static final int DRAW=3;
public static final int INCOMPLETE=4;
public static final int INVALID=5;
private static final char Value=' ';
private int size;
Board(char p1sym,char p2sym){
	this.p1symbol=p1sym;
	this.p2symbol=p2sym;
	board=new char[boardsize][boardsize];
	for(int i=0;i<3;i++) {
		for(int j=0;j<3;j++) {
			board[i][j]=Value;
		}
	}
	this.size=0;
	
}
public int getsize() {
	return this.size;
}
public void setsize(int newsize) {
	this.size=newsize;
}
public  int move(char symbol, int x, int y) {
	// TODO Auto-generated method stub
	if(x<0||x>=boardsize||y<0||y>=boardsize||board[x][y]!=' ')
		return INVALID;
	board[x][y]=symbol;
	size++;
	if(board[x][0]==board[x][1] &&board[x][0]==board[x][2])
		return symbol==p1symbol?PLAYER1WIN:PLAYER2WIN;
	if(board[0][y]==board[1][y] &&board[0][y]==board[2][y])
		return symbol==p1symbol?PLAYER1WIN:PLAYER2WIN;
	if(board[0][0]!=Value&& board[0][0]==board[1][1]&&board[0][0]==board[2][2])
		return symbol==p1symbol?PLAYER1WIN:PLAYER2WIN;
	if(board[0][2]!=Value&& board[0][2]==board[1][1]&&board[0][2]==board[2][0])
		return symbol==p1symbol?PLAYER1WIN:PLAYER2WIN;
	if(size==boardsize*boardsize)
		return DRAW;
	
	return INCOMPLETE;
		
		
}
public void print() {
	for(int i=0;i<boardsize;i++) {
		System.out.println("-------------------------");
		for(int j=0;j<boardsize;j++) {
			System.out.print("| "+board[i][j]+" |");
		}
		System.out.println();
	}
}

}
