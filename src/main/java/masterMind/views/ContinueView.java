package masterMind.views;

import masterMind.controllers.ContinueController;
import masterMind.utils.YesNoDialog;

class ContinueView {

	void interact(ContinueController continueController) {
		continueController.resume(new YesNoDialog("Desea continuar").read());
	}
}
