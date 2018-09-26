package masterMind.utils;

public class LimitedStringDialog {

	private String title;
	private int size;

	public LimitedStringDialog(String title, int size) {
		assert title != null;
		assert size != 0;
		this.title = title;
		this.size = size;
	}

	public String read() {
		IO io = new IO();
		String tried;
		do {
			tried = io.readString(title);

			if (!((int) tried.length() == this.size)) {
				io.writeln("La cadena debe tener  " + this.size + " caracteres");
			}
		} while (!((int) tried.length() == this.size));
		return tried;
	}
}
