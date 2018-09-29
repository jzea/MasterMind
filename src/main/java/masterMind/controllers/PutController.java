package masterMind.controllers;

import masterMind.models.Combination;

public interface PutController extends OperationController {

	void control(Combination combination);
	boolean completeDead();
	Combination selectTarget();
}
