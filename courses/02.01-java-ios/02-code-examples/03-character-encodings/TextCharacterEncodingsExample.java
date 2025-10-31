import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * This program shows the effect of character encodings in Java. It shows that while Java uses
 * Unicode once characters or Strings are created in memory, a translation needs to happen when
 * bytes are converted into characters, and the other way around. The program also highlight typical
 * problems that arise if the developer does not control character encodings. Problems that manifest
 * themselves by seeing '?' or other strange characters appear in text messages.
 */
public class TextCharacterEncodingsExample {

  public static void main(String[] args) throws IOException {
    // Create an instance of the class
    TextCharacterEncodingsExample main = new TextCharacterEncodingsExample();

    // Create a message that contains characters that are not part of the ASCII character set
    // All these words mean "student" in different languages (English, French, Japanese, Ukrainian
    // and Arabic)
    String message = "student élève　学生 студент طالب";

    // Show the effect of different encodings
    main.encodeAndDecode(message, StandardCharsets.US_ASCII);
    main.encodeAndDecode(message, StandardCharsets.ISO_8859_1);
    main.encodeAndDecode(message, StandardCharsets.UTF_8);
    main.encodeAndDecode(message, StandardCharsets.UTF_16LE);
    main.encodeAndDecode(message, StandardCharsets.UTF_16);
  }

  private void encodeAndDecode(String message, Charset encoding) {
    // Read the message as bytes using the specified encoding
    byte[] bytes = message.getBytes(encoding);

    // Decode the bytes using the default encoding (UTF-8)
    String decodedMessageAsUtf8 = new String(bytes, StandardCharsets.UTF_8);

    System.out.println("Message: " + message);
    System.out.println("Number of bytes: " + bytes.length);
    System.out.println("Encoding: " + encoding);
    System.out.println("Message decoded as UTF-8: " + decodedMessageAsUtf8);

    System.out.println();
  }
}
