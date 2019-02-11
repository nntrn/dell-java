# object oriented programming


defining a class:

    class ClassName {
      // variables
      // methods
    }

example:

    class Lamp {
      // instance variable
      private boolean isOn;

      // method
      public void turnOn() {
        isOn = true;
      }

      // method
      public void turnOff() {
        isOn = false;
      }
    }

> here, we defined a class named `Lamp`.
> * the class has one instance variable (variable defined inside class) `isOn` 
> * and two methods `turnOn()` and `turnOff()`

The **`private`** keyword makes instance variables and methods private which can be accessed only from inside the same class.

The **`public`** keyword makes instance variables and methods public which can be accessed from outside of the class.

<mark>
When class is defined, only the specification for the object is defined; no memory or storage is allocated.
</mark>
 

To access members defined within the class, you need to create **objects**. 


##### example: create objects of `Lamp` class

    class Lamp {
      boolean isOn;

      void turnOn() {
        isOn = true;
      }

      void turnOff() {
      isOn = false;
      }
    }

    class ClassObjectsExample {
    public static void main(String[] args) {
      Lamp l1 = new Lamp(); // create l1 object of Lamp class
      Lamp l2 = new Lamp(); // create l2 object of Lamp class
      }
    }


##### terminology
```java
class Lamp {
  boolean isOn;

  void turnOn() {
    isOn = true;
  }

  void turnOff() {
    isOn = false;
  }
  
  void displayLightStatus() {
    System.out.println("Light on? " + isOn);
  }
}


class ClassObjectsExample {
public static void main(String[] args) {
  
  Lamp l1 = new Lamp(), l2 = new Lamp();
  
  l1.turnOn();
  l2.turnOff();
  
  l1.displayLightStatus();
  l2.displayLightStatus();
  }
}
```

<details>

* `Lamp` class is created.
* The class has an instance variable *isOn* and three methods `turnOn()`, `turnOff()` and `displayLightStatus()`.
* Two objects *l1* and *l2* of *Lamp* class are created in the `main()` function.
* Here, `turnOn()` method is called using *l1* object: `l1.turnOn();`
* This method sets *isOn* instance variable of *l1* object to `true`.
* And, `turnOff()` method is called using *l2* object: `l2.turnOff();`
* This method sets *isOff* instance variable of *l2* object to `false`.
* Finally, `l1.displayLightStatus();` statement displays `Light on? true` because *isOn*variable holds `true` for *l1* object.
* And, `l2.displayLightStatus();` statement displays `Light on?  false` because *isOn*variable holds `false` for *l2* object

</details>

## Creating an Object

There are three steps when creating an object from a class −

**Declaration** − A variable declaration with a variable name with an object type.

**Instantiation** − The 'new' keyword is used to create the object.

**Initialization** − The 'new' keyword is followed by a call to a constructor. This call initializes the new object.

## References:
* [Java Class and Objects](https://www.programiz.com/java-programming/class-objects)