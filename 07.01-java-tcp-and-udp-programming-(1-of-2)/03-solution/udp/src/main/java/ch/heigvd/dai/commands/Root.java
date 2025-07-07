package ch.heigvd.dai.commands;

import picocli.CommandLine;

@CommandLine.Command(
    description = "A small application to experiment with UDP.",
    version = "1.0.0",
    subcommands = {Emitter.class, Operator.class, Receiver.class, ListNetworkInterfaces.class},
    scope = CommandLine.ScopeType.INHERIT,
    mixinStandardHelpOptions = true)
public class Root {}
