# Timesheet App

For this checkpoint, you’ll be building a timesheet program to keep track of projects you’re working on. The user interacts with the timesheet by creating and managing timesheet entries. Each entry has the following attributes:

* Project Name
* Task
* Start Time
* Stop Time
* Id


Here are a few example timesheet entries:

    Id: 1
    Project Name: Coffee
    Task: Measure beans
    Start Time: 8:30
    Stop Time: 8:31


    Id: 2
    Project Name: Coffee
    Task: Boil water
    Start Time: 8:32
    Stop Time: 8:35


    Id: 3
    Project Name: Toast
    Task: Put bread in toaster
    Start Time: 8:33
    Stop Time: <null>


<mark>Timesheet entries with a Stop Time of null are still in progress.


> Please watch the demo video to see a fully-implemented Timesheet App in use:
https://drive.google.com/file/d/1081pdtb6-dvuwyHa8GN3wnZtWjv4832d/view


**Directions:**


* In Eclipse, create a Java project called TimesheetApp.


* In your TimesheetApp project, create the following classes:
   * `Timesheet.java`
   * `TimesheetEntry.java`
   * `Controller.java`
   * `ConsoleUtils.java`
   * `Main.java`


> For `Controller.java` and `ConsoleUtils.java`, copy the code provided at: https://github.com/danawen/dell-java/tree/assignments/TimesheetApp/src

   * `Controller.java` interprets the user input and makes the appropriate changes to the timesheet based on the actions entered by the user
   * `ConsoleUtils.java` manages everything related to console printing. You won’t have to initialize a Scanner for this project. Instead, make calls to the appropriate ConsoleUtils method to print to the console.


* Implement the `TimesheetEntry.java` class. This represents an entry in the timesheet. Your implementation should have the following:
   * Member variables:
      * private String projectName
      * private String task
      * private int id
      * private LocalDateTime startTime
      * private LocalDateTime endTime
      * Note: You will have to import *`java.time.LocalDateTime`* for the startTime and endTime variables
   * Static variable:
      * private static int NEXTID = 1
   * Constructor:
      * Two arguments: String myProject and String myTask
      * Your constructor should:
         * Initialize member variables projectName and task
         * Initialize startTime to LocalDateTime.now()
         * Initialize id to the current value of NEXTID
         * Increment NEXTID
   * Methods:
      * Getters for all five member variables (setters optional)
      * Implement a method called updateEndTime():
         * If endTime has not been set, set it to LocalDateTime.now()
         * Otherwise, do nothing (for now)


* Implement the `Timesheet.java` class. This is the “database” that stores the timesheet entries. Your implementation should have the following:
   * Member variable:
      * private List<TimesheetEntry> database
      * Note: You will have to import *`java.util.List`* and *`java.util.ArrayList`*
   * Constructor:
      * No arguments
      * Your constructor should:
         * Initialize database to a new ArrayList<>


* In `Main.java`, <mark>create a method</mark> public static void `main(String[] args)` that instantiates a Controller object and calls its `start()` method. Run your program to validate that the menu of actions is being printed to the console.


* In `Controller.java`, implement the help action. When the user enters help, the program should display the menu of actions.
   * In the `start()` method, find the section that manages the help command
   * Inside this section, call the appropriate ConsoleUtils method to display the menu of actions.


* Implement the add action:
   * Requirements:
      * When the user inputs add, the program should prompt them to enter a project name, then a task description. The program will use these to create a new timesheet entry and add it to the timesheet.
      * Important note: The project name entered by the user must be one word only
   * Directions:
      * In `Timesheet.java`, <mark>create a method</mark> **`add(String project, String task)`** that creates a new TimesheetEntry and adds it to the Timesheet database
      * In `Controller.java`, finish the implementation of the `processAddAction()` method:
         * Collect project name and task description from the user
         * Call the `add(project, task)` method you just created to add the entry to the Timesheet
      * Run your program to validate that the add action is working as you expect


* Implement the list action
   * Requirements:
      * When the user inputs list, the program prints all the entries in the timesheet
      * Don’t worry about the [PROJECT] and [-a] options for now. We will get to them later 
   * Directions:
      * In `Timesheet.java`, <mark>create a method</mark> **`list()`** that returns a List<TimesheetEntry> of the entries in the database
      * In `Controller.java`, finish the implementation of the `processListAction()` method:
         * Call the `list()` method you just created to get a list of all the entries in the Timesheet
         * Use the appropriate ConsoleUtils method to print out the list of entries
      * Run your program to validate that the list action is working as you expect


