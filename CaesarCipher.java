public class CaesarCipher extends Ciphers {
    private static final int DEFAULT_SHIFT = 3;

    public static String encode(String text) {
        return encode(text, DEFAULT_SHIFT);
    }

    public static String decode(String text) {
        return decode(text, DEFAULT_SHIFT);
    }

    public static String encode(String text, int shift) {
        String encodedText = "";

        for (int i = 0; i < text.length(); i++) {
            char letter = text.charAt(i);

            if (Character.isUpperCase(letter)) {
                char shifted = (char) ('A' + (letter - 'A' - shift + 26) % 26);
                encodedText += shifted;
            }
            else if (Character.isLowerCase(letter)) {
                char shifted = (char) ('a' + (letter - 'a' - shift + 26) % 26);
                encodedText += shifted;
            }
            else {
                encodedText += letter;
            }
        }

        return encodedText;
    }

    public static String decode(String text, int shift) {
        String decodedText = "";

        for (int i = 0; i < text.length(); i++) {
            char letter = text.charAt(i);
            if (Character.isUpperCase(letter)) {
                char shifted = (char) ('A' + (letter - 'A' + shift) % 26);
                decodedText += shifted;
            }
            else if (Character.isLowerCase(letter)) {
                char shifted = (char) ('a' + (letter - 'a' + shift) % 26);
                decodedText += shifted;
            }
            else {
                decodedText += letter;
            }
        }

        return decodedText;
    }
}
