"Is nil equal false:" println
(nil = false) println
"Is nil equal true:" println
(nil = true) println

Vehicle := Object clone

Vehicle description := "A mode of transport"
Vehicle sound := method("Zoooom" println)
"Vehicles go:" println
Vehicle sound