* In `Timesheet.java`, implement a `get(int id)` method with the following specifications:
   * Searches the database for a TimesheetEntry with the specified id
   * If a TimesheetEntry is found, return it
   * Otherwise, return null


* Implement the delete action
   * Requirements:
      * When the user inputs delete ID, the program should remove the TimesheetEntry with the specified id from the Timesheet
   * Directions:
      * In `Timesheet.java`, <mark>create a method</mark> **`delete(TimesheetEntry entry)`** that removes the specified TimesheetEntry from the database
      * In `Controller.java`, finish the implementation of the `processDeleteAction()` method:
         * Call the `get()` method you created in the previous step to retrieve the TimesheetEntry with the specified id
         * Call the `delete()` method you just created to delete that TimesheetEntry from the Timesheet
      * Run your program to validate that the delete action is working as you expect


* Implement the stop action
   * Requirements:
      * When the user inputs stop ID, the program retrieves the TimesheetEntry with the specified id and sets its endTime
   * Directions:
      * In `Timesheet.java`, <mark>create a method</mark> **`stop(TimesheetEntry entry)`** that updates the TimesheetEntry object’s endTime
         * Hint: We’ve already created a method that helps with this
      * In `Controller.java`, finish the implementation of the `processStopAction()` method:
         * Call the `get()` method to retrieve the TimesheetEntry with the specified id
         * Call the `stop()` method you just created to set the end time for that TimesheetEntry
      * Run your program to validate that the stop action is working as you expect


* In `Controller.java`, implement the quit action. When the user inputs quit, the program should end.
   * In the `start()` method, find the section that manages the quit command
   * Inside this section, add code that will cause the while loop to exit and the program to end


* Add the [-a] “active-only” option to the list action
   * Requirements:
      * When the user inputs list -a, the program should print all the entries in the timesheet that are still active (incomplete)
   * Directions:
      * In `Timesheet.java`, edit the `list()` method:
         * Add a boolean activeOnly argument to the method signature
         * If activeOnly is set to true, return a list of all the active (incomplete) TimesheetEntries in the Timesheet
         * Otherwise, return a list of all the entries in the timesheet
      * In `Controller.java`, edit the `processListAction()` method:
         * Check the actionParts to see if the user entered the -a option
         * If so, call `list()` with appropriate value of activeOnly
         * If not, default to your existing code that prints all entries
   * Run your program to validate that the list -a action is working as you expect


* Add the [PROJECT] option to the list action
   * Requirements:
      * When the user inputs list PROJECT, the program should print all entries in the timesheet that have the specified project name
      * When the user inputs list PROJECT -a or list -a PROJECT, the program should print all active timesheet entries with the specified project name
   * Directions:
      * In `Timesheet.java`, edit the `list()` method:
         * Add a String name argument to the method signature
         * If the name argument is not null, return a list of TimesheetEntries whose projectName field matches name
         * Otherwise, return a list of all the entries in the timesheet
         * Integrate this functionality with the -a option, so that list PROJECT -a returns all active entries with the specified project name
      * In `Controller.java`, edit the `processListAction()` method:
         * Check if the user entered the PROJECT option
         * If so, retrieve the project name from the user input and pass it to the `list()` method
         * If the user entered both the PROJECT option and the -a option, ensure that the `list()` method is called with the appropriate arguments


> * Throw an exception when the user tries to stop an entry that’s already been completed
>    * In `TimesheetEntry.java`, modify the method **`updateEndTime()`** to throw an exception if the value of endTime has already been set
>    * Modify the code that calls `updateEndTime()` to catch the exception and return a friendly message to the user


> * Handle invalid input
>    * See examples of invalid input toward the end of the demo video
>    * Modify your code to handle each of the invalid input situations


> * Add messaging when an action is completed
>    * Print out a friendly message to the user when an action is completed. For example, after the user runs the add action and successfully adds an entry, print out a message like “Entry added”
>    * See the demo video for ideas


Extend the Timesheet App with your own features! Please document your features with comments in your code.