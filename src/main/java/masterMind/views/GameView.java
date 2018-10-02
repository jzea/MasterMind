package masterMind.views;

import masterMind.controllers.ManualPutController;
import masterMind.controllers.RandomPutController;
import masterMind.models.Combination;
import masterMind.utils.IO;
import masterMind.controllers.PutController;
import masterMind.controllers.PutControllerVisitor;
import masterMind.views.GameView;

class GameView implements PutControllerVisitor {

	private IO io = new IO();

	public void interact(PutController putController) {
		assert putController != null;
		putController.accept(this);
	}

	@Override
	public void visit(ManualPutController manualPutController) {
		Combination combination = manualPutController.selectTarget();
		new CombinationView(combination).readManual();
		this.process(manualPutController, combination);
	}

	@Override
	public void visit(RandomPutController randomPutController) {
		Combination combination = randomPutController.selectTarget();
		new CombinationView(combination).writeRandom();
		this.process(randomPutController, combination);
	}

	private void process(PutController putController, Combination combination) {
		putController.control(combination);
		if (!putController.completeDead()) {
			new BoardView(putController).showDeadWounded();
		} else {
			this.win();
		}
	}

	public void win() {
		new IO().writeln(Combination.DIMENSION + " Muertos!!!! " + "! Victoria!!!!");
	}

}
