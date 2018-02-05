dojos
=====

This is where the Novoda team do all their hacking

# Running a dojo

Find the module of the dojo you want to attempt. This will be a module under the root dir. Inside you will either find the  `default`  directory or a specific language directory.

If you only find the  `default` directory, follow [these instructions](#Updating-a-dojo). Once the folder structure has been updated properly you can continue, make a copy of the default project of whichever language you want to run the kata with.

Go inside this copy of the `default` directory,  and name it with the date and your name or pairing name. This dir you just copied should have instructions to run the dojo as well as any example code.
```
-dojos
|- theKata
    |- yourChoosenLanguage
        |- default
        |- 01012014-yourname-pairsname
```

## Android katas

Add the copied kata to the root `settings.gradle` as `theKata:01012014-yourname-pairsname`
```
include: 'theKata:default', 'theKata:01012014-yourname-pairsname'
```

# Starting a new dojo

- Create a new directory inside root with the dojo's name
- If the dojo targets specific programming languages like `Swift` or `Java`, create a directory with the name of the language. If the kata does not have a specific programming language you can place the code on root folder.
- create a `default` directory inside whichever language you want to run the kata on
- This `default` directory will contain any template source code and `gradle` file (if you are using a a Java project)
- Implementations of the dojo should be at the same directory level as the default directory
```
-dojos
|- myKata
    |- oneLanguage
        |- default
        |- yourImpl
    |- anotherLanguage
        |- default
        |- yourImpl
```
## Android katas

A dojo level `gradle` containing should be added to keep all the implementations using the same build.
```groovy
subprojects {
	apply from: '../default/build.gradle'
}
```
Add the finished katas to the root `gradle` as `dojo:implName`
```
include: 'myKata:default'
```

# Updating a legacy dojo

If the dojo only contains the `default` folder, it is possible that it has only been used for Android programming before and the structure needs to be updated. To do so create a `Java` folder and place all the code currently on root inside of the new folder (including the `default` folder). You can then create a new folder on the kata root with the new language you want to run the kata on if necessary.

```
-dojos
|- theKata
    |- oneLanguage
    |- existingLanguage
        |- default
        |- 01012014-existingname-existingpair
```

Now you can [run a new dojo](#running-a-dojo) on either language
