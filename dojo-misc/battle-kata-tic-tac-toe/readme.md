Tic Tac Toe Battle Kata

## The aim

To create a tic tac toe playing bot, then that bot will battle other bots in a round robin tournament to find the bestest bot.

Each bot will play each other bot twice, taking turns going first.

## How to

Create a `my-cool-team-name.conf` in this directory.

```json
{
  "name": "my super cool team name",
  "path": "pathToMyCode/",
  "language": "java"
}
```

name: You or your teams name (this will be used n )
path: The classpath of your code*
language: The name of the language*

## Supported languages

`javascript` nodejs 6.7.0

`java` 1.8

`swift` 2.2.1

`kotlin` 1.0.4

`haskell` GCH 8.0.1

## Pathing

`javascript` pathToMyCode/YourFile.js

`java` pathToMyCode/  must contain a Main.java

`swift` pathToMyCode/  must contain a Main.swift

`kotlin` pathToMyCode/  must contain a Main.kt

`haskell` pathToMyCode/  must contain a Main.hs


## Arguments

Arg 1 - The board as a comma separated string. `-` is unplayed.
`-,X,-,0,-,X,-,0,-`

```
[ 0 | 1 | 2 ]
[ 3 | 4 | 5 ]
[ 6 | 7 | 8 ]
```

Arg 2 - The player key, X or 0.


## Playing a move

print out a single board index to the console. 0 - 8.

```
System.out.print("0");
```

## Scoring

a win is **2** points.

a draw is **1** point.

and a invalid move is **-1**!
