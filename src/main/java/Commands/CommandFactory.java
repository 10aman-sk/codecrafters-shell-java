package Commands;

public class CommandFactory {
    public static Commands getCommand(String input) {
        String[] commandsParts = input.split(" ");
        if (commandsParts[0].equals("type")) {
            return new TypeCmd(input);
        }
        return new NonBuiltInCommands(input);
    }
}
