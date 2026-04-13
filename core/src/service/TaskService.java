package service;

import exception.TaskNotFoundException;
import model.Task;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class TaskService{
    private Map<Integer,Task> tasks = new ConcurrentHashMap<>();
    private AtomicInteger nextId = new AtomicInteger(1);
    private final ExecutorService executor = Executors.newFixedThreadPool(2);


    public Task create(String name, int priority){
        int id = nextId.getAndIncrement();
        Task task = new Task(name, priority, id);
        tasks.put(id, task);
        return task;
    }
    public Future<Task> createAsync(String name, int priority) {
        return executor.submit(() -> create(name, priority));
    }
    public void shutdown() throws InterruptedException {
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.SECONDS);
    }

    public List<Task> readAll(){
        return new ArrayList<>(tasks.values());
    }

    public void deleteById(int id) throws TaskNotFoundException {
       Task removed = tasks.remove(id);
       if(removed == null){
           throw new TaskNotFoundException(id);
       }
    }
    public Task getById(int id) throws  TaskNotFoundException{
        Task task = tasks.get(id);
        if(task == null){
            throw new TaskNotFoundException(id);
        }
        return task;
    }



    public void update(int id, String name, int priority) throws TaskNotFoundException {
        Task task = getById(id);
        task.setName(name);
        task.setPriority(priority);
    }
}
