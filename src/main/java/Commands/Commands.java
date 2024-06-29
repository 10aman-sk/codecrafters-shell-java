package Commands;

public abstract class Commands {
    String input;

    public Commands(String input) {
        this.input = input;
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
