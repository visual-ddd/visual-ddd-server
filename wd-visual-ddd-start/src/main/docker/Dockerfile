FROM openjdk:8-jre-alpine
ADD target/*.jar app.jar
EXPOSE 8080
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && \
    echo 'Asia/Shanghai' >/etc/timezone
ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTIONS} -jar /app.jar ${EXTENSION_PARAMS}"]