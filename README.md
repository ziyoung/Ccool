# Ccool

Classroom Object-Oriented Language like C.

## Introduction

Ccool is inspired by [Cool language](https://web.stanford.edu/class/cs143/). For most programmers,
they are more familiar with the C language.
So I want to develop a programming language that contains the features of the Cool language.

## Build

```shell script
mvn install && mvn package

mv ./target/Ccool-1.0-SNAPSHOT-shaded.jar some-dir

# compile
java -jar Ccool-1.0-SNAPSHOT-shaded.jar YourFile.ccool

# run
java YourFile
```

## Status

Working in progress. More features need to be added.

## Related Project

### go-lox

Lox programing language implementation in Go.
Repository: https://github.com/ziyoung/lox-go
 
