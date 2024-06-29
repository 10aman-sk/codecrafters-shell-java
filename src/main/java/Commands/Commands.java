package Commands;

public abstract class Commands {
    String input;
    static String currentDirPath;

    public Commands(String input) {
        this.input = input;
        if (currentDirPath == null) {
            currentDirPath = System.getProperty("user.dir");
        }
    }

    public abstract boolean execute();

    protected String fetchRemainingCommand(String[] commandParts) {
        StringBuilder sb = new StringBuilder();
        for (String subString : commandParts) {
            sb.append(subString).append(" ");
        }
        return sb.substring(0).trim();
    }
}
