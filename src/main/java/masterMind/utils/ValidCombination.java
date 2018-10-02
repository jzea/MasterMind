package masterMind.utils;

import masterMind.models.Color;

public class ValidCombination {

	private String title;
	private int size;

	public ValidCombination(String title, int size) {
		assert title != null;
		assert size != 0;
		this.title = title;
		this.size = size;
	}

	public String read() {
		IO io = new IO();
		String tried;
		Boolean validLimit;
		Boolean validEnum;
		do {
			tried = io.readString(title);
			validLimit = this.limitString(tried);
			validEnum = this.validEnum(tried);
			if (!validLimit || !validEnum) {
				io.writeln("La cadena es incorrecta");
			}

		} while (!validLimit || !validEnum);
		return tried;
	}

	private boolean limitString(String tried) {
		assert tried != null;
		if (tried.length() == this.size) {
			return true;
		}
		return false;
	}

	private boolean validEnum(String tried) {
		assert tried != null;
		String[] value = tried.split("");
		for (int i = 0; i < tried.length(); i++) {
			if (!Color.validate(value[i].charAt(0))) {
				return false;
			}
		}
		return true;
	}
}
