"Io> 1 + 1" println
ans := 1 + 1
ans println

/*
    Io seems to be a strongly typed language
    It throws an exception complaining about different types,
    saying that the argument to the + method needs to be a Number
*/
"Io> 1 + \"one\"" println
"// throws exception, so omitted" println

/*
    I thought I could overwrite the "one" Sequence using the value 1
    but it seems to have no effect. I would have expected that it
    would throw an exception here too.
*/
"Io> \"one\" := 1" println
"one" := 1
"one" println
"one" type
"one" proto

"Io> (true and 0)" println
(true and 0) println

/*
    0's value is true. I found out later that you can also check
    whether something is true using the `isTrue` method on that obj.
    `0 isTrue` will return `true`
*/


// TODO: ans.3, ans.4, do.2
