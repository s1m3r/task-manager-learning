# Task Manager (Java)
# Description

    Simple task management service implemented in Java.
    The project demonstrates core backend concepts such as CRUD operations,
    multithreading, asynchronous processing, and data structure optimization.


# Features

    Create, read, update, delete tasks (CRUD)
    Fast lookup using Map (O(1))
    Thread-safe implementation using ConcurrentHashMap
    Atomic ID generation with AtomicInteger
    Asynchronous task creation using ExecutorService
    Exception handling for missing tasks
    Stream API usage for data processing

# Technologies
        Java
        Collections (Map, List)
        Multithreading (ExecutorService)
        Concurrency (ConcurrentHashMap, AtomicInteger)
        Stream API
        Git (feature branches, pull requests)
# Project Structure
    model — Task entity
    service — business logic
    exception — custom exceptions

# What I Learned 
    Designing service layer architecture
    
    Working with concurrent data structures
    
    Implementing asynchronous operations
    
    Writing clean and maintainable code
    
    Using Git workflow (feature branches, PR)

# Future Improvements
    Add REST API (Spring Boot)
    Add database (PostgreSQL)
    Add unit tests
    Implement task scheduler
