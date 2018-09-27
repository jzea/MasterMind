package masterMind.models;

public class Game {

	private State state;

	private Board board;

	public Game() {
		state = State.INITIAL;
		board = new Board();
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public boolean completeDead() {
		return board.completeDead();
	}

	public void put(Combination combination) {
		board.put(combination);
	}

	public void showDeadWounded() {
		board.showDeadWounded();
	}

	public int countTrieds() {
		return board.countTrieds();
	}

	public void createSecret() {
		board.createSecret();
	}

	public void clear() {
		board.clear();
	}
}
