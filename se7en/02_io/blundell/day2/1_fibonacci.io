i := 0
prev := 0
prev2 := 1
result := 0
Fibonacci := Object clone
Fibonacci fib := method(position, 
					for(i, 0, position-1, 
						result := prev + prev2;
						prev2 := prev;
						prev := result);
						"Fibonacci position " print
						position print
						" is: " print
						result println
					)


Fibonacci fib(4)