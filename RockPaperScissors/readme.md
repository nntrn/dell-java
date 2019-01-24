# Rock Paper Scissors

1. [Requirements](#requirements)
2. [Notes](#notes)
   1. [using switch or if statements for `getGameResults()`](#using-switch-or-if-statements-for-getgameresults)
3. [sources](#sources)
   1. [random](#random)
      1. [1. Using Math.random()](#1-using-mathrandom)
      2. [2. Using Random class in Java.](#2-using-random-class-in-java)
4. [footnotes](#footnotes)

For this assignment we will create a program can play "Rock Paper Scissors".

## Requirements
Your program should:

* Ask the user for their hand (Rock, Paper, or Scissors).
* Generate a random value as the computer's hand.
* Print out both the user's hand and the computer's hand to the screen.
* Compare the user's hand against the computer's hand.
* Print out who won.

Guidelines:

Your implementation should be broken down into different methods.
* Each method should have a well defined "job".

* Extra features (optional):

  * Add input checks to your program. What happens when the user enters something other than "rock", "paper", or "scissors"? Should the input be case-sensitive? What if they spell "scissors" incorrectly?
  * Multi-modal Rock Paper Scissors: At the start of the game, allow the user to choose between "Rock, Paper, Scissors" or a different trio of objects ("Earth, Fire, Water" or "Bear, Hunter, Ninja" etc.) Gameplay remains the same.
  * International Rock Paper Scissors: Similar to multi-modal feature above. Variations on Rock Paper Scissors exist in countries all around the world. "Localize" your game by allowing the user to select between countries and/or languages in which to play the game.

## Notes

### using switch or if statements for `getGameResults()`

```java
if (result == 0)
	System.out.println("TIE");

if (result == -1)
	System.out.println("COMP WINS");

if (result == 1)
	System.out.println("USER WINS");
```
```java   
switch (result) {
  case 0:
    System.out.println("TIE");
    break;
  case 1:
    System.out.println("USER WINS");
    break;
  case -1:
    System.out.println("COMP WINS");
    break;
}
 ```

 Prefer switch if the number of cases are more than 5 otherwise, you may use if-else too<sup>[1](#switch-vs-if)</sup>



## sources

### random
source: [a/5887736](https://stackoverflow.com/a/5887736) by @zengr on stackoverflow

```
int max = 50;
int min = 1;
```

#### 1. Using Math.random()
```java
double random = Math.random() * 49 + 1;
```
or
```
int random = (int )(Math.random() * 50 + 1);
```
> This will give you value from 1 to 50 in case of int or 1.0 (inclusive) to 50.0 (exclusive) in case of double
> 
> Why?
>
> random() method returns a random number between 0.0 and 0.9..., you multiply it by 50, so upper limit becomes 0.0 to 49.999... when you add 1, it becomes 1.0 to 50.999..., now when you truncate to int, you get 1 to 50. (thanks to @rup in comments). leepoint's awesome write-up on both the approaches.

#### 2. Using Random class in Java.
Random rand = new Random(); 
int value = rand.nextInt(50); 
This will give value from 0 to 49.

For 1 to 50: rand.nextInt((max - min) + 1) + min;

Source of some Java Random awesomeness.

## footnotes

<a id="switch-vs-if">1</a>: “Switch vs If Else.” GeeksforGeeks, 20 May 2017, www.geeksforgeeks.org/switch-vs-else/.