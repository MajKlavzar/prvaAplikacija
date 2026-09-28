# PrvaAplikacija

**PrvaAplikacija** is an Android application developed in Java as an introductory project showcasing modern Android development practices, Material Design components, and interactive UI elements.

---

## 🚀 Features

- **Interactive Main Button**: Tapping the main button displays a toast message ("My first Android Studio application!").
- **Floating Action Button (FAB) & Snackbars**: 
  - Triggers standard or custom styled Snackbars depending on UI state.
- **Conditional Toast-like Snackbar**: When the **CheckBox** is checked, clicking the FAB displays a centered, styled custom Snackbar mimicking a toast notification with rounded corners and custom elevation.
- **Edge-to-Edge Support**: Implements modern Android Edge-to-Edge display handling via `EdgeToEdge.enable(this)` and system window insets listener.

---

## 🛠️ Tech Stack & Libraries

- **Language**: Java
- **UI Layout**: XML Layouts (`ConstraintLayout`)
- **Design System**: Material Design Components (`com.google.android.material`)
- **Android SDK**:
  - `minSdk`: 24 (Android 7.0 Nougat)
  - `targetSdk` / `compileSdk`: 37
- **Key Jetpack Libraries**:
  - `androidx.appcompat:appcompat`
  - `androidx.constraintlayout:constraintlayout`
  - `androidx.activity:activity-ktx` (Edge-to-Edge)
  - `com.google.android.material:material`

---

## 📂 Project Structure

```text
PrvaAplikacija/
├── app/
│   ├── build.gradle.kts           # App-level build configuration
│   └── src/
│       └── main/
│           ├── AndroidManifest.xml # App manifest and component declarations
│           ├── java/com/example/prvaaplikacija/
│           │   └── MainActivity.java # Main Activity handling UI interactions & custom Snackbar
│           └── res/
│               ├── layout/
│               │   └── activity_main.xml # Main UI layout (ConstraintLayout)
│               └── values/
│                   ├── strings.xml # App strings and labels
│                   └── themes.xml  # App themes and styling
└── build.gradle.kts               # Root build configuration
```

---

## 🏁 Getting Started

### Prerequisites
- [Android Studio](https://developer.android.com/studio) (latest stable version recommended)
- Android SDK with API 37 support
- Android Emulator or physical device running Android 7.0 (API 24) or higher

### Running the App
1. Clone or open this repository in Android Studio.
2. Wait for Gradle sync to complete.
3. Select an emulator or connected Android device.
4. Click the **Run** (`▶`) button in Android Studio to build and launch the app.
