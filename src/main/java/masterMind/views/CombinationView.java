package masterMind.views;

import masterMind.models.Combination;
import masterMind.utils.IO;
import masterMind.utils.ValidCombination;

class CombinationView {

	private Combination combination;
	private String title;

	CombinationView(Combination combination) {
		assert combination != null;
		this.combination = combination;
		this.title = "Intento: [cuatro letras de entre A-amarillo, R-rojo, V-verde, Z-azul, B-blanco, N-negro]";
	}

	void readManual() {
		combination.setValue(new ValidCombination(title, Combination.DIMENSION).read());
	}

	void writeRandom() {
		new IO().writeln(title + " " + combination.getValue());
	}

}
