package commands;

import java.io.IOException;

import tasks.Task;
import tasks.TaskList;
import ui.Ui;
import storage.Storage;

public class MarkCommand extends Command {
    private final int index;

    public MarkCommand(int index) {
        this.index = index;
    }
    public void execute(TaskList tasks, Ui ui, Storage storage) throws IOException {
        ui.echo("Nice! I've marked this task as done:");
        Task currTask = tasks.get(index-1);
        currTask.mark();
        ui.echo(currTask.toString());
        storage.saveAllToFile(tasks);
    }
}