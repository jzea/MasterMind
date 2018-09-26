package masterMind.models;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

import masterMind.utils.IO;

public class Combination {

	private String value;

	public static final int DIMENSION = 4;

	public Combination(String value) {
		assert value != null;
		this.value = value;
	}
	public Combination() {
		this.generateRandom();
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

	private void generateRandom() {
		Color[] color = Color.values();
		Random generator = new Random();
		String random = "";
		for (int i = 0; i < Combination.DIMENSION; i++) {
			random += color[generator.nextInt(color.length)];
		}
		this.value = random;
		new IO().writeln("Secret : " + random);
	}
}
