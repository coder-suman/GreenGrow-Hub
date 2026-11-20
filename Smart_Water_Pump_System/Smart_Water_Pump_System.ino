#include <WiFi.h>
#include <FirebaseESP32.h>

// WiFi setup
#define WIFI_SSID "SUMANWIFI"
#define WIFI_PASSWORD "suman1234567"

// Firebase setup
#define USER_EMAIL "project2demo@gmail.com"
#define USER_PASSWORD "1234567890"
#define FIREBASE_HOST "krishi-culture-application-default-rtdb.firebaseio.com"
#define FIREBASE_AUTH "AIzaSyDHxHHARyVeb5z_hNljhQ5KjNmu1gxQVH4"

// Pin definitions
#define SOIL_MOISTURE_PIN 34  // Analog input from soil sensor
#define RELAY_PIN 23          // Relay control pin

FirebaseData firebaseData;
FirebaseAuth auth;
FirebaseConfig config;

String userUID;

void setup() {
  Serial.begin(115200);

  pinMode(RELAY_PIN, OUTPUT);
  digitalWrite(RELAY_PIN, LOW); // Pump OFF initially

  WiFi.begin(WIFI_SSID, WIFI_PASSWORD);
  Serial.print("Connecting to Wi-Fi");
  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }
  Serial.println("\nConnected to Wi-Fi");

  config.api_key = FIREBASE_AUTH;
  config.database_url = FIREBASE_HOST;

  auth.user.email = USER_EMAIL;
  auth.user.password = USER_PASSWORD;

  Firebase.begin(&config, &auth);
  Firebase.reconnectWiFi(true);

  // Wait for sign-in to complete and UID to be available
  Serial.print("Authenticating Firebase");
  while (auth.token.uid == "") {
    Serial.print(".");
    delay(100);
  }
  Serial.println("\nFirebase Authenticated");

  userUID = auth.token.uid.c_str();
  Serial.print("User UID: ");
  Serial.println(userUID);
}

void loop() {
  int soilMoistureValue = analogRead(SOIL_MOISTURE_PIN);
  Serial.print("Soil Moisture: ");
  Serial.println(soilMoistureValue);

  String pumpPath = "/users/" + userUID + "/pumpControl";
  String moisturePath = "/users/" + userUID + "/SoilMoisture";

  // Read pump control value
  if (Firebase.getBool(firebaseData, pumpPath)) {
    bool pumpState = firebaseData.boolData();
    digitalWrite(RELAY_PIN, pumpState ? LOW : HIGH);
    Serial.println(pumpState ? "Pump ON" : "Pump OFF");
  } else {
    Serial.print("Error getting pumpControl: ");
    Serial.println(firebaseData.errorReason());
  }

  // Send soil moisture value
  if (Firebase.setInt(firebaseData, moisturePath, soilMoistureValue)) {
    Serial.println("Firebase updated.");
  } else {
    Serial.print("Firebase update failed: ");
    Serial.println(firebaseData.errorReason());
  }

  delay(2000);
}
