package masterMind;

public class Logic {

	private Game game;

	private StartController startController;

	private PutController putController;

	public Logic() {
		game = new Game();
		startController = new StartController(game);
		putController = new PutController(game);
	}

	public Controller getController() {
		switch (game.getState()) {
		case INITIAL:
			return startController;
		case IN_GAME:
			return putController;
		case FINAL:
		default:
			return null;
		}
	}

}
