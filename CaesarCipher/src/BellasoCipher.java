import java.util.Scanner;

public class BellasoCipher {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a phrase to encrypt: ");
        String phrase = scanner.nextLine();

        System.out.print("Enter an encryption key: ");
        String key = scanner.nextLine();

        String caesarEncrypted = caesarEncrypt(phrase, 3);
        String bellasoEncrypted = bellasoEncrypt(phrase, key);

        System.out.println("Caesar Encrypted: " + caesarEncrypted);
        System.out.println("Bellaso Encrypted: " + bellasoEncrypted);

        String caesarDecrypted = caesarDecrypt(caesarEncrypted, 3);
        String bellasoDecrypted = bellasoDecrypt(bellasoEncrypted, key);

        System.out.println("Caesar Decrypted: " + caesarDecrypted);
        System.out.println("Bellaso Decrypted: " + bellasoDecrypted);

        scanner.close();
    }

    public static String caesarEncrypt(String message, int offset) {
        StringBuilder result = new StringBuilder();

        for (char c : message.toCharArray()) {
            if (Character.isLetter(c)) {
                if (Character.isUpperCase(c)) {
                    result.append((char) ((c + offset - 65) % 26 + 65));
                } else {
                    result.append((char) ((c + offset - 97) % 26 + 97));
                }
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    public static String caesarDecrypt(String message, int offset) {
        return caesarEncrypt(message, 26 - offset);
    }

    public static String bellasoEncrypt(String message, String key) {
        StringBuilder result = new StringBuilder();
        int keyLength = key.length();

        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            char k = key.charAt(i % keyLength);

            if (Character.isLetter(c)) {
                int base = Character.isUpperCase(c) ? 65 : 97;
                int shift = Character.toUpperCase(k) - 65;
                int offset = (c + shift - base) % 26;
                result.append((char) (offset + base));
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    public static String bellasoDecrypt(String message, String key) {
        StringBuilder result = new StringBuilder();
        int keyLength = key.length();

        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            char k = key.charAt(i % keyLength);

            if (Character.isLetter(c)) {
                int base = Character.isUpperCase(c) ? 65 : 97;
                int shift = Character.toUpperCase(k) - 65;
                int offset = (c - shift - base + 26) % 26;
                result.append((char) (offset + base));
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

}
