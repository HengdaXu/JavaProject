// TODO: Add Javadoc comments for this class and all its methods. (Task 3)
/**
 * An Othello game class consisting of a game board and two Human players
 * with Human VS Human mode. It will show a completed game progress with
 * print game information method and playing method.
 */
public class OthelloControllerHumanVSHuman {

	protected Othello othello;
	PlayerHuman player1, player2;

	/**
	 * Constructs a new OthelloController with a new Othello game, ready to play
	 * with two users at the console.
	 */
	public OthelloControllerHumanVSHuman() {
		
		this.othello = new Othello();
		this.player1 = new PlayerHuman(this.othello, OthelloBoard.P1);
		this.player2 = new PlayerHuman(this.othello, OthelloBoard.P2);
	}
	
	/**
	 * Attempts to play a Othello Game under HumanVSHuman mode depending on 
	 * whether the game is overor not. Make moves on each term and report board 
	 * information on each move. When the game is finished, make a final report 
	 * of board information.
	 */
	public void play() {
		
		while (!othello.isGameOver()) {
			this.report();

			Move move = null;
			char whosTurn = othello.getWhoseTurn();

			if (whosTurn == OthelloBoard.P1)
				move = player1.getMove();
			if (whosTurn == OthelloBoard.P2)
				move = player2.getMove();

			this.reportMove(whosTurn, move);
			othello.move(move.getRow(), move.getCol());
		}
		this.reportFinal();
	}
	
	/**
	 * Print information on the console of player(p1 or p2) makes move with coordinates.
	 * @param whosTurn player (p1 or p2) represents by X or O.
	 * @param move token placement which represents position of current
	 * player's move.
	 */
	private void reportMove(char whosTurn, Move move) {
		System.out.println(whosTurn + " makes move " + move + "\n");
	}
	
	/**
	 * Print information on the console of game board information during the game. 
	 * Game board and the numbers of player's token will be shown.
	 */
	private void report() {
		
		String s = othello.getBoardString() + OthelloBoard.P1 + ":" 
				+ othello.getCount(OthelloBoard.P1) + " "
				+ OthelloBoard.P2 + ":" + othello.getCount(OthelloBoard.P2) + "  " 
				+ othello.getWhoseTurn() + " moves next";
		System.out.println(s);
	}
	
	/**
	 * Print information on the console of game board information when the
	 * game is finished. Game board and the numbers of player's token will
	 * be shown.
	 */
	private void reportFinal() {
		
		String s = othello.getBoardString() + OthelloBoard.P1 + ":" 
				+ othello.getCount(OthelloBoard.P1) + " "
				+ OthelloBoard.P2 + ":" + othello.getCount(OthelloBoard.P2) 
				+ "  " + othello.getWinner() + " won\n";
		System.out.println(s);
	}
	
	/**
	 * Run main to play two Humans against each other at the console.
	 * @param args
	 */
	public static void main(String[] args) {
		
		OthelloControllerHumanVSHuman oc = new OthelloControllerHumanVSHuman();
		oc.play();
	}

}
