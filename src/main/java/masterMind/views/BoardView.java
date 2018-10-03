package masterMind.views;

import masterMind.controllers.OperationController;
import masterMind.utils.IO;

class BoardView {

	private OperationController controller;

	BoardView(OperationController controller) {
		assert controller != null;
		this.controller = controller;
	}

	void showSecret() {
		new IO().writeln("Secret : " + controller.getSecret().getValue());
	}

	void showDeadWounded() {
		new IO().writeln(controller.calculateDead() + " muertos " + controller.calculateWounded() + " heridos \n");
	}

}
