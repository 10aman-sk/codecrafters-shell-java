package Commands;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class CommandFactory {
    public static BuiltInCommands getCommand(String input) {
        String[] commandsParts = input.split(" ");
        if (commandsParts[0].equals("type")) {
            return new TypeCmd(input);
        }
        return null;
    }
}
