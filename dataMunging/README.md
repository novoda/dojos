Setup
=================

Fork / Clone github.com/novoda/dojos

Goto this folder:
`dojos/dataMunging`

Make a copy of the default folder and **rename it with a team name**

Update the `settings.gradle` file in the root of `dojos` adding your module

run `../gradlew clean build` to ensure you are all set


Data Munging
============
Data munging kata gives you two different sets of real world data. For the beginning, you will work on each data set separately and **in a functional way** so you might want to check your toolbox for map, filter and reduce kind of things. 
In the second part, you will look at the two projects and try to abstract common functionality till a point which makes sense to you. 
You will be working in pairs. 

## Part One: Weather Data
In `weather.dat` you’ll find daily weather data for Morristown, NJ for June 2002.  
Write a program to output the day number (column one) with the smallest temperature spread (the maximum temperature is the second column, the minimum the third column).

## Part Two: Soccer League Table
The file `football.dat` contains the results from the English Premier League for 2001/2. The columns labeled ‘F’ and ‘A’ contain the total number of goals scored for and against each team in that season (so Arsenal scored 79 goals against opponents, and had 36 goals scored against them).  
Write a program to print the name of the team with the smallest difference in ‘for’ and ‘against’ goals.

## Part Three: DRY Fusion
Take the two programs written previously and factor out as much common code as possible, leaving you with two smaller programs and some kind of shared functionality.

## Kata Questions
- To what extent did the design decisions you made when writing the original programs make it easier or harder to factor out common code?

- Was the way you wrote the second program influenced by writing the first?

- Is factoring out as much common code as possible always a good thing? Did the readability of the programs suffer because of this requirement? How about the maintainability?
