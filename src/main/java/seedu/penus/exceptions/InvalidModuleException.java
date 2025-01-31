package seedu.penus.exceptions;

public class InvalidModuleException extends PenusException {
    public InvalidModuleException(String module) {
        super("The module code of " + module + " must be given.");
    }
}
