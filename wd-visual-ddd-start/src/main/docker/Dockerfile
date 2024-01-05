FROM openjdk:8-jre-alpine
ADD target/*.jar app.jar
EXPOSE 8080
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && \
    echo 'Asia/Shanghai' >/etc/timezone
ENV JAVA_OPTIONS=""
ENV EXTENSION_PARAMS=""
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTIONS $EXTENSION_PARAMS -jar /app.jar"]