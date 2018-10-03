package masterMind.controllers.local;

import masterMind.models.Game;

public class Logic {

	private Game game;
	private LocalStartController startController;
	private LocalContinueController continueController;

	public Logic() {
		game = new Game();
		startController = new LocalStartController(game);
		continueController = new LocalContinueController(game);
	}

	public LocalOperationController getController() {
		switch (game.getState()) {
		case INITIAL:
			return startController;
		case IN_GAME:
			return startController.getPutController();
		case FINAL:
			return continueController;
		default:
			return null;
		}
	}

}
