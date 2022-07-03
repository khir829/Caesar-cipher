
public class Cipher {
	public static final String alphabet = "abcdefghijklmnopqrstuvwxyz";

	public static StringBuffer cipher(String message, int shift) {
		message = message.toLowerCase();
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < message.length(); i++) {
			if (message.charAt(i) == ' ') {
				result.append(' ');
			} else {
				int charPos = alphabet.indexOf(message.charAt(i));
				int pos = (charPos + shift) % 26;
				result.append(alphabet.charAt(pos));
			}
		}

		return result;
	}
}
