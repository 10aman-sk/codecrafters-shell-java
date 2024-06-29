import Commands.BuiltInCommands;
import Commands.CommandFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Set;

public class CLIHandler {
    static Set<String> validStrings =  Set.of("type", "echo", "exit");
    public static void handleRequest(String input) {
        if (input.equals("exit 0")) {
            System.exit(0);
        }
        String[] commandsParts = input.split(" ");
        if (commandsParts[0].equals("echo")) {
            System.out.println(fetchRemainingCommand(Arrays.stream(commandsParts).skip(1).toArray(String[]::new)));
            return;
        }
        BuiltInCommands command = CommandFactory.getCommand(input);
        if(command == null) {
            System.out.println(input + ": command not found");
            return;
        }
        command.execute();
    }

    private static String fetchRemainingCommand(String[] commandParts) {
        StringBuilder sb = new StringBuilder();
        for (String subString : commandParts) {
            sb.append(subString).append(" ");
        }
        return sb.substring(0).trim();
    }
}
