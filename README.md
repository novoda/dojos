dojos
=====

This is where the Novoda team do all their hacking

# Running a dojo

Find the module of the dojo you want to attempt. This will be a module under the root dir. Inside you will either find the  `default`  directory or a `java` and `swift` directory.

If you only find the  `default` directory, follow [these instructions](https://github.com/novoda/dojos#Updating-a-dojo). Once the folder structure has been updated properly you can continue, make a copy of the default project of whichever language you want to run the kata with.

Go inside this copy of the `default` directory,  and name it with the date and your name or pairing name. This dir you just copied should have instructions to run the dojo as well as any example code.

```
-dojos
|- theKata
    |- yourChoosenLanguage
        |- default
        |- 01012014-yourname-pairsname
```

## Android katas

- add the copied kata to the root `settings.gradle` as `theKata:01012014-yourname-pairsname`
```
include: 'theKata:default', 'theKata:01012014-yourname-pairsname'
```

# Starting a new dojo

- create a new directory inside root with the dojo's name
- create two directories inside the dojo's named `swift` and `java`
- create a `default` directory inside whichever language you want to run the kata on
- this `default` directory will contain any template source code and build.graddle file (if you are using a a java project)
- implementations of the dojo should be at the same directory level as the default directory

```
-dojos
|- myKata
    |- java
        |- default
        |- yourImpl
    |- swift
        |- default
        |- yourImpl
```
## Android katas

A dojo level `build.gradle` containing should be added to keep all the implementations using the same build.

```groovy
subprojects {
	apply from: '../default/build.gradle'
}
```
Add the finished kata's to the root `settings.gradle` as `dojo:implName`

```
include: 'myKata:default'
```

# Updating a dojo

If the dojo only contains the `default` folder, it means it has only been used for Android programming and the structure needs to be updated. Create two new folders with  `swift` and `java`  and add everything on the current source dojo folder into java.

```
-dojos
|- theKata
    |- swift
    |- java
        |- default
        |- 01012014-existingname-existingpair
```

Now you can [run a new dojo](https://github.com/novoda/dojos#running-a-dojo) on either language
