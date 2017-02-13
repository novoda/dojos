>"A good method name is worth a thousand words"

Setup
------------

> http://www.cyber-dojo.com/ > Java Junit > Recently Used List

 1. Fork / Clone this repo and create a new branch for your pair.
 2. Goto the `/silent-kata-rul` folder
 3. Make a copy of the `default` folder and rename it.
 4. Update the `settings.gradle` file in the root of `dojos` adding your new module
 5. Import the project in your IDE
 6. Run the tests from the IDE or from the command-line: `./gradlew :silent-kata-rul:my-pair-name:check` to ensure you are all set

How to do the kata
------------------

https://github.com/goeckeler/katas/blob/master/katas/Tic%20Tac%20Toe/README.md#silent-pairing 

This can be done in person or via ScreenHero. If you want to go HARDCORE use ScreenHero and click on the 'Mute' button.

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
