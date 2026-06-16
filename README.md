# Weather App Indonesia - Professional Edition

Aplikasi cuaca profesional untuk Indonesia dengan data real-time dari Open-Meteo dan BMKG.

## Features

- ☀️ **Real-time Weather Data** dari Open-Meteo API
- 🌦️ **BMKG Integration** untuk data cuaca lokal Indonesia yang akurat
- 📍 **Database Wilayah Indonesia Lengkap**
  - Provinsi
  - Kabupaten/Kota
  - Kecamatan
  - Desa
- 📱 **Modern UI** dengan Material Design 3
- 🗄️ **Local Storage** dengan Room Database
- 🎨 **Dark Mode Support**
- 🌍 **Multi-location** support
- ⚡ **Offline Support** dengan caching

## Tech Stack

- **Language**: Kotlin
- **UI**: Jetpack Compose
- **Architecture**: MVVM + Repository Pattern
- **Networking**: Retrofit + OkHttp
- **Database**: Room
- **Dependency Injection**: Hilt
- **Async**: Coroutines + Flow
- **API**:
  - [Open-Meteo](https://open-meteo.com/)
  - [BMKG](https://www.bmkg.go.id/)

## Setup Instructions

### Requirements
- Android Studio Giraffe or later
- Android SDK 24+
- Kotlin 1.9.21+
- Gradle 8.2+

### Installation

1. Clone repository
```bash
git clone https://github.com/sab1909/weather-app-indonesia.git
cd weather-app-indonesia
```

2. Open dengan Android Studio
```bash
open -a "Android Studio" .
```

3. Sync Gradle dependencies
4. Build & Run

## Project Structure

```
app/src/main/java/com/weather/indonesia/
├── data/
│   ├── api/
│   │   ├── WeatherApiService.kt
│   │   ├── NetworkModule.kt
│   │   └── ...
│   ├── database/
│   │   ├── LocationDatabase.kt
│   │   ├── LocationDao.kt
│   │   ├── entity/
│   │   └── ...
│   ├── model/
│   │   ├── WeatherData.kt
│   │   └── ...
│   └── repository/
│       ├── WeatherRepository.kt
│       └── ...
├── ui/
│   ├── screens/
│   │   ├── HomeScreen.kt
│   │   ├── DetailScreen.kt
│   │   └── SettingsScreen.kt
│   ├── theme/
│   │   ├── Color.kt
│   │   ├── Typography.kt
│   │   └── Theme.kt
│   ├── viewmodel/
│   │   └── WeatherViewModel.kt
│   ├── MainActivity.kt
│   └── Navigation.kt
└── WeatherApp.kt
```

## API Integration

### Open-Meteo API
```kotlin
BaseUrl: https://api.open-meteo.com/v1/
Endpoint: /forecast
Parameters:
  - latitude: Double
  - longitude: Double
  - current: String
  - timezone: String (default: Asia/Jakarta)
```

### BMKG API
```kotlin
BaseUrl: https://api.bmkg.go.id/
Integration untuk data cuaca lokal Indonesia
```

## Database Schema

### Locations Table
```sql
CREATE TABLE locations (
    id TEXT PRIMARY KEY,
    provinsi TEXT NOT NULL,
    kabupaten TEXT NOT NULL,
    kecamatan TEXT NOT NULL,
    desa TEXT NOT NULL,
    latitude REAL NOT NULL,
    longitude REAL NOT NULL
);
```

## Build & Deploy

### Release Build
```bash
./gradlew bundleRelease
```

### Generate APK
```bash
./gradlew assembleRelease
```

### Upload ke Play Store
1. Generate keystore
2. Sign release build
3. Upload ke Google Play Console

## Permissions

```xml
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
<uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
```

## Next Steps untuk Production

- [ ] Implement location permission handling
- [ ] Add proper error handling & retry logic
- [ ] Implement weather icons mapping
- [ ] Add 7-day forecast
- [ ] Add search locations feature
- [ ] Implement favorites/bookmarks
- [ ] Add push notifications untuk alerts cuaca
- [ ] Optimize database queries
- [ ] Add unit tests
- [ ] Add UI tests
- [ ] Setup CI/CD pipeline

## License

MIT License - Free for commercial use

## Support

Untuk pertanyaan atau issues, silakan buka issue di GitHub atau hubungi developer.

---

**Build dengan ❤️ untuk Indonesia**