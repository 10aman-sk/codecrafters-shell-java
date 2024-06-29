package Commands;

public class pwdCmd extends Commands{
    public pwdCmd(String input) {
        super(input);
    }

    @Override
    public boolean execute() {
        System.out.println(currentDirPath);
        return true;
    }
}
