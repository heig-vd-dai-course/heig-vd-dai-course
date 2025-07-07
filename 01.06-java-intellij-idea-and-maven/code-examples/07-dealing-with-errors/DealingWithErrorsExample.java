import java.io.*;

/**
 * This program shows how to handle exceptions in Java. It shows how to handle exceptions in various
 * situations, how to close resources properly, and how to use the try-with-resources statement.
 */
class DealingWithErrorsExample {

  public static void main(String[] args) {
    // Bad practice
    tryCatchWithoutFinallyExample();

    // Better practice
    tryCatchFinallyExample();

    // Best practice
    tryWithResourcesExample();
  }

  public static void tryCatchWithoutFinallyExample() {
    try {
      Reader reader = new FileReader("missing.file");
      Writer writer = new FileWriter("missing.file");

      writer.write(reader.read());
    } catch (IOException e) {
      System.out.println("Exception: " + e);
    }
  }

  public static void tryCatchFinallyExample() {
    Reader reader = null;
    Writer writer = null;

    try {
      reader = new FileReader("missing.file");
      writer = new FileWriter("missing.file");

      writer.write(reader.read());
    } catch (IOException e) {
      System.out.println("Exception: " + e);
    } finally {
      if (writer != null) {
        try {
          writer.close();
        } catch (IOException e) {
          System.out.println("Exception in close writer: " + e);
        }
      }

      if (reader != null) {
        try {
          reader.close();
        } catch (IOException e) {
          System.out.println("Exception in close reader: " + e);
        }
      }
    }
  }

  public static void tryWithResourcesExample() {
    try (Reader reader = new FileReader("missing.file");
        Writer writer = new FileWriter("missing.file")) {
      writer.write(reader.read());
    } catch (IOException e) {
      System.out.println("Exception: " + e);
    }
  }
}
