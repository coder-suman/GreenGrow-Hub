<div align="center">

# 🌾 GreenGrow Hub

**Farming, Protection, and Care in One App**

An all-in-one Android application that helps Indian farmers cultivate paddy and other crops with weather forecasts, ML-based recommendations, an e-commerce store for seeds and fertilizers, and an IoT-powered Smart Water Pump System.

![Platform](https://img.shields.io/badge/platform-Android-3DDC84?logo=android&logoColor=white)
![Language](https://img.shields.io/badge/language-Java-orange?logo=openjdk&logoColor=white)
![Backend](https://img.shields.io/badge/backend-Firebase-FFCA28?logo=firebase&logoColor=black)
![IoT](https://img.shields.io/badge/IoT-ESP32-E7352C?logo=espressif&logoColor=white)
![Min SDK](https://img.shields.io/badge/minSdk-24-blue)

</div>

---

## 📖 About

Farming in India is increasingly affected by unpredictable weather, limited access to local agricultural information and inefficient use of water and fertilizer. **GreenGrow Hub** (app name: *Krishi Culture*) brings guidance, decision-support tools and smart irrigation together in a single, easy-to-use Android app built for farmers with varying levels of technical literacy.

The project was developed as a **Bachelor of Computer Application (BCA)** final-year project at **Brainware University, Kolkata** (Department of Computational Sciences, 2025).

---

## ✨ Features

| Module | Description |
| ------ | ----------- |
| 🔐 **User Authentication** | Email-based registration and login with Firebase Authentication, plus a user profile. |
| 🌾 **Paddy Farming** | Step-by-step guidance for the three paddy seasons: **Aus, Aman and Boro**. Each season covers pre-nursery, growing, NPK/fertilizer and other tips, with embedded video tutorials. |
| ⚖️ **Laws Section** | Plain-language overview of the laws and policies around paddy farming: land use, subsidies, water management, environmental protection, crop protection and labour laws. |
| 🌱 **Seed Store** | Browse paddy seeds, add to cart, place orders and track them under *My Orders*. |
| 🧪 **Fertilizer Store** | Browse fertilizers with usage details, manage a cart, set a delivery address and view order history. |
| ⛅ **4-Day Weather Forecast** | Location-aware weather and a four-day forecast using the OpenWeatherMap API, to help plan irrigation, sowing and harvesting. |
| 🤖 **Crop Recommendation (ML)** | Suggests the most suitable crop from soil NPK, pH, temperature, humidity and rainfall. |
| 🧴 **Fertilizer Recommendation (ML)** | Recommends fertilizers from soil nutrient levels to avoid over- or under-application. |
| 💧 **Smart Water Pump System (IoT)** | An ESP32 with a soil moisture sensor reports moisture to Firebase, and the app turns the water pump on or off remotely. |
| 🥕 **Crop Care** | Growing guides for **24 crops**, each with nursery, growing, NPK and other-care tabs. |
| 💬 **Feedback** | Users can send feedback by email from inside the app. |

### Crop Care library

Tomato · Potato · Onion · Garlic · Ginger · Turmeric · Chili · Brinjal · Ladyfinger (Okra) · Cabbage · Cauliflower · Carrot · Radish · Beetroot · Coriander · Cucumber · Bitter Gourd · Bottle Gourd · Ridge Gourd · Pumpkin · Sweet Potato · Bean · Papaya · Lemon

---

## 🏗️ Architecture

```
┌────────────────┐        ┌─────────────────────┐
│  Android App   │◄──────►│  Firebase Auth / RTDB│◄──────┐
│  (Java)        │        └─────────────────────┘       │
│                │        ┌─────────────────────┐       │
│                │◄──────►│  OpenWeatherMap API  │   ┌───┴──────────────┐
│                │        └─────────────────────┘   │  ESP32 + Soil     │
│                │        ┌─────────────────────┐   │  Moisture Sensor  │
│                │◄──────►│  Flask ML API        │   │  + Relay + Pump   │
└────────────────┘        │  (Crop / Fertilizer) │   └──────────────────┘
                          └─────────────────────┘
```

- **Mobile app:** Native Android (Java) with ViewBinding, ViewPager fragments and Material components.
- **Database / Auth:** Firebase Authentication and Realtime Database.
- **Weather:** OpenWeatherMap API through OkHttp.
- **Machine learning:** Random Forest and SVM models trained on a Kaggle agriculture dataset, saved as `.pkl` files and served through a Flask web API. The app opens it in a `WebView`.
- **IoT:** ESP32 reads soil moisture and syncs with Firebase, and the app writes the pump on/off state.
- **Notifications and mail:** Firebase Cloud Messaging and JavaMail (Gmail SMTP) for feedback.

---

## 🛠️ Tech Stack

| Area | Technologies |
| ---- | ------------ |
| Android | Java, Android SDK 34 (min SDK 24), Gradle (Kotlin DSL), Material Components, ConstraintLayout |
| Backend | Firebase Authentication, Firebase Realtime Database, Firebase Cloud Messaging, Crashlytics |
| Networking | OkHttp, Google Play Services Location, JavaMail |
| ML | Python, Flask, scikit-learn (Random Forest, SVM), Pickle |
| IoT | ESP32, Arduino framework, FirebaseESP32 library |
| Design | Figma-style prototype (PDF) |

---

## 📂 Project Structure

```
GreenGrow-Hub/
├── GreenGrow Hub/               # Android Studio project
│   └── app/src/main/java/com/example/krishiculture/
│       ├── userlogin/           # Registration, login, user details
│       ├── ausFragment/         # Aus paddy guide
│       ├── amonFragment/        # Aman paddy guide
│       ├── boroFragment/        # Boro paddy guide
│       ├── seedsection/         # Seed store, cart and orders
│       ├── fertilizerStore/     # Fertilizer store, cart and orders
│       ├── weatherForecust/     # Weather and 4-day forecast
│       ├── CropProtection/      # Crop & fertilizer recommendation, water pump
│       ├── cropcare/            # 24 crop guides
│       ├── feedback/            # Feedback and mail
│       └── models/              # Data models
├── Smart_Water_Pump_System/     # ESP32 Arduino sketch
│   └── Smart_Water_Pump_System.ino
├── Design/                      # UI prototype (PDF)
├── Doucumentation/              # Full project report (PDF)
├── Logo/                        # App logo
└── README.md
```

---

## 🚀 Getting Started

### Prerequisites

- [Android Studio](https://developer.android.com/studio) (latest stable) with JDK 8 or higher
- A Firebase project (Authentication and Realtime Database enabled)
- An [OpenWeatherMap](https://openweathermap.org/api) API key
- *(Optional)* Arduino IDE and an ESP32 board for the water pump system
- *(Optional)* Python 3 for hosting the ML API

### 1. Clone the repository

```bash
git clone https://github.com/coder-suman/GreenGrow-Hub.git
cd GreenGrow-Hub
```

### 2. Set up Firebase

1. Create a project in the [Firebase Console](https://console.firebase.google.com/) and add an Android app with package name `com.example.krishiculture`.
2. Enable **Email/Password** authentication and the **Realtime Database**.
3. Download `google-services.json` and place it in `GreenGrow Hub/app/`.

### 3. Add your API keys

- Add your OpenWeatherMap key in the weather activities (`weatherForecust/`).
- Add the sender email credentials for feedback in `feedback/`.

> ⚠️ Keep keys and passwords out of version control. Prefer `local.properties` or `BuildConfig` fields.

### 4. Point the app at the ML service

The crop and fertilizer recommendation screens load a web page hosted by the Flask API. Update the `URL` constant in:

- `CropProtection/cropRecommendationActivity.java`
- `CropProtection/fertilizerRecommendationActivity.java`

### 5. Build and run

Open the `GreenGrow Hub` folder in Android Studio, let Gradle sync, then run on an emulator or device (Android 7.0+).

---

## 💧 Smart Water Pump System (ESP32)

The sketch in `Smart_Water_Pump_System/` reads soil moisture every 2 seconds, uploads it to Firebase, and switches the pump relay according to the `pumpControl` value set from the app.

### Hardware

- ESP32 microcontroller
- Capacitive/resistive soil moisture sensor
- 5V single-channel relay module
- 5V mini DC water pump
- DC-DC step-up module
- 9V battery or other power supply, plus jumper wires

### Wiring

| Component | Pin | Connects to |
| --------- | --- | ----------- |
| Soil moisture sensor | VCC / GND / A0 | ESP32 3V3 / GND / **GPIO 34** |
| Relay module | VCC / GND / IN | ESP32 VIN / GND / **GPIO 23** (via step-up module) |
| Water pump | + / − | Relay **NO** / battery − |
| Battery | + | Relay **COM** |

### Setup

1. Install the **FirebaseESP32** library in the Arduino IDE.
2. In the `.ino` file, set your Wi-Fi name and password and your Firebase host, API key and user credentials.
3. Upload to the ESP32 and open the Serial Monitor (115200 baud).
4. Open the app's water pump screen to see live moisture readings and control the pump.

---

## 🖼️ Documentation and Design

- 📄 **Project report:** [`Doucumentation/GreenGrow Hub Doc.pdf`](Doucumentation/GreenGrow%20Hub%20Doc.pdf) covers requirements, DFDs, use-case, activity and sequence diagrams, implementation and results.
- 🎨 **UI prototype:** [`Design/GreenGrow Hub Prototype.pdf`](Design/GreenGrow%20Hub%20Prototype.pdf)

<!-- Tip: add screenshots here, for example:
<p align="center">
  <img src="screenshots/home.png" width="200"/>
  <img src="screenshots/weather.png" width="200"/>
</p>
-->

---

## 🔮 Future Scope

- Port the app to **Flutter** for a smoother, cross-platform experience
- Integrate **NPK and pH sensors** for real-time soil nutrient and acidity readings
- Improve the crop prediction dataset to increase accuracy and reliability
- Collect active farmer feedback to refine features

---

## 👥 Team

Developed by BCA students of **Brainware University**, under the guidance of **Prof. Samrat Kundu** (Assistant Professor, Computational Sciences).

| Name |
| ---- |
| Suman Bajani ([@coder-suman](https://github.com/coder-suman)) |
| Kuntal Bera |
| Manish Giri |
| Jinat Yeasmin |
| Rinki Saha |

---



## 📜 License

No license has been added yet. To make the project open source, add a `LICENSE` file (for example [MIT](https://choosealicense.com/licenses/mit/)).

---

<div align="center">

🌱 *Empowering farmers through technology.* If you like this project, give it a ⭐

</div>
