package seedu.penus.logic.commands;

import seedu.penus.common.exceptions.DuplicateModuleException;
import seedu.penus.model.ModelManager;
import seedu.penus.model.Module;

/**
 * Adds a Taken module to the list
 */
public class TakenCommand extends Command {
    public static final String COMMAND_WORD = "taken";
    public static final String MESSAGE = 
            "Module has been added:\n" 
            + "\t  %s\n"
            + "\tYou have %s module(s) in your planner";
    public final Module taken;

    /**
     * Creates a TakenCommand to add the specified {@code Module} 
     * by constructing a new Module object with the given parameters
     */
    public TakenCommand(String moduleCode, int year, int semester, String grade) {
        this.taken = new Module(moduleCode, year, semester, grade);
    }

    @Override
    public CommandResult execute(ModelManager model) throws DuplicateModuleException {
        if (model.hasModule(taken)) {
            throw new DuplicateModuleException();
        }

        model.addModule(taken);

        return new CommandResult(String.format(MESSAGE, taken, model.getSize()), false);
    }
}
