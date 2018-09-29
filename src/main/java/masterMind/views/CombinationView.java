package masterMind.views;

import masterMind.models.Combination;
import masterMind.utils.IO;
import masterMind.utils.LimitedStringDialog;

class CombinationView {

	private Combination combination;

	private IO io;

	CombinationView(Combination combination) {
		assert combination != null;
		this.combination = combination;
		io = new IO();
	}

	void read(String title) {
		assert title != null;
		combination.setValue(new LimitedStringDialog(title, Combination.DIMENSION).read());
	}

	void write(String title) {
		new IO().writeln(title + " " + combination.getValue());
	}

}
