# subclasses & inheritance (snippets)

## Abstract
An `abstract` class is a class that is declared abstract—it may or may not include abstract methods. Abstract classes cannot be instantiated,but they can be subclassed.

* [Intro to Subclasses & Inheritance](https://docs.oracle.com/javase/tutorial/java/IandI/subclasses.html)
* [Overriding Methods](https://docs.oracle.com/javase/tutorial/java/IandI/override.html)
* [Polymorphism](https://docs.oracle.com/javase/tutorial/java/IandI/polymorphism.html)
* [The "super" Keyword: Accessing Superclass Methods & Constructors](https://docs.oracle.com/javase/tutorial/java/IandI/super.html)
* [Abstract Methods & Classes](https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html)
* [Final Classes & Methods](https://docs.oracle.com/javase/tutorial/java/IandI/final.html)

---

A class declaration for a `MountainBike` class that is a subclass of `Bicycle` might look like this:

```
public class MountainBike extends Bicycle {

    // the MountainBike subclass adds one field
    public int seatHeight;

    // the MountainBike subclass has one constructor
    public MountainBike(int startHeight,
                        int startCadence,
                        int startSpeed,
                        int startGear) {
        super(startCadence, startSpeed, startGear);
        seatHeight = startHeight;
    }

    // the MountainBike subclass adds one method
    public void setHeight(int newValue) {
        seatHeight = newValue;
    }
}

```

## An Abstract Class Example


![Classes Rectangle, Line, Bezier, and Circle Inherit from GraphicObject ](https://docs.oracle.com/javase/tutorial/figures/java/classes-graphicObject.gif)

* First, you declare an abstract class, `GraphicObject`, to provide member variables and methods that are wholly shared by all subclasses, such as the current position and the `moveTo` method. 
* `GraphicObject` also declares abstract methods for methods, such as `draw` or `resize`, that need to be implemented by all subclasses but must be implemented in different ways. 

The `GraphicObject` class can look something like this:

```
abstract class GraphicObject {
    int x, y;
    ...
    void moveTo(int newX, int newY) {
        ...
    }
    abstract void draw();
    abstract void resize();
}

```

Each nonabstract subclass of `GraphicObject`, such as `Circle` and `Rectangle`, must provide implementations for the `draw` and `resize` methods:

```
class Circle extends GraphicObject {
    void draw() {
        ...
    }
    void resize() {
        ...
    }
}
class Rectangle extends GraphicObject {
    void draw() {
        ...
    }
    void resize() {
        ...
    }
}

```


## Writing Final Classes and Methods

You can declare some or all of a class's methods *final*. You use the `final` keyword in a method declaration to indicate that the method cannot be overridden by subclasses. The `Object` class does this---a number of its methods are `final`.

You might wish to make a method final if it has an implementation that should not be changed and it is critical to the consistent state of the object. For example, you might want to make the `getFirstPlayer` method in this `ChessAlgorithm` class final:

```
class ChessAlgorithm {
    enum ChessPlayer { WHITE, BLACK }
    ...
    final ChessPlayer getFirstPlayer() {
        return ChessPlayer.WHITE;
    }
    ...
}
```

## Dummy Java Code Related to Car Class Creation
```class Car extends Vehicle implements Movable {
  @Override
  void startEngine() {
    System.out.println("starting car's engine");
  }
  @Override
  void stopEngine() {
    System.out.println("stoping car's engine");
  }
  @Override
  public void move() {
    System.out.println("moving car");
  }
}
```

## Defining a Base Abstract Class
```
public abstract class BaseFileReader {
     
    protected Path filePath;
     
    protected BaseFileReader(Path filePath) {
        this.filePath = filePath;
    }
     
    public Path getFilePath() {
        return filePath;
    }
     
    public List<String> readFile() throws IOException {
        return Files.lines(filePath)
          .map(this::mapFileLine).collect(Collectors.toList());
    }
     
    protected abstract String mapFileLine(String line);
}```
source: 
[java abstract class](https://www.baeldung.com/java-abstract-class)