import java.nio.charset.StandardCharsets;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException; // TODO: handling IOException better

public class Main {

  public static void help() {
    System.err.println("Usage: cezar MODE FILE");
    System.err.println("");
    System.err.println("Available modes: DECODE, ENCODE, PASS");
    System.exit(1);
  }

  public static void main(String[] args) throws Exception {
    if (args.length != 2) {
      help();
    }

    String mode = args[0];

    String file = args[1];
    String text = Files.readString(Paths.get(file), StandardCharsets.UTF_8);

    switch (mode) {
      case "DECODE" -> System.out.println(Ciphers.decode(text));
      case "ENCODE" -> System.out.println(Ciphers.encode(text));
      case "PASS" -> System.out.println(text);
      default -> help();
    }
  }
}
