package masterMind.controllers.local;

import masterMind.models.Game;
import masterMind.controllers.ManualPutController;
import masterMind.controllers.PutControllerVisitor;
import masterMind.models.Combination;

public class LocalManualPutController extends LocalPutController implements ManualPutController {

	public LocalManualPutController(Game game) {
		super(game);
	}

	@Override
	public Combination selectTarget() {
		Combination tried = new Combination();
		return tried;
	}

	@Override
	public void accept(PutControllerVisitor putControllerVisitor) {
		putControllerVisitor.visit(this);
	}
}
