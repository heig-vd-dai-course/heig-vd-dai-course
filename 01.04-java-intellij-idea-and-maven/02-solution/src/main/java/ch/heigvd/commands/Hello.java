package ch.heigvd.commands;

import ch.heigvd.Main;
import java.util.concurrent.Callable;
import picocli.CommandLine;

@CommandLine.Command(name = "hello", description = "Print a 'Hello World!' type of message.")
public class Hello implements Callable<Integer> {

  @CommandLine.ParentCommand protected Main parent;

  @CommandLine.Option(
      names = {"-g", "--greetings"},
      description = "The greetings to address the user.",
      defaultValue = "Hello")
  protected String greetings;

  @Override
  public Integer call() {
    System.out.println(greetings + " " + parent.getName() + "!");
    return 0;
  }
}
