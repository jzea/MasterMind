package masterMind.controllers.local;

import masterMind.models.Game;
import masterMind.controllers.PutControllerVisitor;
import masterMind.controllers.RandomPutController;
import masterMind.models.Combination;

public class LocalRandomPutController extends LocalPutController implements RandomPutController {

	public LocalRandomPutController(Game game) {
		super(game);
	}

	@Override
	public Combination selectTarget() {
		Combination tried = new Combination();
		tried.generateRandom();
		return tried;
	}

	@Override
	public void accept(PutControllerVisitor putControllerVisitor) {
		putControllerVisitor.visit(this);
	}
}
