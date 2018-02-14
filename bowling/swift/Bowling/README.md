# TDD Bowling Kata

The game consists of 10 frames as shown above.  In each frame the player has
two opportunities to knock down 10 pins.  The score for the frame is the total
number of pins knocked down, plus bonuses for strikes and spares.

A spare is when the player knocks down all 10 pins in two tries.  The bonus for
that frame is the number of pins knocked down by the next roll.  So in frame 3
above, the score is 10 (the total number knocked down) plus a bonus of 5 (the
number of pins knocked down on the next roll.)

A strike is when the player knocks down all 10 pins on his first try.  The bonus
for that frame is the value of the next two balls rolled.

In the tenth frame a player who rolls a spare or strike is allowed to roll the extra
balls to complete the frame.  However no more than three balls can be rolled in
tenth frame.

Sources:
- [kata logs](http://kata-log.rocks/bowling-game-kata)
- [PowerPoint](http://butunclebob.com/files/downloads/Bowling%20Game%20Kata.ppt)

## How to start:

1. Write the first failing test. Then write code to make the first test pass. The code written should only be intended to make the first test pass.

2. Write the next failing test.

3. Can you make it pass by building on what you already written?
If yes, great! Go back to 2.
If not, refactor until you can.

The refactoring should bring the system to a state where it’s possible to implement the next test just by adding the necessary features. Be careful not to implement new functionality; the current test should still fail.

## How to evaluate the dojo:
- What was the first test? Was it useful? Did they write a good test?
- What decision (architecture-wise) did they make at the beginning? Did they stick to it? Was it useful (solves the problem) and how simple was it?
- Method extraction: did they extract any functionality to outside classes or protocols? If no, why not? Is the code still testable?
- Did they see possible flaws with their code after learning more about the requirements? How did they approach that?
