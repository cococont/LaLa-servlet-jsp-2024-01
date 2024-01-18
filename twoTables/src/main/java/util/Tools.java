package util;

public class Tools {
	public static int myParseInt(String num) {
		int x = 0;
		try {
			x = Integer.parseInt(num);
		} catch (NumberFormatException e) {
			x = 0;
		}
		return x;
	}
}
