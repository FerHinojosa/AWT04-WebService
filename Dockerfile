FROM ubuntu
MAINTAINER Fernando Hinojosa (Fernando.Hinojosa@fundacion-jala.org)
RUN apt-get update && apt-get install -y default-jdk
COPY . /AWT04-WebService
ENTRYPOINT /bin/bash
EXPOSE 8080

