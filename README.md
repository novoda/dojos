dojos
=====

This is where the Novoda team do all their hacking

# Practicing a new dojo

- find the dojo's module you want to attempt this will be a module under the root dir
- inside this copy the `default` directory and name it with the date and your name or pairing name
- this dir you just copied should have instructions to run the dojo as well as any example code

```
-dojos
|- theKata
  |- default
  |- 01012014-yourname-pairsname
```

- add the copied kata to the root `settings.gradle` as `theKata:01012014-yourname-pairsname`

```
include: 'theKata:default', 'theKata:01012014-yourname-pairsname'
```

# Running a new dojo

- create a new directory inside root with the dojo's name
- create a `default` directory within which contains the build.gradle file and any template source code to start from
- a dojo level `build.gradle` containing 

```groovy
subprojects {
	apply from: '../default/build.gradle'
}
```
should be added to keep all the implementations using the same build

- implementations of the dojo should be at the same directory level as the default directory
 
```
-dojos
|- myKata
  |- default
  |- someonesImpl
```

- add the finished kata's to the root `settings.gradle` as `dojo:implName`

```
include: 'myKata:default'
```




