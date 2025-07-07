import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * This program copies the content of a text file to another text file under a new name. It
 * explicitly set the end of line character to '\n' to ensure that the output file has the same end
 * of line character on all platforms. It opens the input file using a FileInputStream class as
 * binary data. It then uses the class InputStreamReader to decode the binary data to text data
 * using the UTF-8 character encoding. And finally, it uses the BufferedReader class to read the
 * text data with a buffer. It opens the output file using a FileOutputStream class as binary data.
 * It then uses th class OutputStreamWriter to write the file with the UTF-8 character encoding. And
 * finally, it uses a BufferedWriter class to write the binary data with a buffer.
 */
class TextEndOfLineCharactersExample {

  public static String END_OF_LINE = "\n";

  public static void main(String[] args) throws IOException {
    InputStream is = new FileInputStream("TextEndOfLineCharactersExample.java");
    Reader reader = new InputStreamReader(is, StandardCharsets.UTF_8);
    BufferedReader br = new BufferedReader(reader);

    OutputStream os = new FileOutputStream("TextEndOfLineCharactersExample.txt");
    Writer writer = new OutputStreamWriter(os, StandardCharsets.UTF_8);
    BufferedWriter bw = new BufferedWriter(writer);

    String line;
    while ((line = br.readLine()) != null) {
      // Careful: line does not contain end of line characters
      bw.write(line + END_OF_LINE);
    }

    bw.flush();
    bw.close();
    br.close();
  }
}
