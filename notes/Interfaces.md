# Interface

**interface**
```
public interface Vehicle {
     
    String getBrand();
    String speedUp();
    String slowDown();
     
    default String turnAlarmOn() {
        return "Turning the vehicle alarm on.";
    }
     
    default String turnAlarmOff() {
        return "Turning the vehicle alarm off.";
    }
}
```

**implementing class**
```
public class Car implements Vehicle {
 
    private String brand;
     
    // constructors/getters
     
    @Override
    public String getBrand() {
        return brand;
    }
     
    @Override
    public String speedUp() {
        return "The car is speeding up.";
    }
     
    @Override
    public String slowDown() {
        return "The car is slowing down.";
    }
}
```

**main class**
```
public static void main(String[] args) { 
    Vehicle car = new Car("BMW");
    System.out.println(car.getBrand());
    System.out.println(car.speedUp());
    System.out.println(car.slowDown());
    System.out.println(car.turnAlarmOn());
    System.out.println(car.turnAlarmOff());
}
```

!!! note default methods
    Like regular interface methods, default methods are implicitly **public** — there’s no need to specify the public modifier.

    Unlike regular interface methods, they are declared with the default keyword at the beginning of the method signature, and they provide an implementation.

    ```
    public interface MyInterface {
      // regular interface methods
      default void defaultMethod() {
          // default method implementation
      }
    }
    ```


source:
https://www.baeldung.com/java-static-default-methods


## Difference between Class and Interface

|Class|Interface|
|--|--|
|In class, you can instantiate variable and create an object.|In an interface, you can't instantiate variable and create an object.|
|Class can contain concrete(with implementation) methods|The interface cannot contain concrete(with implementation) methods|
|The access specifiers used with classes are private, protected and public.|In Interface only one specifier is used- Public.|

## When to use Interface and Abstract Class?

*   Use an **abstract** class when a template needs to be defined for a group of subclasses
*   Use an **interface** when a role needs to be defined for other classes, regardless of the inheritance tree of these classes

## Must know facts about Interface

*   A Java class can implement multiple Java Interfaces. It is necessary that the class must implement all the methods declared in the interfaces.
*   Class should override all the abstract methods declared in the interface
*   <mark>The interface allows sending a message to an object without concerning which classes it belongs.
*   Class needs to provide functionality for the methods declared in the interface.
*   All methods in an interface are implicitly public and abstract
*   An interface **cannot** be instantiated
*   An interface reference can point to objects of its implementing classes
*   An interface can ***extend*** from one or many interfaces. Class can extend only one class but implement any number of interfaces
*   An interface **cannot** implement another Interface. <mark>It has to extend another interface if needed.
*   An interface which is declared inside another interface is referred as nested interface
*   At the time of declaration, interface variable must be initialized. Otherwise, the compiler will throw an error.
*   The class cannot implement two interfaces in java that have methods with same name but different return type.

## **Summary**:

*   The class which implements the interface needs to provide functionality for the methods declared in the interface
*   All methods in an interface are implicitly public and abstract
*   An interface cannot be instantiated
*   An interface reference can point to objects of its implementing classes
*   An interface can extend from one or many interfaces. A class can extend only one class but implement any number of interfaces

---

### Source:
* [What is Interface in Java with Example](https://www.guru99.com/java-interface.html), guru99
* [Static and Default Methods in Interfaces in Java](https://www.baeldung.com/java-static-default-methods),baeldung


