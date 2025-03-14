# PooPoo User Guide

![image](./Product.png)

PooPoo is a simple chatbot that helps you manage your tasks efficiently. You can add tasks, list them, mark them as done, delete tasks, and save your progress.

## Adding deadlines

Add a task with a deadline to the task list.

Format: deadline DESCRIPTION /by DEADLINE

Example: `deadline finish ip /by 14 March 2025`

A short message will tell the user that the deadline is added to the tasklist.

```
Okiee I've added the deadline!! Make sure you do it by then!
```

## Adding events

Add a task with a specific start event date and end date to the task list.

Format: event DESCRIPTION /from START_DATE /to END_DATE

Example: `event finish coding /from now /to when I retire`

A short message will tell the user that the event is added to the tasklist.

```
Okiee I've added the event!! All the best!
```

## Adding todos

Add a task without a deadline to the task list.

Format: todo DESCRIPTION

Example: `todo assignments`

A short message will tell the user that the task has been added to the tasklist.

```
Okiee I've added the todo!!
```

## Listing tasks

List all tasks in the task list.

Format: list

Example: `list`

A list of tasks will be shown.

```
1. [D][ ] finish ip (by: 14 March 2025)
2. [E][ ] finish coding (from: now to: when I retire)
3. [T][ ] assignments
```

## Deleting tasks

Delete a task from the task list. Task number can be found by using the list command.

Format: delete TASK_NUMBER

Example: `delete 1`

A short message will be shown to show that the task has been deleted from the tasklist.

```
Okiee I've removed this task: 
[D][ ] finish ip (by: 14 March 2025)
You have 2 remaining tasks left! All the best!
```

## Marking tasks

Mark a task as done/undone in the task list. Task number can be found by using the list command.

Format: mark TASK_NUMBER

Example: `mark 1`

A short message will be shown to show that the task has been marked as done/undone in the tasklist.

```
Thank you! I have marked it as done! Good job!
```

## Finding tasks

Find tasks that contain a specific keyword. Tasks that contain the keyword would be shown.

Format: find KEYWORD

Example: `find coding`

A list of tasks that contain the keyword would be shown.

```
These are the matching tasks in the list!: 

1. [E][X] finish coding (from: now to: when I retire)
```

## Exiting the program

Exit the program.

Format: bye

Example: `bye`

A short message will be shown, then the program will exit. 

```
Bye! Hope to see you again!
```

## Saving the data

Task list data is saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

## Editing the data file

Task list data is saved as a text file data/tasks.txt. Advanced users are welcome to update data directly by editing that data file.