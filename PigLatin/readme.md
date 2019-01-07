# Pig Latin

[view code](src/Main.java)

For this assignment we will create a program that will translate an English word using the rules of Pig Latin.

## The rules
* If a word starts with a vowel, add "yay" to the end. (elephant -> elephantyay)
* If a word starts with a consonant, and has a vowel in the word, move all the letters before the initial vowel to the end, then add "ay". (pig -> igpay)
* If a word does not have any vowels, then add "ay". (tsktsk -> tsktskay)

## Requirements
Your translator should:

* Ask the user for an English word.
* Print out the user's word translated into Pig Latin.

Extra features (optional):

* Randomizer: According to the official Pig Latin rules, words that start with a vowel can be translated by adding "yay", "way", or "ay" at the end. So the word "elephant" has three valid translations: "elephantyay", "elephantway", or "elephantay". Extend your translator to pick one of these three endings at random when translating words that begin with a vowel.
* Sentence translator: Use your Pig Latin word translator to create a translator for an entire sentence. The sentence translator should prompt the user for an English sentence, then print out the user's sentence translated into Pig Latin.

---

## notes

### ways to check if first letter is a vowel

import java.util.Arrays;


```
String[] values = {"a","e","i","o", "u"};
boolean contains = Arrays.stream(values).anyMatch(letter::equals);

System.out.println("aeiou: " + contains);
```


import java.util.regex.Matcher;
import java.util.regex.Pattern;

```
String pattern = "[aeiou]";
boolean isMatch = Pattern.matches(pattern, letter);

System.out.println("aeiou: " + isMatch);

```


## references

* [enable1.txt](https://code.google.com/archive/p/dotnetperls-controls/downloads) word list
* [SpellCheck.java](http://silo.cs.indiana.edu:8346/c212/milestones/ch15/section_3/) by Dan-Adrian German
* ['Searching through a Hashset for words within a file'](https://stackoverflow.com/a/34091909) on StackOverflow answered by Jiri Tousek