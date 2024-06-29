package Commands;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Set;

public class TypeCmd extends BuiltInCommands {
    static Set<String> validStrings = Set.of("type", "echo", "exit");

    public TypeCmd(String input) {
        super(input);
    }

    @Override
    public void execute() {
        String[] commandsParts = input.split(" ");
        String command = fetchRemainingCommand(Arrays.stream(commandsParts).skip(1).toArray(String[]::new)).trim();
        if(validStrings.contains(command.trim())){
            System.out.println(command.trim() + " is a shell builtin");
            return;
        }
        String[] paths = System.getenv("PATH").split(":");
        for (String path : paths) {
            Path filePath = Path.of(path + "/" + command);
            if (Files.exists(filePath)) {
                System.out.println(command + " is " + path + "/" + command);
                return;
            }
        }
        System.out.println(command + ": not found");
    }
}
