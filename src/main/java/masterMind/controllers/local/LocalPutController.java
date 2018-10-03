package masterMind.controllers.local;

import masterMind.controllers.OperationControllerVisitor;
import masterMind.controllers.PutController;
import masterMind.models.Combination;
import masterMind.models.Game;
import masterMind.models.State;

public abstract class LocalPutController extends LocalOperationController implements PutController {
	public static final int MAXTRIEDS = 10;

	public LocalPutController(Game game) {
		super(game);
		assert game != null;
	}

	public void control(Combination tried) {
		assert this.getState() == State.IN_GAME;
		this.put(tried);
		if (this.completeDead()) {
			this.setState(State.FINAL);
		} else {
			if (this.countTrieds() == LocalPutController.MAXTRIEDS) {
				this.setState(State.FINAL);
			}
		}
	}

	public abstract Combination selectTarget();

	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		assert operationControllerVisitor != null;
		operationControllerVisitor.visit(this);
	}

}
