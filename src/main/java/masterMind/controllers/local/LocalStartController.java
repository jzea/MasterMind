package masterMind.controllers.local;

import masterMind.controllers.OperationControllerVisitor;
import masterMind.controllers.StartController;
import masterMind.models.Game;
import masterMind.models.State;


public class LocalStartController extends LocalOperationController implements StartController {

	private LocalPutController putController;

	protected LocalStartController(Game game) {
		super(game);
	}

	public void start(int mode) {
		assert this.getState() == State.INITIAL;
		if (mode == 1) {
			putController = new LocalManualPutController(this.getGame());
		} else {
			putController = new LocalRandomPutController(this.getGame());
		}
		this.createSecret();
		this.setState(State.IN_GAME);

	}

	public LocalPutController getPutController() {
		return putController;
	}

	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);
	}
}
