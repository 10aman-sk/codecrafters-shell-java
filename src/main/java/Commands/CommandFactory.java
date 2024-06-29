package Commands;

public class CommandFactory {
    public static Commands getCommand(String input) {
        String[] commandsParts = input.split(" ");
        if (commandsParts[0].equals("type")) {
            return new TypeCmd(input);
        }
        switch (commandsParts[0]) {
            case "type":
                return new TypeCmd(input);
            case "pwd":
                return new pwdCmd(input);
            case "cd":
                return new cmdCommand(input);
        }
        return new NonBuiltInCommands(input);
    }
}
