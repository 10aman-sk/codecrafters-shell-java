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
        if (commandsParts[0].equals("type")) {
            String command = fetchRemainingCommand(Arrays.stream(commandsParts).skip(1).toArray(String[]::new));
            if(validStrings.contains(command.trim())){
                System.out.println(command.trim() + " is a shell builtin");
            } else {
                System.out.println(command.trim() + ": not found");
            }
            return;
        }
        System.out.println(input + ": command not found");
    }

    private static String fetchRemainingCommand(String[] commandParts) {
        StringBuilder sb = new StringBuilder();
        for (String subString : commandParts) {
            sb.append(subString).append(" ");
        }
        return sb.substring(0).trim();
    }
}
