FROM node as webapp
WORKDIR /src/main/webapp
COPY src/main/webapp .
RUN npm ci
RUN npm run-script build



FROM maven:3.6.3-jdk-11 as src
WORKDIR /src
COPY src .
RUN mkdir -p src/main/resources/static
COPY --from=webapp src/main/webapp/build src/main/resources/static
RUN nvm clean verify



FROM openjdk:14-jdk-alpine
COPY --from=src /src/target/backend-0.0.1-SNAPSHOT.jar ./app.jar
EXPOSE 8080
RUN adduser -D user
USER user
CMD [ "sh", "-c", "java -Dserver.port=$PORT -Djava.security.egd=file:dev/./urandom -jar app.jar" ]