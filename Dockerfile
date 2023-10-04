FROM openjdk:17
ARG JAR_FILE=target/topEduMonolitico-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} topEduMonolitico-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/topEduMonolitico-0.0.1-SNAPSHOT.jar"]