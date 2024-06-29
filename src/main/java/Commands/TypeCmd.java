package Commands;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Set;

public class TypeCmd extends Commands {
    static Set<String> validStrings = Set.of("type", "echo", "exit", "pwd", "cd");

    public TypeCmd(String input) {
        super(input);
    }

    @Override
    public boolean execute() {
        String[] commandsParts = input.split(" ");
        String command = fetchRemainingCommand(Arrays.stream(commandsParts).skip(1).toArray(String[]::new)).trim();
        if(validStrings.contains(command.trim())){
            System.out.println(command.trim() + " is a shell builtin");
            return true;
        }
        String[] paths = System.getenv("PATH").split(":");
        for (String path : paths) {
            Path filePath = Path.of(path + "/" + command);
            if (Files.exists(filePath)) {
                System.out.println(command + " is " + path + "/" + command);
                return true;
            }
        }
        System.out.println(command + ": not found");
        return true;
    }
}
