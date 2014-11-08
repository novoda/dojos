"Setup..." println
"InvalidArgumentException := Exception clone" println
"List myAvg := method(if(self size != 0, self sum / self size, InvalidArgumentException raise(\"List is empty\")))" println

InvalidArgumentException := Exception clone
List myAvg := method(if(self size != 0, self sum / self size, InvalidArgumentException raise("List is empty")))

"\nCustom Average of list(1,2,3,4) = " print
list(1,2,3,4) myAvg println

"\nCustom Average of list() = " print

e := try(
    list() myAvg
)

e catch(InvalidArgumentException,
    writeln(e coroutine backTraceString)
)
