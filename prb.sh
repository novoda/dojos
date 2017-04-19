#!/bin/sh

# Exit immediately if a command exits with a non-zero status.
set -e

echo "\n######## Build anagrams/ ########"
anagrams/gradlew -p anagrams clean test

echo "\n######## Build bankAccount/ ########"
bankAccount/gradlew -p bankAccount clean test

echo "\n######## Build changeOfADollar/ ########"
changeOfADollar/gradlew -p changeOfADollar clean test

echo "\n######## Build cucumber-android/ ########"
cucumber-android/gradlew -p cucumber-android clean test

echo "\n######## Build dataMunging/ ########"
dataMunging/gradlew -p dataMunging clean test

echo "\n######## Build fizzBuzz/ ########"
fizzBuzz/gradlew -p fizzBuzz clean test

echo "\n######## Build gilded-rose/ ########"
gilded-rose/gradlew -p gilded-rose clean test

echo "\n######## Build haikuReview/ ########"
haikuReview/gradlew -p haikuReview clean test

echo "\n######## Build harry-potter/ ########"
harry-potter/gradlew -p harry-potter clean test

echo "\n######## Build lcd-digits/ ########"
lcd-digits/gradlew -p lcd-digits clean test

echo "\n######## Build leap-year/ ########"
leap-year/gradlew -p leap-year clean test
