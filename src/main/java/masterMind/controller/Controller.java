package masterMind.controller;

import masterMind.models.Board;
import masterMind.models.Combination;
import masterMind.models.Game;
import masterMind.models.State;

public abstract class Controller {

	private Game game;

	protected Controller(Game game) {
		assert game != null;
		this.game = game;
	}

	public abstract void control();

	protected State getState() {
		return game.getState();
	}

	protected void setState(State state) {
		assert state != null;
		game.setState(state);
	}

	protected Game getGame() {
		return game;
	}

	protected boolean completeDead() {
		return game.completeDead();
	}

	protected void put(Combination combination) {
		game.put(combination);
	}

	protected void showDeadWounded() {
		game.showDeadWounded();
	}

	protected int countTrieds() {
		return game.countTrieds();
	}

	protected void createSecret() {
		game.createSecret();
	}

	protected void clear() {
		game.clear();
	}
}
