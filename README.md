# Katas in Scala [![Build Status](https://travis-ci.org/amaalali/katas-scala.svg?branch=master)](https://travis-ci.org/amaalali/katas-scala)
Misc katas done Scala, using ScalaTest as the testing framwork.

## Katas List
- [x] Fizzbuzz Kata (package name `kata.fizzbuzz`)
        A kata where for inputs of integers, the result should be:
           - "fizz" if its divisible by 3
           - "buzz" if its divisible by 5
           - "fizzbuss" if it is divisible by 15
           - the input if its none of the above

- [x] Tennis Kata (package name `kata.tennis`)
        Model the game scoring of a single tennis match for two players.

- [x] Newton's method (package name `numerical`)
        Determines the square root of an input to 4 dp

- [x] Rotated Words (package name `kata.rotatedWords`)
        Partition a sequence of words into groups that are rotations of each other.
        eg  "abc", "bca" and "cab" are rotations
            "abc" and "bac" are NOT rotations

## Test
Run test using `sbt test`

Run all tests using
```
sbt test
```
or
```
sbt ~test
```
