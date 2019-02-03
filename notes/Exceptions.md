# Exceptions

* Exceptions are caught using a ***try block***:
* Exceptions are thrown using a ***throw statement***.
* If an exception is thrown in code that is not inside a try block, or is in a try block with no catch clause for the thrown exception, the exception is "passed up" the call stack.
* Some exceptions are checked and some are unchecked. If a function might throw one or more checked exceptions, they must be listed in the function's ***throws*** clause.
* Exceptions are objects; they are defined as ***classes*** (the class name is the name of the exception) that extend the Exception class.

Catch exceptions using try blocks:
```java
try {
   // statements that might cause exceptions
   // possibly including function calls
} catch ( exception-1 id-1 ) {
   // statements to handle this exception 
} catch ( exception-2 id-2 ) {
   // statements to handle this exception 
.
.
.
} finally {
   // statements to execute every time this try block executes
}
```

1.  Each catch clause specifies the type of one exception, and provides a name for it (similar to the way a function header specifies the type and name of a parameter). Java exceptions are objects, so the statements in a catch clause can refer to the thrown exception object using the specified name.
2.  The finally clause is optional.
3.  In general, there can be one or more catch clauses. If there *is* a finally clause, there can be zero catch clauses.

| Built-in Exceptions              | Description                                                                                                                                                     |
| -------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| *ArithmeticException*            | It is thrown when an exceptional condition has occurred in an arithmetic operation.                                                                             |
| *ArrayIndexOutOfBoundsException* | It is thrown to indicate that an array has been accessed with an illegal index. The index is either negative or greater than or equal to the size of the array. |
| *ClassNotFoundException*         | This exception is raised when we try to access a class whose definition is not found.                                                                           |
| *FileNotFoundException*          | An exception that is raised when a file is not accessible or does not open.                                                                                     |
| *IOException*                    | It is thrown when an input-output operation is failed or interrupted.                                                                                           |
| *InterruptedException*           | It is thrown when a thread is waiting, sleeping, or doing some processing, and it is interrupted.                                                               |
| *NoSuchFieldException*           | It is thrown when a class does not contain the field (or variable) specified.                                                                                   |



## References
* [throw and throws in Java](https://www.geeksforgeeks.org/throw-throws-java/)
* [java exception handling best practices](https://howtodoinjava.com/best-practices/java-exception-handling-best-practices/)
* [CS368: Exceptions (cs.wisc.edu)](http://pages.cs.wisc.edu/~hasti/cs368/JavaTutorial/NOTES/Exceptions.html)
* [8.3 Exceptions and try..catch (http://math.hws.edu)](http://math.hws.edu/javanotes/c8/s3.html)