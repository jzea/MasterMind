package masterMind.models;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import masterMind.utils.LimitedStringDialog;

public class Combination {

	private String value;

	public static final int DIMENSION = 4;

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

	public void generateRandom() {
		Color[] color = Color.values();
		Random generator = new Random();
		String random = "";
		for (int i = 0; i < Combination.DIMENSION; i++) {
			random += color[generator.nextInt(color.length)];
		}
		this.value = random;
	}

	public String getValue() {
		return this.value;
	}
	public void setValue(String value) {
		this.value = value ;
	}
}
