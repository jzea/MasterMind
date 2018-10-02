package masterMind.views;

import masterMind.controllers.StartController;
import masterMind.utils.LimitedIntDialog;

class StartView {

	void interact(StartController startController) {
		int mode = new LimitedIntDialog("Selecciona la partida? \n 1. Partida \n 2. Demo \n", 1, 2).read();
		startController.start(mode);
		new BoardView(startController).showSecret();
	}
}
