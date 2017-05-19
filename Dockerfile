FROM java:8
VOLUME /tmp
ADD target/spring-demo.jar demo.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/demo.jar"]

