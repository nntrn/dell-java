## Rentable Assignment

For this assignment we will define an interface for items that can be rented. And then define a pair of classes that implement that interface.

### [](https://java.austincodingacademy.com/_book/lesson12/rentable.html#requirements)Requirements

Create a new Java project called "Rentable". Inside the project, create five classes:

1.  Define an interface called `Rentable` the requires the following methods

    *   `getDescription();` returns the description of the item (return type `String`)
    *   `getDailyRate();` returns the daily rate for renting the item (return type `double` or `Double`)
    *   `getPrice(double days);` returns the amount due for renting the item for the a given number of days (return type `double` or `Double`)
2.  Define a `Room` class that implements the interface and has a `dailyRate` variable of type `double` or `Double`.

3.  Define a `Condo` class the implements the interface and has a `weeklyRate` variable of type `double` or `Double`.

4.  Define a `Tool` class the implements the interface and has an `hourlyRate` variable of type `double` or `Double`.

5.  Create a `RentableProgram` class that will contain your main method and act as a "driver" for your program. Your `main` method should:

    *   Instantiate a few instances of each of the classes (`Room`, `Condo`, `Tool`), and add them to an array of `Rentable` objects.
    *   Loop through the array, and print out the description and the daily rate for each item.
    *   Ask the user for a number of days to generate the final price for each of the items in the array.

### [](https://java.austincodingacademy.com/_book/lesson12/rentable.html#guidelines)Guidelines

*   Include comments in your code. At the minimum, include a comment for each method to explain what it does. If you submit code without any comments, 5 points will be subtracted from your assignment score.