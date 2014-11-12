fibRec := method(nth,

    if(nth == 1 or nth == 2, return 1)

    return fibRec(nth-1) + fibRec(nth-2)
)

"Recursive : " print
fibRec(6) println

fibLoop := method(nth,
    i := 3
    prevIt := 1
    prev2It := 1
    it := 0
    
    if(nth == 1 or nth == 2, return 1)
    
    while(i <= nth, it = prevIt + prev2It; prev2It = prevIt; prevIt = it; i = i + 1)

    return it
)

"Loop : " print
fibLoop(6) println
