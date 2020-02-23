FROM java:8

COPY test-service-1.0-SNAPSHOT.jar /opt
ENTRYPOINT ["/usr/bin/java", "-jar"]
CMD ["/opt/test-service-1.0-SNAPSHOT.jar"]