package masterMind.models;

import java.util.ArrayList;
import java.util.List;

public class Board {
	private Combination secret;
	private List<Combination> tried;

	public Board() {
		this.tried = new ArrayList<>();
	}

	public void createSecret() {
		this.secret = new Combination();
		this.secret.generateRandom();
	}

	public void put(Combination combination) {
		assert combination != null;
		this.tried.add(combination);
	}

	public int calculateDead() {
		int countDead = 0;
		for (int i = 0; i < Combination.DIMENSION; i++) {
			if (this.secret.split()[i].equals(this.tried.get(this.tried.size() - 1).split()[i])) {
				countDead++;
			}
		}
		return countDead;
	}

	public int calculateWounded() {
		long coutWounded = 0;
		for (String letter : secret.noRepeatLetter()) {
			long occurrencesSecret = secret.filterLetter(letter);
			long occurrencesTried = this.tried.get(this.tried.size() - 1).filterLetter(letter);
			coutWounded += Math.min(occurrencesSecret, occurrencesTried);
		}
		return (int) coutWounded - this.calculateDead();
	}

	public boolean completeDead() {
		if (this.calculateDead() == Combination.DIMENSION) {
			return true;
		}
		return false;
	}


	public void clear() {
		this.tried.clear();
	}

	public int countTrieds() {
		return tried.size();
	}
	public Combination getSecret() {
		return secret;
	}
}
