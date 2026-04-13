import exception.TaskNotFoundException;
import model.*;
import service.*;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws Exception {
        TaskService service = new TaskService();
        // Create tasks
        service.create("Study Java", 3);
        service.create("Go to gym", 2);

        // Async create
        Future<Task> future = service.createAsync("Read book", 4);
        Task asyncTask = future.get();

        // Read all
        service.readAll().forEach(t -> System.out.println(t.getId() + ": " + t.getName()) );

        // Update task
        service.update(asyncTask.getId(), "Read Java book", 5);

        // Get by id
        Task task = service.getById(asyncTask.getId());
        System.out.println("Updated: " + task.getName());

        // Delete
        service.deleteById(task.getId());
        service.shutdown();
    }
}