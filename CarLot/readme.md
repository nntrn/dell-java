# Car Lot Assignment

For this assignment we will build a car lot tracking application that tracks car inventories for a User Car Lot.

**Requirements**

Create a new Java project called "CarLot". Inside the project, create five classes:

1.  Create a `CarLot` class to represent a car lot.

    * `CarLot` should have the following fields:
        * name
        * a list of vehicles
    * `CarLot` should have *methods* to do the following actions:
        * add a vehicle to the lot
        * print the inventory of the car lot, including number of vehicles and details about each vehicle
2.  Create an ***abstract*** `Vehicle` class.

    * `Vehicle` should have the following fields:
        * license number
        * make
        * model
        * price
    * `Vehicle` should have methods to do the following actions:
        * print a description of the vehicle, including license number, make, model, and price
3.  Create a `Truck` **subclass** and a `Car` subclass. Both subclasses must extend the `Vehicle` class.

4.  The `Car` **subclass** should have the following fields:

    * type (coupe, hatchback, or sedan)
    * number of doors
5.  The `Truck` **subclass* should have the following fields:

    * bed size
6.  Create a `CarLotProgram` class that will contain your main method and act as a "driver" for your program.

7.  For this assignment you do not have to build an interactive program.

> In your main method:
> * You should instantiate 2 different car lots, and add various vehicles to the car lots.
> * Print out the inventory for each of the car lots, showing the details for each vehicle.
> * When printing out the details, print the appropriate info for a car, or a truck accordingly.

**Guidelines**

* Include comments in your code. At the minimum, include a comment for each method to explain what it does. If you submit code without any comments, 5 points will be subtracted from your assignment score.