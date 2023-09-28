FROM openjdk:8

COPY docker /app

RUN unzip /app/allure-commandline-2.23.0.zip -d /opt/allure > /dev/null

WORKDIR /app

EXPOSE 8080

ENTRYPOINT ["/app/report.sh"]
