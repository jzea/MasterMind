package masterMind.controller;

import masterMind.models.Combination;
import masterMind.models.Game;
import masterMind.models.State;
import masterMind.utils.IO;
import masterMind.utils.LimitedStringDialog;

public abstract class PutController extends Controller {
	public static final int MAXTRIEDS = 10;
	private Combination tried;

	public PutController(Game game) {
		super(game);
		assert game != null;
	}

	public void control() {
		assert this.getState() == State.IN_GAME;
		String title = "Intento: [cuatro letras de entre A-amarillo, R-rojo, V-verde, Z-azul,\r\n"
				+ "B-blanco, N-negro] ";
		tried = this.selectTarget(title);

		this.getBoard().put(tried);
		if (this.getBoard().completeDead()) {
			this.setState(State.FINAL);
			this.win();
		} else {
			this.getBoard().writeResult();
			if (this.getBoard().countTried() == PutController.MAXTRIEDS) {
				this.setState(State.FINAL);
			}
		}
	}

	public void win() {
		new IO().writeln(Combination.DIMENSION + " Muertos!!!! " + "! Victoria!!!!");
	}

	protected abstract Combination selectTarget(String title);
}
