FROM openjdk:10.0.1-10-jre-slim


WORKDIR /joal/

RUN apt-get update \
        && apt-get install -y ca-certificates curl \
        && JOAL_VERSION="2.1.7" \
        && curl -LO "https://github.com/anthonyraymond/joal/releases/download/v$JOAL_VERSION/joal.tar.gz" \
        && tar --wildcards -zxvf joal.tar.gz "jack-of-all-trades-$JOAL_VERSION.jar" \
        && mv "jack-of-all-trades-$JOAL_VERSION.jar" joal.jar \
        && rm joal.tar.gz \
        && apt-get remove -y curl \
        && rm -rf /var/lib/apt/lists/*

ENV JOAL_WEB_ENVIRONMENT "true"
ENV JOAL_SERVER_PORT "8113"
ENV JOAL_PATH_PREFIX "mysupersecretpath"
ENV JOAL_SECRET_TOKEN "mysupersecrettoken"

EXPOSE 5081 8113 49152-65534

VOLUME /data

ENTRYPOINT ["java","-jar","/joal/joal.jar"]
CMD ["--joal-conf=/data --spring.main.web-environment=$JOAL_WEB_ENVIRONMENT --server.port=$JOAL_SERVER_PORT --joal.ui.path.prefix='$JOAL_PATH_PREFIX' --joal.ui.secret-token='$JOAL_SECRET_TOKEN'"]
