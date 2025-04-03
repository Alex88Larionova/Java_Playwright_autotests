FROM mcr.microsoft.com/playwright:v1.40.0-focal

# Копируем приложение
WORKDIR /app
COPY target/fck-autotests-1.0-SNAPSHOT.jar /app/my-app.jar

# Команда для запуска приложения
CMD ["java", "-jar", "my-app.jar"]