package Commands;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Collectors;

public class NonBuiltInCommands extends Commands {
    public NonBuiltInCommands(String input) {
        super(input);
    }

    @Override
    public boolean execute() {
        String command = Arrays.stream(input.split(" ")).findFirst().get().trim();
        String[] paths = System.getenv("PATH").split(":");
        for (String path : paths) {
            Path executablePath = Path.of(path + "/" + command);
            if (Files.exists(executablePath)) {
                ProcessBuilder processBuilder = new ProcessBuilder(path + "/" + command,
                        Arrays.stream(input.split(" ")).skip(1).collect(Collectors.joining()));
                try {
                    Process process = processBuilder.start();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                    String line = null;
                    while((line = reader.readLine()) != null) {
                        System.out.println(line);
                    }
                } catch (IOException e) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Example input command to test
        String commandToTest = "ls"; // Adjust this based on the command you want to test

        NonBuiltInCommands executor = new NonBuiltInCommands(commandToTest);
        boolean result = executor.execute();

        System.out.println("Command execution result: " + result);
    }
}
