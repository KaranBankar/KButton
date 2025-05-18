# KButton

KButton is a simple, elegant custom button. it has smooth click animations and easy customization.

## 🚀 Quick Start

### 1. Add the Dependency
Add the KButton library to your `build.gradle` dependencies:

```kotlin
dependencies {
    implementation("com.karan.kbutton:kbutton:v1.0.0")
}
```



### 2. Add Repository to settings.gradle.kts
Make sure your project includes the repository hosting KButton


```kotlin
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }
}
```

### 3. Use KButton in Your XML Layout

```xml
 <com.karan.kbutton.KButton
        android:layout_width="120dp"
        android:layout_height="50dp"
        android:layout_gravity="center"
        android:backgroundTint="#FF5722"
        app:kbutton_text="K Button" />

```
## Made with ❤️ by Karan Bankar

