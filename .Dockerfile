FROM anapsix/alpine-java:8

VOLUME /tmp
ADD /target/microservice-dashboard.jar dashboard.jar
RUN sh -c 'touch /dashboard.jar'
CMD java -Djava.security.egd=file:/dev/./urandom -jar /dashboard.jar