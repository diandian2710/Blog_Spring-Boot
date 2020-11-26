FROM java:8
COPY *.jar /app.jar
CMD ["--server.port=8443"]
ENTRYPOINT ["java","-jar","/app.jar"]