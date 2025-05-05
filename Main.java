import java.nio.charset.StandardCharsets;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException; // TODO: handling IOException better

public class Main {

  public static void help() {
    System.err.println("Usage: java Main CIPHER MODE FILE");
    System.err.println("");
    System.err.println("Available ciphers: CAESAR, MORSE");
    System.err.println("Available modes: DECODE, ENCODE, PASS");
    System.exit(1);
  }

  public static void main(String[] args) throws Exception {
    if (args.length != 3) {
      help();
    }

    String cipher = args[0];
    String mode = args[1];

    String file = args[2];
    String text = Files.readString(Paths.get(file), StandardCharsets.UTF_8);

    switch (cipher) {
      case "CAESAR":
        //TODO - fix
        switch (mode) {
          case "DECODE" -> System.out.println(CaesarCipher.decode(text));
          case "ENCODE" -> System.out.println(CaesarCipher.encode(text));
          case "PASS" -> System.out.println(text);
          default -> help();
        }
        break;
      case "MORSE":
        switch (mode) {
          case "DECODE" -> System.out.println(MorseCipher.decode(text));
          case "ENCODE" -> System.out.println(MorseCipher.encode(text));
          case "PASS" -> System.out.println(text);
          default -> help();
        }
        break;
    }
  }
}
