package masterMind.models;

public enum Color {
	AMARILLO('A'), ROJO('R'), VERDE('V'), AZUL('Z'), BLANCO('B'), NEGRO('N');

	private char value;

	private Color(char value) {
		this.value = value;
	}

	public String toString() {
		return "" + value;
	}

	public static Boolean validate(char letter) {
		Color nodes[] = values();
		for (int i = 0; i < nodes.length; i++) {
			if (nodes[i].value == letter) {
				return true;
			}
		}
		return false;
	}
}
