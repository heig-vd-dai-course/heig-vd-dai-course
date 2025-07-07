package ch.heigvd.dai.commands;

import ch.heigvd.dai.ios.Readable;
import ch.heigvd.dai.ios.binary.BinaryFileReader;
import ch.heigvd.dai.ios.binary.BufferedBinaryFileReader;
import ch.heigvd.dai.ios.text.BufferedTextFileReader;
import ch.heigvd.dai.ios.text.TextFileReader;
import java.util.concurrent.Callable;
import picocli.CommandLine;

@CommandLine.Command(name = "read", description = "Read from a file.")
public class Read implements Callable<Integer> {
  @CommandLine.ParentCommand protected Root parent;

  @Override
  public Integer call() {
    Readable reader =
        switch (parent.getImplementation()) {
          case BINARY -> new BinaryFileReader();
          case TEXT -> new TextFileReader();
          case BUFFERED_BINARY -> new BufferedBinaryFileReader();
          case BUFFERED_TEXT -> new BufferedTextFileReader();
        };

    System.out.println(
        "Reading from "
            + parent.getFilename()
            + " using "
            + parent.getImplementation()
            + " implementation.");

    reader.read(parent.getFilename());
    return 0;
  }
}
