package masterMind.views;

import masterMind.controllers.OperationControllerVisitor;
import masterMind.controllers.ContinueController;
import masterMind.controllers.ManualPutController;
import masterMind.controllers.OperationController;
import masterMind.controllers.PutController;
import masterMind.controllers.RandomPutController;
import masterMind.controllers.StartController;
import masterMind.models.Combination;
import masterMind.utils.IO;
import masterMind.utils.LimitedIntDialog;
import masterMind.utils.YesNoDialog;

public class MasterMindView implements OperationControllerVisitor {

	private IO io = new IO();

	public void interact(OperationController controller) {
		assert controller != null;
		controller.accept(this);
	}

	@Override
	public void visit(StartController startController) {
		int mode = new LimitedIntDialog("Selecciona la partida? \n 1. Partida \n 2. Demo \n", 1, 2).read();
		startController.start(mode);
		new BoardView(startController).showSecret();
	}

	@Override
	public void visit(ContinueController continueController) {
		continueController.resume(new YesNoDialog("Desea continuar").read());
	}

	@Override
	public void visit(PutController putController) {
		Combination aa = null;
		if (putController instanceof RandomPutController) {
			aa = putController.selectTarget();
			new CombinationView(aa)
					.write("Intento: [cuatro letras de entre A-amarillo, R-rojo, V-verde, Z-azul, B-blanco, N-negro]");
		}
		if (putController instanceof ManualPutController) {
			aa = putController.selectTarget();
			new CombinationView(aa)
					.read("Intento: [cuatro letras de entre A-amarillo, R-rojo, V-verde, Z-azul, B-blanco, N-negro]");
		}
		putController.control(aa);
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
