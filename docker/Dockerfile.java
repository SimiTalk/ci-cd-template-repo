ARG BASE_IMAGE
FROM ${BASE_IMAGE}
LABEL maintainer=caoxiaopeng

ENV APP_HOME=/app
ENV JAVA_OPTS=" -Xms1024m -Xmx3072m "
ENV ENV=""
ENV TZ=Asia/Hong_Kong

RUN ln -snf /usr/share/zoneinfo/Asia/Hong_Kong /etc/localtime && echo "Asia/Hong_Kong" > /etc/timezone
WORKDIR ${APP_HOME}

COPY --chown=1000 target/app.jar ${APP_HOME}/app.jar
CMD java -server -Dspring.profiles.active=${ENV} ${JAVA_OPTS} -jar ${APP_HOME}/app.jar