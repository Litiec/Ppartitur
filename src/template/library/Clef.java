package ppartitur.lib;

public enum Clef {
	G("\uE050", new int[] { 5, 59 }, 60, 83), G15("\uE054", new int[] { 5, 59 }, 84, 107),
	F("\uE062", new int[] { 5, 40 }, 40, 59), F15("\uE063", new int[] { 5, 40 }, 21, 39),
	C_G("\uE050", new int[] { 5, 59 }, 72, 83), C("\uE05C", new int[] { 5, 50 }, 48, 71);
	String ref;
	int[] pos;
	int min, max;

	private Clef(String ref, int[] pos, int min, int max) {
		this.ref = ref;
		this.pos = pos;
		this.min = min;
		this.max = max;
	}
}