FROM alpine:3.19
ENV JAVA_HOME=/usr/lib/jvm/default-jvm
RUN apk update && apk add --no-cache openjdk21 bash && rm -rf /var/cache/apk/*
WORKDIR /app

COPY ./Java/cardapioAcai/cardapioAcai .
RUN chmod +x ./mvnw
CMD ["./mvnw", "spring-boot:run"]
