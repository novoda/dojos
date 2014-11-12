"Setup..." println
"sum2d := method(matrix," println 
"    res := List clone" println
"    matrix foreach(v,(res append(v sum))) sum" println
")" println

sum2d := method(matrix,
    res := List clone
    matrix foreach(v,(res append(v sum))) sum
)

"\nSum of [[1,2,3],[4,5,6]] => list(list(1,2,3), list(4,5,6)) = " print
sum2d(list(list(1,2,3), list(4,5,6))) println
