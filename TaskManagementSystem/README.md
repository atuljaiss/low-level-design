# Task Management System

## Problem Statement

Design a robust Task Management System that allows users to manage their tasks efficiently, with features such as creation, assignment, filtering, and task history, while ensuring thread safety and extensibility.

## Requirements

Allow users to create, update, and delete tasks.

Each task includes: title, description, due date, priority, and status (pending, in progress, completed).

Tasks can be assigned to users.

Set reminders for tasks.

Support searching and filtering tasks (e.g., by priority, due date, assigned user).

Users can mark tasks as completed and view task history.

Handle concurrent access with data consistency.

Extensible architecture for future enhancements.

## System Requirements

Java 8+

## UML Diagram
![Uml diagram Link](https://drive.google.com/file/d/1BINcYcnOuZ126V3RQST4zN2xjFCEnhxp/view?usp=sharing)

## Class Design
The User class represents a user in the task management system, with properties such as id, name, and email.

The TaskStatus enum defines the possible states of a task, such as pending, in progress, and completed.

The Task class represents a task in the system, with properties like id, title, description, due date, priority, status, and assigned user.

The TaskManager class is the core of the task management system and follows the Singleton pattern to ensure a single instance of the task manager.

The TaskManager class uses concurrent data structures (ConcurrentHashMap and CopyOnWriteArrayList) to handle concurrent access to tasks and ensure thread safety.

The TaskManager class provides methods for creating, updating, deleting, searching, and filtering tasks, as well as marking tasks as completed and retrieving task history for a user.

The TaskManagementSystem class serves as the entry point of the application and demonstrates the usage of the task management system.