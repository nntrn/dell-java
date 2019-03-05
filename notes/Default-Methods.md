# 11 Default methods
[source](https://java8tips.readthedocs.io/en/stable/default.html#default-methods "Permalink to this headline")

* [11.2. Multiple inheritance](#112-multiple-inheritance)
  * [1. A method declared in same class or a superclass wins the priority over any default method declared in the interface.](#1-a-method-declared-in-same-class-or-a-superclass-wins-the-priority-over-any-default-method-declared-in-the-interface)
  * [2. The method with the same signature in the most specific default-providing interface will take the priority.](#2-the-method-with-the-same-signature-in-the-most-specific-default-providing-interface-will-take-the-priority)
  * [3. In case choices are still ambiguous, the class inheriting from multiple interfaces has to override the default method and then it can provide its own implementation or can explicitely call any inherited one.](#3-in-case-choices-are-still-ambiguous-the-class-inheriting-from-multiple-interfaces-has-to-override-the-default-method-and-then-it-can-provide-its-own-implementation-or-can-explicitely-call-any-inherited-one)

Default methods enable you to add new functionality to the interfaces of your libraries and ensure binary compatibility with code written for older versions of those interfaces. They provide a default implementation for methods. 

As a result, existing classes implementing an interface will automatically inherit the default implementations. 
    

!!! note 
    
    You specify that a method definition in an interface is a default method with the default keyword at the beginning of the method signature. <mark>All method declarations in an interface including default methods, are implicitly public so you can omit the public modifier.

    To get more clear picture let's discuss the `stream` method added in *Collection* interface.

    > ```
    > default Stream stream(){
    >   return StreamSupport.stream(spliterator(),false);
    > }
    > ```

* The stream method is required in all **List** and **Set** implementations so added in their super interface i.e. `Collection`. 

* Doing this, stream method will now be directly available to all their implementing classes ArrayList, TreeSet. 

```
interface Vehicle {

   default void applyBreak() {
      System.out.println("Applying break.");
   }

   void transport();
}

class GoodsVehicle implements Vehicle {

   @Override
   public void transport() {
      System.out.println("Transporting goods.");
      applyBreak();
   }
}

class PublicTransport implements Vehicle {

   @Override
   public void transport() {
      System.out.println("Transporting people.");
      applyBreak();
   }

}

```

## 11.2. Multiple inheritance

!!! danger a class can inherit two methods of the same signature from two different classes

* This is the reason that java always avoided multiple inheritance and adopted multilevel inheritance from very begining. 

* But introducing default methods it again opened the gate for the same issue. <mark>A class is able to implement multiple interfaces even if they contain abstract method with the same name.

```
public class SampleClass implements A, B {

   @Override
   public void print() {
      System.out.println("SampleClass");
   }

   public static void main(String[] args) {
      A a = new SampleClass();
      a.print();

      B b = new SampleClass();
      b.print();
   }
}

interface A {
   void print();
}

interface B {
   void print();
}

```

This was possible because the method is called on a single interface reference and both the interfaces are **not** interfering each other, they are just individual contracts. 

But now though interfaces can contain concrete methods, **there is the possibility of a class inheriting more than one method with the same signature.** Java 8 acknowledges this conflict with three basic principles.

### 1.  A method declared in same class or a superclass wins the priority over any default method declared in the interface.

1.  A method declared in same class or a superclass wins the priority over any default method declared in the interface.

> ```
> interface A {
>     default String print() {
>         return "A";
>     }
> }
>
> class MyClass {
>     public String print() {
>         return "MyClass";
>     }
> }
>
> public class DefaultTest extends MyClass implements A {
>
>     public static void main(String[] args) {
>         System.out.println(new DefaultTest().print());
>     }
> }
>```
> > **Output:** MyClass
>
> !!!  note ""
>     Here *print* method is inherited by both **MyClass** and **interface A**, _but MyClass print method has taken into consideration_


### 2.  The method with the same signature in the most specific default-providing interface will take the priority.

> ```
> interface A {
>     default String print() {
>         return "A";
>     }
> }
>
> interface B extends A {
>     default String print() {
>         return "B";
>     }
> }
>
> public class DefaultTest implements A, B {
>
>     public static void main(String[] args) {
>         System.out.println(new DefaultTest().print());
>     }
> }
>
> Output: B
>
> ```
>
> Here *print* method is **inherited** by *both* interfaces but _**interface A extending B so B** will be consider most specific or closer and will be considered._


### 3.  In case choices are still ambiguous, the class inheriting from multiple interfaces has to override the default method and then it can provide its own implementation or can explicitely call any inherited one. 

To call the super interface method `super` keyward is used.

> ```
> interface A {
>     default String print() {
>         return "A";
>     }
> }
>
> interface B {
>     default String print() {
>         return "B";
>     }
> }
>
> public class DefaultTest implements A, B {
>
>     public String print() {
>         return A.super.print();
>     }
>
>     public static void main(String[] args) {
>         System.out.println(new DefaultTest().print());
>     }
> }
>```
> > Output: A
>
> Here the `DefaultTest` class is choosing interface A providing method with the help of **super** keyword.
