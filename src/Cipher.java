
public class Cipher {
	private static final String alphabet = "abcdefghijklmnopqrstuvwxyz";
	private static final String specialChars = "/*!@#$%^&*()\"{}_[]|\\?/<>,.";

	public static StringBuffer cipher(String message, int shift) {
		message = message.toLowerCase();
		StringBuffer result = new StringBuffer();

		for (int i = 0; i < message.length(); i++) {
			String stringValueOf = String.valueOf(message.charAt(i));
			if (message.charAt(i) == ' ') {
				result.append(' ');
			} else if (specialChars.contains(stringValueOf)) {
				result.append(message.charAt(i));
			} else {
				int charPos = alphabet.indexOf(message.charAt(i));
				int pos = Math.abs((charPos + shift) % 26);
				result.append(alphabet.charAt(pos));
			}
		}

		return result;
	}
}
