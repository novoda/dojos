"Io seems strongly typed" println
"Not sure if possible to change typed behaviour by overriding correct slots" println

Descript := Object clone
Descript desc := method(
"\nId " print
call target uniqueId println

"type " print
call target type println

"proto " print
call target proto println
)

Car := Descript clone
Car what := "Ah"

NotCar := Descript clone
NotCar what := "Oh"

acar := Car clone
nocar := NotCar clone

acar desc
nocar desc

"We can fool the type slot" println
"acar type = \"NotCar\"" println

acar type = "NotCar"
acar desc

"We can fool the proto slot" println
"acar proto = NotCar" println

acar proto = NotCar
acar desc

"But the object still behaves as the old proto" println
"acar what print" println
acar what println

"\nUnless their is extra slots involved in the message passing process it seems like Io is strongly typed" println
