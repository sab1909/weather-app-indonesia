# Setup Guide - Weather App Indonesia

## Prerequisites
- Android Studio Giraffe atau lebih baru
- Android SDK 24+ (API Level 24)
- Kotlin 1.9.21+
- Gradle 8.2+
- Java 17+
- Git

## Step 1: Clone Repository

```bash
git clone https://github.com/sab1909/weather-app-indonesia.git
cd weather-app-indonesia
```

## Step 2: Setup Android Studio

1. Buka Android Studio
2. Pilih **File** → **Open**
3. Navigate ke folder `weather-app-indonesia`
4. Klik **OK**
5. Android Studio akan otomatis sync Gradle dependencies

## Step 3: Konfigurasi Database

### Opsi A: Menggunakan Database Pre-built

1. Buat folder untuk database:
   ```bash
   mkdir -p app/src/main/assets/databases
   ```

2. Salin file database ke folder tersebut (akan dibuat otomatis dari SQL script)

### Opsi B: Membuat Database dari SQL Script

1. Buka terminal/command prompt
2. Jalankan script untuk generate database:
   ```bash
   sqlite3 locations.db < database_schema.sql
   ```
3. Copy `locations.db` ke `app/src/main/assets/databases/`

## Step 4: Konfigurasi API Keys

### Open-Meteo API
- **Tidak perlu API key** - Free tier sudah unlimited
- Dokumentasi: https://open-meteo.com/en/docs

### BMKG API
- **Tidak perlu API key** - Public API
- Dokumentasi: https://www.bmkg.go.id/

## Step 5: Build & Run

### Run di Emulator

1. Buka **AVD Manager** (Tools → Device Manager)
2. Buat atau pilih emulator (Minimum API 24)
3. Klik **Run** atau tekan `Shift + F10`

### Run di Device Fisik

1. Enable **Developer Mode** di device
2. Connect via USB
3. Klik **Run** atau tekan `Shift + F10`

## Step 6: Testing

### Unit Tests
```bash
./gradlew test
```

### Android Tests
```bash
./gradlew connectedAndroidTest
```

### Build APK
```bash
./gradlew assembleDebug
```

## Step 7: Persiapan Release

### Generate Keystore
```bash
keytool -genkey -v -keystore weather-app.jks \
  -keyalg RSA -keysize 2048 -validity 10000 \
  -alias weather-app
```

### Build Release APK
```bash
./gradlew assembleRelease
```

### Build App Bundle (untuk Play Store)
```bash
./gradlew bundleRelease
```

## Step 8: Upload ke Play Store

1. Buat akun Google Play Developer (bayar $25 one-time)
2. Setup di Google Play Console
3. Create new app dengan nama: **Weather Indonesia**
4. Fill all required information:
   - Screenshots (minimum 2, maksimal 8)
   - App description
   - Category: Weather
   - Content rating
5. Upload App Bundle (`.aab` file)
6. Review dan approve oleh Google
7. Publish ke Play Store

## Troubleshooting

### Gradle Sync Error
```bash
./gradlew clean
./gradlew sync
```

### Database tidak ditemukan
- Pastikan folder `app/src/main/assets/databases/` ada
- File database harus bernama `locations.db`

### Permission Denied
```bash
chmod +x gradlew
```

### Build Error
```bash
./gradlew clean build
```

## Project Structure Detail

```
weather-app-indonesia/
├── app/
│   ├── build.gradle.kts          # App-level build config
│   ├── proguard-rules.pro         # Code obfuscation rules
│   └── src/
│       ├── main/
│       │   ├── java/com/weather/indonesia/
│       │   │   ├── data/          # Data layer
│       │   │   │   ├── api/       # API services
│       │   │   │   ├── database/  # Room DB
│       │   │   │   ├── model/     # Data models
│       │   │   │   └── repository/# Repositories
│       │   │   ├── ui/            # UI layer
│       │   │   │   ├── screens/   # Screens/Pages
│       │   │   │   ├── components/# Reusable components
│       │   │   │   ├── theme/     # Theme & colors
│       │   │   │   ├── viewmodel/ # ViewModels
│       │   │   │   ├── MainActivity.kt
│       │   │   │   └── Navigation.kt
│       │   │   ├── util/          # Utilities
│       │   │   └── WeatherApp.kt  # App entry point
│       │   ├── res/               # Resources
│       │   │   ├── values/        # Strings, colors, etc
│       │   │   ├── drawable/      # Icons & images
│       │   │   ├── layout/        # Layout files
│       │   │   └── xml/           # XML resources
│       │   └── AndroidManifest.xml
│       ├── test/                  # Unit tests
│       └── androidTest/           # Instrumented tests
├── build.gradle.kts              # Root build config
├── settings.gradle.kts           # Project settings
├── gradle/                       # Gradle wrapper
├── .gitignore                   # Git ignore rules
├── README.md                    # Project documentation
└── database_schema.sql          # Database schema
```

## Key Features

✅ Real-time weather data  
✅ BMKG integration  
✅ Complete Indonesia locations database  
✅ Material Design 3  
✅ Dark mode support  
✅ Offline support  
✅ Multi-language (ID/EN)  
✅ Temperature unit conversion  
✅ Weather alerts  
✅ Favorites locations  

## Next Steps

1. Customize app dengan branding Anda
2. Add weather icons/images
3. Implement more features (7-day forecast, hourly forecast, etc)
4. Add push notifications
5. Setup analytics
6. Test thoroughly sebelum release
7. Setup App Store listing

## Support & Documentation

- Android Development: https://developer.android.com/
- Jetpack Compose: https://developer.android.com/jetpack/compose
- Room Database: https://developer.android.com/training/data-storage/room
- Hilt DI: https://dagger.dev/hilt/
- Retrofit: https://square.github.io/retrofit/

## License

MIT License - Bebas untuk use komersial

---

**Happy Coding! 🚀**