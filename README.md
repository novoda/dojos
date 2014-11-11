dojos
=====

This is where the Novoda team do all their hacking

# Adding a new dojo

- create a new directory with the dojo's name
- create a `default` directory within which contains the build.gradle file and any source code
- a dojo level `build.gradle` containing 

```groovy
subprojects {
	apply from: '../default/build.gradle'
}
```
should be added to keep all the implementations using the same build

- implementations of the dojo should be at the same directory level as the default directory
- add the finished katas to the root `settings.gradle` as `dojo:implName`
