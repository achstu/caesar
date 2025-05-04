public class MorseCipher extends Ciphers {
    private static String[] morseAlphabet = {".-", "-...", "-.-.", "-..", ".", "..-.", 
                              "--.", "....", "..", ".---", "-.-", ".-..", "--", 
                              "-.", "---", ".--.", "--.-", ".-.", "...", "-", 
                              "..-", "...-", ".--", "-..-", "-.--", "--.."};

    private static String[] morseNumbers = {"-----", ".----", "..---", "...--", "....-", 
                             ".....", "-....", "--...", "---..", "----."};

    public static String encode(String text) {
        String encodedText = "";

        for (int letterIndex = 0; letterIndex < text.length(); letterIndex++) {
            char letter = text.charAt(letterIndex);
            String letterInMorse = "";

            if (isBigLetter(letter)) letterInMorse = morseAlphabet[(int)letter - 65];
            else if (isSmallLetter(letter)) letterInMorse = morseAlphabet[(int)letter - 97];
            else if (isNumber(letter)) letterInMorse = morseNumbers[(int)letter - 48];
            else letterInMorse += letter; // when it comes to special symbols, the program leaves them as they were

            encodedText += letterInMorse + " ";
        }
        return encodedText;
    }

    public static String decode(String text) throws Exception {
        String decodedText = "";
        int asciiOfLetter = 0;

        // index for the symbol we are currently on while iterating through the message
        int symbolIndex = 0;

        while (symbolIndex < text.length()) {
            String morseLetter = "";
            String specialSymbols = "";
            boolean isSpecial = false;

            while (symbolIndex < text.length() && isDotDash(text.charAt(symbolIndex))) {
                morseLetter += text.charAt(symbolIndex);
                symbolIndex++;
            }

            // if the previous while loop ends on a special symbol that seperates the letters
            while (symbolIndex < text.length() && !isDotDash(text.charAt(symbolIndex))) {
                isSpecial = true;
                specialSymbols += text.charAt(symbolIndex);
                symbolIndex++;
            }
            
            // the symbol is supposedly a number, because only then it could be of length 5
            if (morseLetter.length() == 5) {
                asciiOfLetter = findSymbolIndex(morseNumbers, morseLetter) + 48;
            }

            else { // the symbol is supposedly a letter
                asciiOfLetter = findSymbolIndex(morseAlphabet, morseLetter) + 65;
            }

            decodedText += (char)asciiOfLetter;

            if (isSpecial) { // if a special symbol was detected, we add it to the decoded text
                decodedText += specialSymbols;
            }
        }
        return decodedText;
    }

    private static int findSymbolIndex(String[] arr, String symbol) throws Exception {
        for (int i = 0; i < arr.length; i++) {
            if (sameStrings(symbol, arr[i])) return i;
        }
        throw new Exception("Wrong symbol. The morse code converter only supports letters and numbers in morse form.");
    }
    
    private static boolean sameStrings(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }

    private static boolean isBigLetter(char symbol) {
        return ((int)symbol >= 65 && (int)symbol <= 90);
    }

    private static boolean isSmallLetter(char symbol) {
        return ((int)symbol >= 97 && (int)symbol <= 122);
    }

    private static boolean isNumber(char symbol) {
        return ((int)symbol >= 48 && (int)symbol <= 57);
    }

    private static boolean isDotDash(char symbol) {
        return ((int)symbol == 45 || (int)symbol == 46);
    }
}
