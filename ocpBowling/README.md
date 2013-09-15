http://www.slideshare.net/PaulBlundell2/open-closedprinciple-kata

Fork / Clone this repo

Goto this folder:
github.com/novoda/dojos/tree/master/ocpBowling

Make a copy of this folder (rename default with a team name):
github.com/novoda/dojos/tree/master/ocpBowling/20130918-default

Update your pom with the new artifactId
Update the ocpBowling pom adding your module

Start!

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

Original Source: http://butunclebob.com/files/downloads/Bowling%20Game%20Kata.ppt

![OCP](http://4.bp.blogspot.com/-E-WFKuISIW8/T8pkHGxhZfI/AAAAAAAAGuc/GOE9zTw_I1U/s400/OpenClosedPrinciple.jpg)
