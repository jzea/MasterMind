package masterMind.controller;

import masterMind.models.Game;
import masterMind.models.State;
import masterMind.utils.LimitedIntDialog;

public class StartController extends Controller {

	private PutController putController;

	protected StartController(Game game) {
		super(game);
	}

	public void control() {
		assert this.getState() == State.INITIAL;
		int mode = new LimitedIntDialog("Selecciona la partida? 1. Partida, 2. Demo", 1, 2).read();
		if (mode == 1) {
			putController = new ManualPutController(this.getGame());
		} else {
			putController = new RandomPutController(this.getGame());
		}
		this.getBoard().createSecret();
		this.setState(State.IN_GAME);
	}

	public PutController getPutController() {
		return putController;
	}

}
