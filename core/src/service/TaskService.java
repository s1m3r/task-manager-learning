package service;

import exception.TaskNotFoundException;
import model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskService{
    private int nextId = 1;
    private List<Task> tasks = new ArrayList<>();

    public void create(String name, int priority){
        Task task = new Task(name,priority, nextId);
        nextId++;
        tasks.add(task);
    }

    public List<Task> readAll(){
        return new ArrayList<>(tasks);
    }

    public void deleteById(int id){
        for (int i = 0; i < tasks.size(); i++) {
                Task task = tasks.get(id);
                if(task.getId() == id){
                    tasks.remove(id);
                    break;
                }
        }
    }
    public Task getById(int id) throws TaskNotFoundException {
        for (int i = 0; i < tasks.size(); i++) {

            Task task = tasks.get(i);

            if(task.getId() == id){
                return task;
            }
        }
        throw new TaskNotFoundException();
    }
    public void update(int id, String name, int priority) throws TaskNotFoundException {
        Task task = getById(id);
        task.setName(name);
        task.setPriority(priority);
    }
}
