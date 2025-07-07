package ch.heigvd.dai;

import ch.heigvd.dai.commands.Root;
import java.io.File;
import picocli.CommandLine;

public class Main {

  public static void main(String[] args) {
    // Define command name - source: https://stackoverflow.com/a/11159435
    String jarFilename =
        new File(Main.class.getProtectionDomain().getCodeSource().getLocation().getPath())
            .getName();

    // Create root command
    Root root = new Root();

    // Execute command and get exit code
    int exitCode =
        new CommandLine(root)
            .setCommandName(jarFilename)
            .setCaseInsensitiveEnumValuesAllowed(true)
            .execute(args);

    System.exit(exitCode);
  }
}
