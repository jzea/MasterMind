package masterMind.controllers;

public interface PutControllerVisitor {

	void visit(ManualPutController manualPutController);

	void visit(RandomPutController randomPutController);
}
