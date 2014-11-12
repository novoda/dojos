"Setup..." println
"oldDiv := Number getSlot(\"/\")" println
"Number / = method(x,y, if(x==0, 0, oldDiv(x,y)))" println

oldDiv := Number getSlot("/")
Number / = method(x,y, if(x==0, 0, oldDiv(x,y)))

"\n3/0 = " print
(3/0) println

"3/2 = " print
(3/2) println



