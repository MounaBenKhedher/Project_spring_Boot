FROM openjdk:8-jdk-alpine
EXPOSE 8083
ADD target/project-0.0.3-SNAPSHOT.jar /project.war
ENTRYPOINT ["java", "-jar", "/project.war"]