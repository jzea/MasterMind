package masterMind;

import masterMind.utils.IO;
import masterMind.utils.LimitedStringDialog;

public class PutController extends Controller {

	public PutController(Game game) {
		super(game);
		assert game != null;
	}

	public void control() {
		assert this.getState() == State.IN_GAME;
		String tried = new LimitedStringDialog(
				"Intento? [cuatro letras de entre A-amarillo, R-rojo, V-verde, Z-azul,\r\n" + "B-blanco, N-negro]?",
				Combination.DIMENSION).read();
		this.getBoard().put(tried);
		if (this.getBoard().completeDead()) {
			this.setState(State.FINAL);
			this.win();
		} else {
			this.getBoard().writeResult();
		}
	}

	public void win() {
		new IO().writeln(Combination.DIMENSION + " Muertos!!!! " + "! Victoria!!!!");
	}

}
