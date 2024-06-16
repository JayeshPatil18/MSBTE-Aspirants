<div align="left">
  <h1>MSBTE Aspirants 🚀 - Android App</h1>
  <img alt="Android" src="https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white" style="margin-left: 10px;">
  <img alt="Java" src="https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=java&logoColor=white" style="margin-left: 10px;">
  <img alt="Firebase" src="https://img.shields.io/badge/Firebase-FFCA28?style=for-the-badge&logo=firebase&logoColor=black" style="margin-left: 10px;">
  <a href="https://play.google.com/store/apps/details?id=com.msbteapp.msbtewallah">
    <img alt="Play Store" src="https://img.shields.io/badge/Google_Play-34A853?style=for-the-badge&logo=google-play&logoColor=white" style="margin-left: 10px;">
  </a>
  <a href="https://github.com/JayeshPatil18/MSBTE-Aspirants">
    <img alt="GitHub" src="https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white" style="margin-left: 10px;">
  </a>
</div>
</br>

Welcome to **MSBTE Aspirants**, the essential app for MSBTE I Scheme Diploma students. This app is designed to help you excel in your diploma courses in Engineering and Technology by providing crucial study materials, including books, notes, model question papers, solved lab manuals, and more.

</br>

*Available on Play Store.* [Click here](https://play.google.com/store/apps/details?id=com.msbteapp.msbtewallah)

![Available](https://github.com/JayeshPatil18/MSBTE-Aspirants/blob/master/msbte-aspirants.png)

## Description

**MSBTE Aspirants** is made to help MSBTE I Scheme Diploma students by providing important study material that is much needed to study diploma courses in Engineering and Technology diploma of MSBTE to score good marks in diploma semester exams. This App will provide you books, notes, model question papers, solved lab manuals, and many more for MSBTE I Scheme.

## Features

- **Study Material**: Access notes, books, and previous year question papers.
- **Solved Academic Manuals**: Get solutions to academic manuals.
- **Official MSBTE Website**: Quick access to the official MSBTE website.
- **Latest News Updates**: Stay updated with the latest news and posts.

## Technology Used

- **Android**: For a native mobile application.
- **Java**: For application logic and development.
- **XML**: For designing user interfaces.
- **Firebase**: Ensuring robust and scalable backend services including authentication, database, and cloud storage.

## Project Structure

We follow a clean architecture approach to ensure a scalable and maintainable codebase. Below is an overview of our project structure:

```plaintext
src
│
├── constants
│   ├── utils
│   ├── routes
│
├── features
│   ├── authentication
│   │   ├── data
│   │   │   └── repository
│   │   ├── domain
│   │   │   └── entities
│   │   ├── presentation
│   │       ├── bloc
│   │       ├── provider
│   │       ├── pages
│   │       └── widgets
│   │
│   ├── study_material
│       ├── data
│       │   └── repository
│       ├── domain
│       │   └── entities
│       ├── presentation
│           ├── bloc
│           ├── provider
│           ├── pages
│           └── widgets
```

## Getting Started

To get started with **MSBTE Aspirants**, follow these steps:

1. **Clone the repository**:
   ```bash
   git clone https://github.com/JayeshPatil18/MSBTE-Aspirants.git
   
## Install Android Studio

Download and install [Android Studio](https://developer.android.com/studio). Follow the installation instructions for your operating system.

## Set up Android SDK

1. Open Android Studio.
2. Navigate to `File > Settings > Appearance & Behavior > System Settings > Android SDK`.
3. **SDK Platforms tab:**
   - Ensure that `Android 10 (Q)` is checked or installed.
   
4. **SDK Tools tab:**
   - Install the latest version of `Android SDK Build-Tools`.

## Set up Android SDK

1. Open Android Studio.
2. Go to `File > Settings > Appearance & Behavior > System Settings > Android SDK`.
3. **SDK Platforms tab**:
   - Ensure that `Android 10 (Q)` is checked or installed.

4. **SDK Tools tab**:
   - Install the latest version of `Android SDK Build-Tools`.

## Install Java Development Kit (JDK)

Ensure you have JDK 8 or higher installed. You can download it from [Oracle's website](https://www.oracle.com/java/technologies/javase-downloads.html).


## Install Dependencies

Open a terminal in the project directory and run:

```bash
./gradlew build


## Connect Your Device

### For Physical Device

1. Enable `Developer Options` and `USB Debugging` on your Android device.
   - Go to `Settings` > `About phone`.
   - Tap on `Build number` multiple times until it says you are now a developer.
   - Go back to `Settings` > `Developer options`.
   - Enable `USB debugging`.

2. Connect your device to your computer via USB.

### For Virtual Device

1. Open Android Studio.
2. Go to `Tools` > `AVD Manager`.
3. Click on `Create Virtual Device`.
4. Choose a hardware profile and click `Next`.
5. Select a system image (Android version) and click `Next`.
6. Customize the virtual device configuration as needed (e.g., RAM size, VM heap size) and click `Finish`.
7. Start the virtual device by clicking the `Play` button next to the device name in the AVD Manager.
