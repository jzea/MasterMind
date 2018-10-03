package masterMind.controllers;

import masterMind.controllers.ContinueController;
import masterMind.controllers.PutController;
import masterMind.controllers.StartController;

public interface OperationControllerVisitor {

	void visit(StartController startController);

	void visit(PutController putController);

	void visit(ContinueController continueController);

}
