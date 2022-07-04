import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Boolean flag = true;
		Boolean encryptMode = false;
		String message = " ";
		String messageAfter;
		String again = null;
		int shift = 0;
		Scanner scan = new Scanner(System.in);

		/*
		 * The program will loop until the user decides to terminate it by entering 'No'
		 * at the end. The program will do the following:
		 * 
		 * 1- The decision to encrypt or decrypt is determined by the user
		 * 
		 * 2- The shift value is determined by the user.
		 * 
		 * 3- The message to encrypted/decrypted message is determined by the user.
		 * 
		 * 4- The encrypted/decrypted message is output.
		 * 
		 * 5- The program will prompt the user to continue using the caesar cipher or
		 * terminate the program.
		 * 
		 */
		System.out.println("Welcome to the caesar cipher encrypter/decrypter");
		do {
			do {
				Scanner scanner1 = new Scanner(System.in);
				System.out.println("Please type 'encrypt' to encrypt a message or 'decrypt' to decrypt a message: ");
				String confirm = scanner1.nextLine();
				confirm = confirm.toLowerCase();
				if (confirm.equals("encrypt")) {
					encryptMode = true;
					flag = false;
				} else if (confirm.equals("decrypt")) {
					encryptMode = false;
					flag = false;
				} else {
					System.out.print("Wrong answer. ");
					flag = true;
				}
			} while (flag);
			do {
				try {
					Scanner scanner2 = new Scanner(System.in);
					System.out.print("Shift value: ");
					shift = scanner2.nextInt();
				} catch (Exception e) {
					System.out.print("Enter only integer values. ");
					flag = true;
				}
			} while (flag);

			System.out.println("Enter the message to encrypt/decrypt:  ");

			do {
				Scanner scanner3 = new Scanner(System.in);
				message = scanner3.nextLine();
				char[] ch = message.toCharArray();
				for (char c : ch) {
					if (Character.isDigit(c)) {
						System.out.println("No numbers allowed in caesar cipher! ");
						System.out.println("Enter a valid message to encrypt/decrypt: ");
						flag = true;
					}
				}

			} while (flag);

			if (encryptMode) {
				messageAfter = Cipher.cipher(message, shift).toString();
			} else {
				messageAfter = Cipher.cipher(message, -shift).toString();
			}

			System.out.println("Result: " + messageAfter);
			System.out.print("\nPress Enter to to use caesar cipher again or enter 'No' to terminate program: ");
			again = scan.nextLine();
			again = again.toLowerCase();
			System.out.println();
		} while (again instanceof String && !again.equals("no"));
	}

}
