package masterMind;

import masterMind.controllers.local.Logic;
import masterMind.controllers.local.LocalOperationController;
import masterMind.views.MasterMindView;

public class MasterMind {

	private Logic logic;
	private MasterMindView view;

	public MasterMind() {
		logic = new Logic();
		view = new MasterMindView();
	}

	public void play() {
		LocalOperationController controller;
		do {
			controller = logic.getController();
			
			if (controller != null){
				view.interact(controller);
			}
		} while (controller != null);
	}

	public static void main(String[] args) {
		new MasterMind().play();
	}
}
