package masterMind.controller;

import masterMind.models.Game;
import masterMind.models.Combination;
import masterMind.utils.IO;

public class RandomPutController extends PutController {

	public RandomPutController(Game game) {
		super(game);
	}

	@Override
	protected Combination selectTarget(String title) {

		Combination tried = new Combination();
		tried.generateRandom();
		new IO().writeln(this.getBoard().countTried()+1 + title +" "+ tried.getValue());
		//new IO().readString("Enter para continuar!");
		return tried;
	}

}