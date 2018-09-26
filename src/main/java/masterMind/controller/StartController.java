package masterMind.controller;

import masterMind.models.Game;
import masterMind.models.State;

public class StartController extends Controller {

	protected StartController(Game game){
		super(game);
	}
	
	public void control() {
		assert this.getState() == State.INITIAL;
		this.setState(State.IN_GAME);
	}

}
