# Katas in Scala [![Build Status](https://travis-ci.org/amaalali/katas-scala.svg?branch=master)](https://travis-ci.org/amaalali/katas-scala)
Misc katas done Scala, using ScalaTest as the testing framwork.

## Katas List
- [x] Fizzbuzz Kata (package name `fizzbuzz`)
- [ ] Tennis Kata (package name `tennis`)

## Test
Run test using `sbt test`

Run test for single kata project using
```
sbt testOnly kata.<kata package name>
```
or
```
sbt ~testOnly kata.<kata package name>
```
