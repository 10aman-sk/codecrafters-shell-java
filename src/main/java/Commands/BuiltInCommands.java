package Commands;

public abstract class BuiltInCommands {
    String input;

    public BuiltInCommands(String input) {
        this.input = input;
    }

    public abstract void execute();

    protected String fetchRemainingCommand(String[] commandParts) {
        StringBuilder sb = new StringBuilder();
        for (String subString : commandParts) {
            sb.append(subString).append(" ");
        }
        return sb.substring(0).trim();
    }
}
