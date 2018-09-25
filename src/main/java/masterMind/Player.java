package masterMind;

public class Player {

	private Board board;

	public Player(Board board) {
		assert board != null;
		this.board = board;
	}

	public void put() {
		assert board != null;

		String tried = new LimitedStringDialog(
				"Intento? [cuatro letras de entre A-amarillo, R-rojo, V-verde, Z-azul,\r\n" + "B-blanco, N-negro]?",
				Cadena.DIMENSION).read();
		board.put(tried);
	}

	public void win() {
		new IO().writeln(Cadena.DIMENSION + " Muertos!!!! " + "! Victoria!!!!");
	}

}
