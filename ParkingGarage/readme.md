# Parking Garage Assignment

For this assignment we will be creating a `ParkingGarage` Class and `Car` class. Your program will track cars parked in the parking garage.

**Requirements**

Your program should implement a `Car` class, a `ParkingGarage` class, and a `GarageManager` class.

### The Car Class

1.  Your implementation of the `Car` class should have the following attributes:
    * Color
    * License #
    * Make
    * Model

### The ParkingGarage Class

1.  Your implementation of the `ParkingGarage` class should have a car array(`Car[]`) to represent the parking spots. The "spot number" of each parking spot is its array index (starting with spot 0).

2.  Your `ParkingGarage` constructor should take in capacity as input. This will represent the capacity of the parking garage instance.

3.  Your ParkingGarage class should implement:

    * `park(Car car, int spot)` method, that will add the car to a parking spot.
        * If the user attempts to add the car to a spot that doesn't exist (outside the array), catch the exception and notify the user.
        * If there's already a car parked in the spot, notify the user that the car cannot be parked in that spot.


    * `vacate(int spot)` method, that will remove the car from the specified spot.
        * If the user attempts to remove a car from an empty spot, notify the user that no car is present in that spot.

    * `printInventory()` method, that prints out to the console the the listing of all the cars with a brief description. For each car, please include:
        * The spot number (array index) of the car in the parking garage
        * The car's color, license #, make, and model

### The GarageManager Class and the Main method

1.  The GarageManager class will contain the `main(String[] args)` method for your program. It doesn't need to contain anything else.

2.  Your `main()` method will act as the "driver" for this program.

3.  In your `main()` method, you should:

    * Instantiate a few ParkingGarage instances with different capacities.
    * Instantiate a few cars, and proceed to park them and unpark them from the garages.

---

### Guidelines

1.  Your implementation should be broken down into different methods.

2.  Each method should have a well defined "job".

3.  Include comments in your code. At the minimum, include a comment for each method to explain what it does. If you submit code without any comments, 5 points will be subtracted from your assignment score.