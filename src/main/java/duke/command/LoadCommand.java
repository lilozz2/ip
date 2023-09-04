package duke.command;

import duke.Ui;
import duke.command.Command;
import duke.exceptions.InvalidFileTypeException;
import duke.Storage;
import duke.task.*;

public class LoadCommand extends Command {
    protected String response;
    public LoadCommand(String response) {
        super();
        this.response = response;
    }

    @Override
    public void execute(Storage storage, Ui ui, TaskList taskList) {
        try {
            taskList.setTasks(storage.load());
            System.out.println(taskList);
        } catch (InvalidFileTypeException e) {
            System.out.println(ui.format_response(e.getMessage()));
        }
    }
}
