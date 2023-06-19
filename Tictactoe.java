package TicTacToe;
import java.util.Scanner;
public class Tictactoe {
	private Player player1;
	private Player player2;
	private Board board;
	private int playernum=0;
public static void main(String args[]) {
	Tictactoe ob=new Tictactoe();
ob.startgame();
}
public void startgame() {
	Scanner sc=new Scanner(System.in);
	// TODO Auto-generated method stub
	player1=takeinput(++playernum);
	player2=takeinput(++playernum);
	while(player2.getsymbol()==player1.getsymbol()) {
		System.out.println("Your symbol is already taken or invalid, Enter new symbol");
		char c=sc.next().charAt(0);
		player2.setsymbol(c);
	}
	
	board=new Board(player1.getsymbol(),player2.getsymbol());
	String player1name=player1.getname();
	String player2name=player2.getname();
	boolean player1turn=true;
	int status=Board.INCOMPLETE;
	while(status==Board.INCOMPLETE || status==Board.INVALID) {
		if(player1turn) {
			System.out.println("Player1 "+player1.getname()+"'s turn");
			System.out.println("Enter the x coordinate of the matrix");
			int x=sc.nextInt();
			System.out.println("Enter the Y coordinate of the matrix");
			int y=sc.nextInt();
			status=board.move(player1.getsymbol(),x,y);
			if(status==Board.INVALID) {
				System.out.println("Invalid Please try again");
				continue;
			}
		}
		else {
			System.out.println("Player2 "+player2.getname()+"'s turn");
			System.out.println("Enter the x coordinate of the matrix");
			int x=sc.nextInt();
			System.out.println("Enter the Y coordinate of the matrix");
			int y=sc.nextInt();
			status= board.move(player2.getsymbol(),x,y);
			if(status==Board.INVALID) {
				System.out.println("Invalid Please try again");
				continue;
		}
	}
		player1turn=!player1turn;
		board.print();
		
	}
	System.out.println();
	if(status==Board.PLAYER1WIN)
		System.out.println("----Player1 "+player1name+" Wins!-----");
	if(status==Board.PLAYER2WIN)
		System.out.println("----Player2 "+player2name+" Wins!-----");
	else
		System.out.println("----Draw!----");
}
private Player takeinput(int num) {
	// TODO Auto-generated method stub
Scanner sc=new Scanner(System.in);
System.out.println("Player number-"+num);
System.out.println("Enter the name: ");
String name=sc.next();
System.out.println("Player number- "+num);
System.out.println("Enter the symbol and make sure it is not empty: ");
char symbol=sc.next().charAt(0);
Player p=new Player(name,symbol);
return p;
}
}
