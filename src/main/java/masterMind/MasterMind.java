package masterMind;

public class MasterMind {

	private Player player;
	private Board board;

	public MasterMind() {
		board = new Board();
		player = new Player(board);
	}

	public void play() {
		do {
			player.put();
			board.writeResult();
		} while (!board.completeDead());
		player.win();
	}

	public static void main(String[] args) {
		new MasterMind().play();
	}
}
