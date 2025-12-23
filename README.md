## Описание проекта:

Автоматизированные тесты для мобильного приложения Wikipedia

## Технологии:

- Java 11+
- Selenium WebDriver
- Appium
- TestNG
- Gradle

## Требования:

1. Java 11+ 
2. Gradle
3. Браузер Google Chrome 
4. Appium
5. Android Studio
6. Эмулятор Android (Pixel_9)
7. Приложение Wikipedia на эмуляторе

## Как запустить автотесты

### Клонируйте репозиторий:

```bash
git clone https://github.com/nikolay-977/appium-test-ng
cd selenium-test-ng
```

### Запустите эмклятор:

```bash
emulator -avd Pixel_9
```

### Установите приложение на эмклятор:

```bash
adb -s emulator-5554 install app-alpha-universal-release.apk
```

### Запустите appium:

```bash
appium -p 4723
```
### Запустите автотесты:

```bash
gradle clean test
```

### Скриншоты:
