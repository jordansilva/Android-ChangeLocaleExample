Android-ChangeLocaleExample
===========================

Android application to change locale in android device.

This is a very simple sample application showing how to change device's language by programmatically.



<b><i>Don't work in Android 4.2+ because Google has changed protection_level of CHANGE_CONFIGURATION.</i></b>

> The protection level of CHANGE_CONFIGURATION (used to change language) permission has been changed to "system|signature|development" (v4.2) from "dangerous" (v4.1 and below).

### Workaround
- Root devices;
- Application signed by same key of ROM;
- Application native (inside ROM package);
- Using adb to give access (step-by-step below);

#### Giving Access to CHANGE_CONFIGURATION with ADB (Android v4.2+):</h5>
```Java
 adb shell
 // pm grant <package name> android.permission.CHANGE_CONFIGURATION
 pm grant com.jordan.location.app android.permission.CHANGE_CONFIGURATION
 ```

 

 
