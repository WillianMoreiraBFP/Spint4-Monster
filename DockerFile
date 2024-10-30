# Use a imagem base do OpenJDK
FROM openjdk:11

# Definir o diretório de trabalho
WORKDIR /app

# Copiar os arquivos do projeto para o contêiner
COPY . .

# Construir a aplicação
RUN ./mvnw clean package

# Comando para iniciar a aplicação
CMD ["java", "-jar", "target/Spint4_Monster-4.0-SNAPSHOT.jar"]
