package Commands;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class cmdCommand extends Commands {
    public cmdCommand(String input) {
        super(input);
    }

    @Override
    public boolean execute() {
        String[] commandsParts = input.split(" ");
        String path = fetchRemainingCommand(Arrays.stream(commandsParts).skip(1).toArray(String[]::new)).trim();
        Path newPath = null;
        if (path.startsWith("/")) {
            newPath = Path.of(path);
        } else {
            newPath = Path.of(currentDirPath + "/" + path).toAbsolutePath();
            File newFile = new File(newPath.toString());
            try {
                newPath = Path.of(newFile.getCanonicalPath());
            } catch (IOException e) {
            }
        }
        if (!Files.exists(newPath)) {
            System.out.println("cd: " + path + ": No such file or directory");
        } else {
            currentDirPath = newPath.toString();
        }
        return true;
    }
}
