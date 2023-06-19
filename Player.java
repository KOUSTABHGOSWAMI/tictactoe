package TicTacToe;

public class Player {
private String player1;
private char symbol;

Player(String player1, char symbol)
{
	setsymbol(symbol);
	setname(player1);
}

private void setname(String player) {
	// TODO Auto-generated method stub
	if(player.length()!=0)
		this.player1=player;
}

public void setsymbol(char symbol) {
	// TODO Auto-generated method stub
	if(symbol!=' ' || symbol!='\0')
		this.symbol=symbol;
	return;
}
public char getsymbol() {
	return this.symbol;
}

public String getname() {
	return this.player1;
}
}
