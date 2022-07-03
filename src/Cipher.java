
public class Cipher {
	public static StringBuffer encrypt(String message, int shift) {
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < message.length(); i++) {
			char ch = (char) ((message.charAt(i) + shift));
			result.append(ch);
		}

		return result;
	}
}
