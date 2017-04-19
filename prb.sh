#!/bin/sh

echo "\n######## Build anagrams/ ########"
anagrams/gradlew -p anagrams clean test

echo "\n######## Build bankAccount/ ########"
bankAccount/gradlew -p bankAccount clean test

echo "\n######## Build changeOfADollar/ ########"
changeOfADollar/gradlew -p changeOfADollar clean test

echo "\n######## Build cucumber-android/ ########"
cucumber-android/gradlew -p cucumber-android clean test
