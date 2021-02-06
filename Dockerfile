FROM openjdk:11.0-jre
ADD target/stormrider_2020-0.0.1-SNAPSHOT.jar stormrider_2020-0.0.1-SNAPSHOT.jar
EXPOSE 8888
ENTRYPOINT ["java","-jar","stormrider_2020-0.0.1-SNAPSHOT.jar"]

#ARG JAR_FILE=target/*.jar
#COPY ${JAR_FILE} app.jar

#ENTRYPOINT ["java","-jar","/app.jar"]
