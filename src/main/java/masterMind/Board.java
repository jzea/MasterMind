package masterMind;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board {
	private Cadena secret;
	private List<Cadena> tried;

	public Board() {
		this.tried = new ArrayList<>();
		String random = this.random();
		this.secret = new Cadena(random);
		new IO().writeln("Secret : " + random);
	}

	public void put(String value) {
		assert value != null;
		tried.add(new Cadena(value));
	}

	private int calculateDead() {
		int countDead = 0;
		for (int i = 0; i < Cadena.DIMENSION; i++) {
			if (this.secret.split()[i].equals(this.tried.get(tried.size() - 1).split()[i])) {
				countDead++;
			}
		}
		return countDead;
	}

	private int calculateWounded() {
		long coutWounded = 0;
		for (String letter : secret.noRepeatLetter()) {
			long occurrencesSecret = secret.filterLetter(letter);
			long occurrencesTried = this.tried.get(tried.size() - 1).filterLetter(letter);
			coutWounded += Math.min(occurrencesSecret, occurrencesTried);
		}
		return (int) coutWounded - this.calculateDead();
	}

	public boolean completeDead() {
		if (this.calculateDead() == Cadena.DIMENSION) {
			return true;
		}
		return false;
	}

	public String random() {
		Color[] color = Color.values();
		Random generator = new Random();
		String random = "";
		for (int i = 0; i < Cadena.DIMENSION; i++) {
			random += color[generator.nextInt(color.length)];
		}
		return random;
	}

	public void writeResult() {
		new IO().writeln(this.calculateDead() + " Muertos " + this.calculateWounded() + " heridos");
	}
}
