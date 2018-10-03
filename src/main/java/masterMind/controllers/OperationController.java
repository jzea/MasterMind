package masterMind.controllers;

import masterMind.models.Combination;

public interface OperationController {

	void accept(OperationControllerVisitor operationControllerVisitor);

	int calculateDead();

	int calculateWounded();

	Combination getSecret();
}
