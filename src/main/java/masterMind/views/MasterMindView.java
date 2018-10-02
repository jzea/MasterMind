package masterMind.views;

import masterMind.controllers.OperationControllerVisitor;
import masterMind.controllers.ContinueController;
import masterMind.controllers.OperationController;
import masterMind.controllers.PutController;
import masterMind.controllers.StartController;
import masterMind.models.Combination;
import masterMind.utils.IO;
import masterMind.views.StartView;
import masterMind.views.ContinueView;
import masterMind.views.GameView;

public class MasterMindView implements OperationControllerVisitor {

	private IO io = new IO();
	private StartView startView;

	private GameView gameView;

	private ContinueView continueView;

	public MasterMindView() {
		startView = new StartView();
		gameView = new GameView();
		continueView = new ContinueView();
	}

	public void interact(OperationController controller) {
		assert controller != null;
		controller.accept(this);
	}

	@Override
	public void visit(StartController startController) {
		startView.interact(startController);
	}

	@Override
	public void visit(ContinueController continueController) {
		continueView.interact(continueController);
	}

	@Override
	public void visit(PutController putController) {
		gameView.interact(putController);
	}

	public void win() {
		new IO().writeln(Combination.DIMENSION + " Muertos!!!! " + "! Victoria!!!!");
	}
}
