FROM gradle:jdk8 as gradlebuild
# 権限を変更して source を copy
ADD --chown=gradle:gradle . /work
WORKDIR /work
RUN /bin/sh -c gradle clean build

FROM openjdk:8-jre-alpine
# フォルダを作って jar をコピー
RUN mkdir -p /work
RUN apk --no-cache add tzdata && \
    cp /usr/share/zoneinfo/Asia/Tokyo /etc/localtime && \
    apk del tzdata
COPY --from=gradlebuild /work/build/libs /work

WORKDIR /work
ENV SPRING_PROFILES_ACTIVE=production
ENTRYPOINT ["sh","-c","java -jar -Dspring.profiles.active=${SPRING_PROFILES_ACTIVE} manmaruyoyaku-0.0.1-SNAPSHOT.jar"]