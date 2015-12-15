Setup
------------

Fork / Clone this repo

Goto this folder:
`github.com/novoda/dojos/tree/master/leap-year`

Make a copy of the folder below (*rename default with a team name*):
`github.com/novoda/dojos/tree/master/leap-year/default`

Update the `settings.gradle` file in the root of `dojos` adding your module

run `./gradlew clean build` to ensure you are all set

**Start!**
------------

Your task is to create an LCD string representation of an
integer value using a 3x3 grid of space, underscore, and
pipe characters for each digit. Each digit is shown below
(using a dot instead of a space)

._.   ...   ._.   ._.   ...   ._.   ._.   ._.   ._.   ._.
|.|   ..|   ._|   ._|   |_|   |_.   |_.   ..|   |_|   |_|
|_|   ..|   |_.   ._|   ..|   ._|   |_|   ..|   |_|   ..|


Example: 910

._. ... ._.
|_| ..| |.|
..| ..| |_|
