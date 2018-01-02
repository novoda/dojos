# Inversion of Control Kata

<img src="default/app/src/main/res/drawable/ic_toaster.png" width="200">

Your employer is a fast growing start-up competing in the android hardware market with companies like Samsung, Huawei and Sony. The team put all their effort into the development of custom system apps (phone, browser and camera) and a launcher application for tablet's and phones.

Since Internet of Things is becoming a thing, your board decided to invest into the fast growing market of smart toasters!

Challenge accepted you said and quickly added a toaster widget to your launcher application - DONE!!!! 

When the first prototype of the toaster arrived you tried to deploy the app and suddenly got this error: **Not enough memory**. Why is that? Well the launcher you deployed on the toaster still contains the code for all the not needed apps like phone, browser etc. .

# Task

In order to fix this you will need to migrate the existing project into a structure that enables you to isolate the launcher code from the apps.

You're free to change the project structure to whatever comes to your mind, with one exception:
* The launcher application code needs to be in a different module than the app implementations and must not include any module that contains a concrete app implementation.

When there is still time left, try to go further so you can build an apk per device, e.g. a toaster apk that just contains the launcher and the toaster widget.

# Setup
Copy the **default** folder and name it according to your team, e.g. **volker_joe**. 

You will find a project using a very basic **Dagger2** setup. In order to simulate the different devices (phone, tablet, toaster), just manually change the AndroidDeviceFeature.
When launching the app you should see a launcher with the apps that your device supports.

