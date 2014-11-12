"Setup..." println
"toCall := Object clone" println
"toCall simple := method(\"simple executed\" println)" println
"toCall complex := \"\"complex executed\" println\"" println

toCall := Object clone
toCall simple := method("simple executed" println)
toCall complex := "\"complex executed\" println"

"\nSimple call..." println
"toCall getSlot(\"simple\") call" println

toCall getSlot("simple") call

"\nComplex call..." println
"doString(toCall getSlot(\"complex\"))" println

doString(toCall getSlot("complex"))
