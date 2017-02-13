Setup
------------

http://www.cyber-dojo.com/ > Java Junit > Recently Used List

Fork / Clone this repo

Goto this folder:
`github.com/novoda/dojos/tree/master/recents-list`

Make a copy of the folder below (*rename default with a team name*):
`github.com/novoda/dojos/tree/master/recents-list/default`

Update the `settings.gradle` file in the root of `dojos` adding your module

run `./gradlew clean build` to ensure you are all set

How to do the kata
------------------

This is a silent kata which means NO TALKING. You work in pairs using the ping-pong pair-programming technique.
The first member of the pair writes a unit test, at this point the 2nd person can start writing the code that fixes it, once fixed the same person can execute a refactoring and write the next test, now it's time for the 1st person to repeat the process.


**Start!**
------------

Develop a recently-used-list class to hold strings
uniquely in Last-In-First-Out order.

o) A recently-used-list is initially empty.

o) The most recently added item is first, the least
   recently added item is last.

o) Items can be looked up by index, which counts from zero.

o) Items in the list are unique, so duplicate insertions
   are moved rather than added.

o) Null insertions (empty strings) are not allowed.

o) A bounded capacity can be specified, so there is an upper
   limit to the number of items contained, with the least
   recently added items dropped on overflow.
