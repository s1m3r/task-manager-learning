package model;

public class Task {
    private String name;
    private int priority;
    private int id;

    public void setName(String name) {
        this.name = name;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Task(String name, int priority, int id) {
        this.name = name;
        this.priority = priority;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    public int getId() {
        return id;
    }
}
