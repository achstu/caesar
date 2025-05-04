public class CaesarCipher extends Cipher {
    private int shift;   // Number of positions to shift letters to the left

    public static void setShift(int shift) {
        this.shift = shift;
    }

    @Override
    public String encode(String text) {
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

    @Override
    public String decode(String text) {
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