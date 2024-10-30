# Use a imagem base do OpenJDK
FROM openjdk:11

# Instalar Maven
RUN apt-get update && apt-get install -y maven

# Definir o diretório de trabalho
WORKDIR /app

# Copiar os arquivos do projeto para o contêiner
COPY . .

# Construir a aplicação
RUN mvn clean package

# Comando para iniciar a aplicação
CMD ["java", "-jar", "target/Spint4_Monster-4.0-SNAPSHOT.jar"]
