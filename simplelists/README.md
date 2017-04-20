Setup
------------

http://codekata.com/kata/kata21-simple-lists/

Fork / Clone this repo

Goto this folder:
`github.com/novoda/dojos/tree/master/simplelists`

Make a copy of the folder below (*rename default with a team name*):
`github.com/novoda/dojos/tree/master/simplelists/default`

Update the `settings.gradle` file in the root of `dojos` adding your module

run `./gradlew clean build` to ensure you are all set


**Start!**
------------

For this kata we’re going to code up three implementations of a list that has the following basic interface:

- The list consists of nodes. Each node has a string value, along with whatever housekeeping the list itself needs.
- New nodes are added to the end of the list.
- You can ask the list if it contains a given string. If it does, it returns the string.
- You can delete a node from the list.
- You can ask the list to return an array of all its values.

For the kata, where the idea is to practice, let’s write one of three implementations of the list:

- A singly linked list (each node has a reference to the next node).
- A doubly linked list (each node has a reference to both the next and previous nodes).
- Some other implementation of your choosing, except that it should use no references (pointers) to collect nodes together in the list.

Obviously, we won’t be using predefined library classes as our list implementations…

**Objectives**
--------------

There’s nothing magical or surprising in list implementations, but there are a fair number of boundary conditions. For example, when deleting from the singly-linked list, did you have to deal with the case of deleting the first element in the list specially?

For this kata, concentrate on ways of removing as many of these boundary conditions as possible. Then ask yourself: Is the resulting code, which will contain fewer special cases, easier to read and maintain? How easy was it to eliminate these special cases? Were there trade-offs, where removing a special case in one area complicated the code in another. Is there a sweet-spot when it comes to simplifying code?
