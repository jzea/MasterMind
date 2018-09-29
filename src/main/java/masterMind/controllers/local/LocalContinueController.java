package masterMind.controllers.local;

import masterMind.controllers.ContinueController;
import masterMind.controllers.OperationControllerVisitor;
import masterMind.models.Game;
import masterMind.models.State;

public class LocalContinueController extends LocalOperationController implements ContinueController {

	protected LocalContinueController(Game game) {
		super(game);
	}

	public void resume(boolean another) {
		assert this.getState() == State.FINAL;
		if (another) {
			this.clear();
			this.setState(State.INITIAL);
		} else {
			this.setState(State.EXIT);
		}
	}

	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);		
	}
}
