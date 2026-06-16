# Installation Troubleshooting

## Common Issues & Solutions

### 1. Gradle Sync Error

**Problem**: "Failed to resolve: com.squareup.retrofit2:retrofit:2.9.0"

**Solution**:
```bash
./gradlew clean
./gradlew build --refresh-dependencies
```

### 2. Android SDK Not Found

**Problem**: "SDK location not found. Define location with an ANDROID_SDK_ROOT environment variable or by setting the sdk.dir path in your local properties file."

**Solution**:
```bash
# Create local.properties
echo "sdk.dir=/path/to/android/sdk" > local.properties
```

### 3. Kotlin Version Mismatch

**Problem**: "Kotlin version (1.8.0) is not supported"

**Solution**:
Update `build.gradle.kts`:
```gradle
id("org.jetbrains.kotlin.android") version "1.9.21" apply false
```

### 4. Database File Not Found

**Problem**: "Cannot open database file"

**Solution**:
```bash
# Create assets directory
mkdir -p app/src/main/assets/databases

# Generate database
sqlite3 app/src/main/assets/databases/locations.db < database_schema.sql
```

### 5. Permission Errors

**Problem**: "Permission Denied (os error 13)"

**Solution**:
```bash
# Make gradlew executable
chmod +x gradlew
```

### 6. Memory Issues

**Problem**: "java.lang.OutOfMemoryError: Java heap space"

**Solution**:
Update `gradle.properties`:
```properties
org.gradle.jvmargs=-Xmx2048m
```

### 7. API Connection Error

**Problem**: "Failed to connect to api.open-meteo.com"

**Solution**:
- Check internet connection
- Verify API is accessible
- Check firewall settings
- Add network security config

### 8. Emulator Issues

**Problem**: "Emulator hangs or crashes"

**Solution**:
```bash
# Wipe emulator data
emulator -avd <emulator_name> -wipe-data

# Or use different API level
```

### 9. Build Variant Issues

**Problem**: "Cannot find symbol class BuildConfig"

**Solution**:
```bash
./gradlew clean
./gradlew build
```

### 10. NDK Issues

**Problem**: "Unable to find NDK"

**Solution**:
Update SDK Manager:
- Android Studio → Tools → SDK Manager
- Install NDK

## Performance Issues

### Slow Build Time
```gradle
// gradle.properties
org.gradle.parallel=true
org.gradle.workers.max=8
kotlin.incremental=true
```

### High APK Size
```gradle
// app/build.gradle.kts
android {
    bundle {
        enableSplit = true
    }
}
```

### Memory Leaks
- Use AndroidStudio Memory Profiler
- Check for circular references
- Dispose resources properly

## Testing

### Run Tests
```bash
./gradlew test                    # Unit tests
./gradlew connectedAndroidTest    # Instrumented tests
./gradlew testDebug               # Debug build tests
```

### Debug APK
```bash
./gradlew installDebug
adb shell am start -n com.weather.indonesia/.ui.MainActivity
```

## Release Build Issues

### ProGuard Errors
```gradle
// app/proguard-rules.pro
-keep class com.weather.indonesia.** { *; }
```

### Signing Issues
```bash
# Check keystore
keytool -list -v -keystore weather-app.jks
```

## Useful Commands

```bash
# Clean project
./gradlew clean

# Build debug APK
./gradlew assembleDebug

# Build release APK
./gradlew assembleRelease

# Build app bundle
./gradlew bundleRelease

# Install on device
adb install -r app/build/outputs/apk/debug/app-debug.apk

# View logs
adb logcat

# Clear app data
adb shell pm clear com.weather.indonesia

# Uninstall app
adb uninstall com.weather.indonesia
```

## Getting Help

1. **GitHub Issues**: https://github.com/sab1909/weather-app-indonesia/issues
2. **Android Docs**: https://developer.android.com/docs
3. **Stack Overflow**: Tag: `android` or `kotlin`
4. **Android Studio Docs**: Built-in help (F1)

## Additional Resources

- [Android Studio Setup](https://developer.android.com/studio/intro)
- [Kotlin Documentation](https://kotlinlang.org/docs/)
- [Jetpack Compose](https://developer.android.com/jetpack/compose)
- [Room Database](https://developer.android.com/training/data-storage/room)
- [Retrofit](https://square.github.io/retrofit/)
- [Hilt DI](https://dagger.dev/hilt/)

---

**Need more help? Check the issues or documentation!**