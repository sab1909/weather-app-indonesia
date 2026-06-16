-keep class com.weather.indonesia.data.model.** { *; }
-keep class com.weather.indonesia.data.remote.** { *; }

-keep class retrofit2.** { *; }
-keepclasseswithmembers class retrofit2.** { *; }
-keepattributes Signature
-keepattributes *Annotation*

-keep class com.google.gson.** { *; }
-keepclassmembers class * {
    @com.google.gson.annotations.SerializedName <fields>;
}

-keep class androidx.room.** { *; }
-keepclasseswithmembernames class androidx.room.** { *; }

-keep class com.google.dagger.hilt.** { *; }