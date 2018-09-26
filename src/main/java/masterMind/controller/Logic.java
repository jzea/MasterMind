package masterMind.controller;

import masterMind.models.Game;

public class Logic {

	private Game game;

	private StartController startController;

	private PutController putController;
	private ContinueController continueController;

	public Logic() {
		game = new Game();
		startController = new StartController(game);
		putController = new PutController(game);
		continueController= new ContinueController(game);
	}

	public Controller getController() {
		switch (game.getState()) {
		case INITIAL:
			return startController;
		case IN_GAME:
			return putController;
		case FINAL:
			return continueController;
		default:
			return null;
		}
	}

}
