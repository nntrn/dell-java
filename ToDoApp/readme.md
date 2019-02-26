# Final Project: To-Do Application

> For this project we will be building a console-based to-do list app, to put together all of the concepts and ideas we have studied throughout the course.

## Requirements

1.  The user should be able to list the current to-do items.
    *   There should be an option to list only items that have been completed.
    *   There should be an option to list only items that have not been completed.
    *   There should be an option to list all items, both completed and not completed.
2.  The user should be able to add an item to their list of to-do's.
3.  The user should be able to delete an item from their list of to-do's.
4.  The user should be able to mark an item in their to-do list as complete.
5.  The list of to-do items should be updated in a database as they are added, completed, and deleted.
    *   **Version 1**: For the first version of your to-do app, use an `ArrayList` or similar structure to store the to-do items, instead of an actual database. (This is the same format we used for the TimesheetApp checkpoint project.)
    *   **Version 2**: (optional) After you get your to-do app fully working with the `ArrayList` "database", modify your code to swap out the `ArrayList` for a SQLite database. To-do items should be stored in a table in the database. When the user adds, completes, or deletes an item, the database should be updated accordingly.

> [Demo video](https://drive.google.com/file/d/1YuuWHYCfCyqEFvxA_UeTY1rI2U-FZNKW/view) - Shows all the features of a completed version of the app. You can use this video as a guideline or implement your user interface differently, as long as all the requirements are met.

## Guidelines

1.  Create a class that defines a ToDoItem. The `ToDoItem.java` class should have the following member variables:

    *   id
    *   description
    *   completed flag
2.  Create a class that drives all the updates to the database. This class is usually called a DAO (Data Access Object). The `Dao.java` class should have the following member variable:

    *   For database Version 1, use an `ArrayList` to store the user's to-do items.
    *   For database Version 2, store a `Connection` to the SQLite database file.

In addition, `Dao.java` should have the following methods:

```
- update method (mark a to-do item as complete)
- add method
- delete method
- list method

```

1.  Create a `Controller.java` class that handles user input and acts as the "glue" between the DAO class and the user.

2.  Include comments in your code. At the minimum, include a comment for each method to explain what it does. If you submit code without any comments, 5 points will be subtracted from your assignment score.

## Bonus Features (optional)

*   Add a due date field to your `ToDoItem`. When the user creates a new to-do item, prompt them to enter a due date (specify the date-time format you'd like them to use). Add the following options:
    *   List to-do items by due date: Prompt the user for a due date, and the program should display all items due by that date.
    *   List overdue items: Display all items that are past the due date.
    *   Sort by due date: Display the items in order of due date (soonest first).