package masterMind;

import java.util.Arrays;
import java.util.HashSet;

public class Cadena {

	private String value;

	public static final int DIMENSION = 4;

	public Cadena(String value) {
		assert value != null;
		this.value = value;
	}

	public String[] split() {
		String[] items = this.value.split("");
		return items;
	}

	public HashSet<String> noRepeatLetter() {
		HashSet<String> unic = new HashSet<String>();
		unic.addAll(Arrays.asList(this.split()));
		return unic;
	}

	public long filterLetter(String letter) {
		assert letter != null;
		return this.value.chars().filter(val -> val == letter.charAt(0)).count();
	}
}
