public class CLIHandler {
    public static void handleRequest(String input) {
        if (input.equals("exit 0")) {
            System.exit(0);
        }
        String[] commandsParts = input.split(" ");
        if (commandsParts[0].equals("echo")) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < commandsParts.length; i++) {
                sb.append(commandsParts[i]).append(" ");
            }
            System.out.println(sb.substring(0, sb.length() - 1));
            return;
        }
        System.out.println(input + ": command not found");
    }
}
