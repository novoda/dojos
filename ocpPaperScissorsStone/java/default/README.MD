Rock beats Scissors.
Scissors beat paper.
Paper beats rock.

1. Write the first failing test. Then write a factory that returns an object, or an aggregate of objects, that make the test pass.

The factory should be limited to creating objects and linking them together. No conditionals allowed.

2. Write the next failing test.

3. Can you make it pass by changing the factory and/or creating a new class and nothing else?
If yes, great! Go back to 2.
If not, refactor until you can.

The refactoring should bring the system to a state where it’s possible to implement the next test just by changing the aggregate of objects that is returned by the factory. Be careful not to implement new functionality; the current test should still fail.

