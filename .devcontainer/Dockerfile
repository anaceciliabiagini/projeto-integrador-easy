FROM ubuntu:24.04

ENV DEBIAN_FRONTEND=noninteractive

RUN apt-get update && apt-get install -y curl \
    && curl -fsSL https://deb.nodesource.com/setup_20.x | bash - \
    && apt-get update && apt-get install -y \
        git \
        git-lfs \
        openjdk-21-jdk \
        maven \
        mysql-server \
        nodejs \
    && rm -rf /var/lib/apt/lists/*

RUN echo "CREATE USER 'easy'@'localhost' IDENTIFIED BY 'Easy@123'; \
          GRANT ALL PRIVILEGES ON *.* TO 'easy'@'localhost' WITH GRANT OPTION; \
          CREATE DATABASE db_easypi; \
          FLUSH PRIVILEGES;" > /tmp/script.sql

RUN service mysql start && \
    sleep 5 && \
    mysql -uroot < /tmp/script.sql && \
    service mysql stop

WORKDIR /workspaces

CMD [ "bash" ]