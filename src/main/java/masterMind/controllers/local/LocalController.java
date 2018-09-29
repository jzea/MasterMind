package masterMind.controllers.local;

import masterMind.models.Board;
import masterMind.models.Combination;
import masterMind.models.Game;
import masterMind.models.State;

public abstract class LocalController {

	private Game game;

	protected LocalController(Game game) {
		assert game != null;
		this.game = game;
	}


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

	public boolean completeDead() {
		return game.completeDead();
	}

	protected void put(Combination combination) {
		game.put(combination);
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
	public Combination getSecret() {
		return game.getSecret();
	}
	public int calculateDead() {
		return game.calculateDead();
	}
	public int calculateWounded() {
		return game.calculateWounded();
	}
}
