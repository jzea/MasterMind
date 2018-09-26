package masterMind.controller;

import masterMind.models.Game;
import masterMind.models.Combination;

public class ManualPutController extends PutController{

	public ManualPutController(Game game) {
		super(game);
	}

	@Override
	protected Combination selectTarget(String title) {
		Combination tried = new Combination();
		tried.read(title);
		return tried;
	}

}
