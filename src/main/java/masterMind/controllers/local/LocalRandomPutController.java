package masterMind.controllers.local;

import masterMind.models.Game;
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

}
