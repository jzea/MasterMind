package masterMind.controllers.local;

import masterMind.models.Game;
import masterMind.controllers.ManualPutController;
import masterMind.models.Combination;

public class LocalManualPutController extends LocalPutController implements ManualPutController{

	public LocalManualPutController(Game game) {
		super(game);
	}

	@Override
	public Combination selectTarget() {
		Combination tried = new Combination();
		return tried;
	}


}
