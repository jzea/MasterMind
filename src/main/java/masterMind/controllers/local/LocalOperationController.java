package masterMind.controllers.local;

import masterMind.controllers.OperationController;
import masterMind.controllers.OperationControllerVisitor;
import masterMind.models.Game;

public abstract class LocalOperationController extends LocalController implements OperationController {

	protected LocalOperationController(Game game) {
		super(game);
	}

	public abstract void accept(OperationControllerVisitor operationControllerVisitor);

}
