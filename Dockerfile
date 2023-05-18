# Utilisez l'image de base OpenJDK pour Java 17
FROM openjdk:18

# Copiez le jar de votre application dans le conteneur
COPY target/todo-app-1.0-SNAPSHOT.jar /app.jar

# Exposez le port sur lequel votre application écoute
EXPOSE 8080

# Commande pour lancer votre application lorsque le conteneur démarre
CMD ["java", "-jar", "/app.jar"]
