package ch.heigvd.dai.commands;

import picocli.CommandLine;

@CommandLine.Command(
    description = "A small CLI to experiment with Java IOs.",
    version = "1.0.0",
    subcommands = {
      Read.class,
      Write.class,
    },
    scope = CommandLine.ScopeType.INHERIT,
    mixinStandardHelpOptions = true)
public class Root {
  public enum AvailableInputOutputImplementation {
    BINARY,
    BUFFERED_BINARY,
    TEXT,
    BUFFERED_TEXT
  }

  @CommandLine.Parameters(index = "0", description = "The name of the file.")
  protected String filename;

  @CommandLine.Option(
      names = {"-i", "--implementation"},
      description = "The implementation to use (possible values: ${COMPLETION-CANDIDATES}).",
      required = true)
  protected AvailableInputOutputImplementation implementation;

  public String getFilename() {
    return filename;
  }

  public AvailableInputOutputImplementation getImplementation() {
    return implementation;
  }
}
