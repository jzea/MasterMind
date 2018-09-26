package masterMind.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import masterMind.utils.IO;

public class Board {
	private Combination secret;
	private List<Combination> tried;

	public Board() {
		this.tried = new ArrayList<>();
	}
	
	public void createSecret() {
		this.secret = new Combination();
	}

	public void put(String value) {
		assert value != null;
		this.tried.add(new Combination(value));
	}

	private int calculateDead() {
		int countDead = 0;
		for (int i = 0; i < Combination.DIMENSION; i++) {
			if (this.secret.split()[i].equals(this.tried.get(this.tried.size() - 1).split()[i])) {
				countDead++;
			}
		}
		return countDead;
	}

	private int calculateWounded() {
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


	public void writeResult() {
		new IO().writeln(this.calculateDead() + " Muertos " + this.calculateWounded() + " heridos");
	}
	
	public void clear() {
		this.tried.clear();
	}
}
