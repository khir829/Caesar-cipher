
public class Cipher {
	private static final String alphabet = "abcdefghijklmnopqrstuvwxyz";
	private static final String specialChars = "/*!@#$%^&*()\"{}_[]|\\?/<>,.";

	/**
	 * The cipher method takes as an input message and shifts the letters based on
	 * the shift value. This is called the Caesar cipher.
	 * 
	 * In this case, encrypting is considered as shifting to the right and
	 * decrypting is to the left
	 * 
	 * @param message The message to either decrypt or encrypt
	 * @param shift   The shift value
	 * @return The encrypted/decrypted message
	 */
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
