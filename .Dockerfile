FROM openjdk:8-jre-alpine

ENV LANG C.UTF-8
RUN mkdir /app
WORKDIR /app
COPY target/theprojectspringboot-1.0.0.jar  theprojectspringboot.jar 

ENTRYPOINT exec java \
$JAVA_OPTS \
$APP_ARGS
EXPOSE 9090
