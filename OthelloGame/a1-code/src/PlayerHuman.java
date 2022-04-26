import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//TODO: Add Javadoc comments for this class and all its methods. (Task 3)
/**
 * This class creates Human player for Othello game which consists token
 * current player will take and make sure Human player make valid input
 */
public class PlayerHuman {
	
	private static final String INVALID_INPUT_MESSAGE = "Invalid number, please enter 1-8";
	private static final String IO_ERROR_MESSAGE = "I/O Error";
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

	private Othello othello;
	private char player;
	
	/**
	 * Constructs a Human player with given Othello game and given token.
	 * @param othello An Othello game
	 * @param player token (P1, P2) which represents players by X or O.
	 */
	public PlayerHuman(Othello othello, char player) {
		
		this.othello = othello;
		this.player = player;
	}
	
	/**
	 * Return current move from Human player's input by given row and col.
	 * 
	 * @return return coordinates by input row and col.
	 */
	public Move getMove() {
		
		int row = getMove("row: ");
		int col = getMove("col: ");
		return new Move(row, col);
	}
	
	/**
	 * Return a valid move or -1 by input message from console. Check this message
	 * is satisfied condition with 0~7 by board size or not a number. And return
	 * valid user input for the game.
	 * 
	 * @param message input int to String by player take on the console
	 * @return valid move given by player or -1.
	 */
	private int getMove(String message) {
		
		int move, lower = 0, upper = 7;
		while (true) {
			try {
				System.out.print(message);
				String line = PlayerHuman.stdin.readLine();
				move = Integer.parseInt(line);
				if (lower <= move && move <= upper) {
					return move;
				} else {
					System.out.println(INVALID_INPUT_MESSAGE);
				}
			} catch (IOException e) {
				System.out.println(INVALID_INPUT_MESSAGE);
				break;
			} catch (NumberFormatException e) {
				System.out.println(INVALID_INPUT_MESSAGE);
			}
		}
		return -1;
	}
}
