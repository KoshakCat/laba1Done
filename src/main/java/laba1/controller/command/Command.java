package laba1.controller.command;

@FunctionalInterface
public interface Command {
    String execute (String... arg);
}
