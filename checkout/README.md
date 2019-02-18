 # Checkout Kata
 
-----
 
 ## Problem Description
 ----
 The task is to implement the checkout for a bookshop that is also a pub. Lightly (stolen/adapted) from Dave Thomas's ['Back to the Checkout' ](http://codekata.com/kata/kata09-back-to-the-checkout/) kata.
 
## Tasks

1. Basic functionality (simple pricing) 
2. Multiple item discount for a single item (3 of x for 1.30) 
3. Multiple item discount for a group of items (3 for 2, buy one, get another 1/2 price)
4. Discount after a specific time of day (happy hour)
5. Customer loyalty card 1 (£10 off for every £100 spent).
6. Customer loyalty card 2 (stamp card - £10 for every 10 stamps) The system should work with both loyalty cards. 
7. Staff card - 33% flat discount, no special offers of any kind.
8. a) Multiple offer types can apply to the same item (can be part of a 3 for 2, and also 20
   b) If multiple offers apply, only the one that gives the single greatest discount is applied).
9. (stretch) Consider how future arbitrary rules might be applied

## Some example prices

 | Item   |  Unit Price   |   Special Price |
 |---|---|---|
 | A  | 50  | 3 for 130 |
 | B  | 30 | 2 for 45 |
 | C  | 20 | none |
 | D | 15 |  3 for 2 |
 | E | 10 | 3 for 2 |
 | F | 15| 10 if after 5pm (happy hour) |
 | G | 35 | 10 if after 5pm, 3 for 2 |
 | H | 40  |    3 for 2, 2 for 60|
 | I | 50 | 3 for 100, 3 for 2, |