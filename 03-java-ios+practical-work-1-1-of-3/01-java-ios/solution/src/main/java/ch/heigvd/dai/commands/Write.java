package ch.heigvd.dai.commands;

import ch.heigvd.dai.ios.Writable;
import ch.heigvd.dai.ios.binary.BinaryFileWriter;
import ch.heigvd.dai.ios.binary.BufferedBinaryFileWriter;
import ch.heigvd.dai.ios.text.BufferedTextFileWriter;
import ch.heigvd.dai.ios.text.TextFileWriter;
import java.util.concurrent.Callable;
import picocli.CommandLine;

@CommandLine.Command(name = "write", description = "Write to a file.")
public class Write implements Callable<Integer> {
  @CommandLine.ParentCommand protected Root parent;

  @CommandLine.Option(
      names = {"-s", "--size"},
      description = "Size in bytes",
      required = true)
  protected int sizeInBytes;

  @Override
  public Integer call() {
    Writable writer =
        switch (parent.getImplementation()) {
          case BINARY -> new BinaryFileWriter();
          case TEXT -> new TextFileWriter();
          case BUFFERED_BINARY -> new BufferedBinaryFileWriter();
          case BUFFERED_TEXT -> new BufferedTextFileWriter();
        };

    System.out.println(
        "Writing to "
            + parent.getFilename()
            + " using "
            + parent.getImplementation()
            + " implementation.");

    writer.write(parent.getFilename(), sizeInBytes);
    return 0;
  }
}
